package com.bancolombia.microcredito.usecase.finalizacion;

import com.bancolombia.microcredito.domain.calificacion.Calificacion;
import com.bancolombia.microcredito.domain.constantes.CodigosRespuestaFNG;
import com.bancolombia.microcredito.domain.constantes.ConstantesFNG;
import com.bancolombia.microcredito.domain.contadortoken.ContadorToken;
import com.bancolombia.microcredito.domain.error.ErrorRequestDTO;
import com.bancolombia.microcredito.domain.exception.FNGBusinessException;
import com.bancolombia.microcredito.domain.exception.FNGFailException;
import com.bancolombia.microcredito.domain.infocredito.InformacionCredito;
import com.bancolombia.microcredito.domain.informaciontransaccion.InformacionTransaccion;
import com.bancolombia.microcredito.domain.log.gateways.LoggerRepository;
import com.bancolombia.microcredito.domain.parameter.gateways.ConfigRepository;
import com.bancolombia.microcredito.domain.parametro.Parametro;
import com.bancolombia.microcredito.domain.planAmortizacion.FilaAmortizacion;
import com.bancolombia.microcredito.domain.planAmortizacion.PlanAmortizacion;
import com.bancolombia.microcredito.domain.respuestadescarga.RespuestaDescarga;
import com.bancolombia.microcredito.domain.respuestaservicio.RespuestaServicio;
import com.bancolombia.microcredito.domain.security.Payload;
import com.bancolombia.microcredito.domain.security.gateways.SecurityRepository;
import com.bancolombia.microcredito.domain.ventadigital.factory.VTDFactory;
import com.bancolombia.microcredito.domain.ventadigital.gateways.VentaDigitalRepository;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.List;

public class FinalizacionUseCase {

    private final VentaDigitalRepository entity;
    private final LoggerRepository log;
    private final SecurityRepository security;
    private final ConfigRepository config;

    public FinalizacionUseCase(VentaDigitalRepository entityInterface,
                               SecurityRepository securityInterface,
                               LoggerRepository log,
                               ConfigRepository configInterface) {
        super();
        this.log = log;
        this.entity = entityInterface;
        this.security = securityInterface;
        this.config = configInterface;
    }


    public RespuestaServicio changeState(Payload payload, String authorization) {

        String pasoAnterior = ConstantesFNG.pagina2FNG;
        String pasoActual = ConstantesFNG.pagina3FNG;
        //obtener venta digital anterior
        InformacionTransaccion infoVisitaVD = entity.getInformacionTransaccion (payload.getIdSesion (),
                pasoAnterior, pasoActual);
        //construir venta digital con nuevo paso
        InformacionTransaccion newVTD = new VTDFactory().buildInfoTransaction(pasoActual, infoVisitaVD);
        newVTD.getSolicitud().setEstadoId(ConstantesFNG.ESTADO_SOLICITUD_EN_PROCESO_ENTREGA);
        //guardar venta digital
        this.entity.saveInfoTransaccion(newVTD);
        //construir jwt
        String jwt = security.generateJwToken(authorization);

        return new RespuestaServicio(jwt, "authorization", "");

    }

    /**
     * Método que retorna la lista de parámetros a renderizar en el documento del plan de amortización
     *
     * @param informacionCredito
     * @return
     */
    private List<Parametro> obtenerDatosDescargaDocumento(InformacionCredito informacionCredito, String idSesion) {
        Gson gson = new Gson();
        String codigoProducto = ConstantesFNG.CONSTANTE_CODIGO_PRODUCTO;
        List<Parametro> listaParametros;
        PlanAmortizacion planAmortizacion = null;
        try {

            if (informacionCredito != null && StringUtils.isNotBlank(informacionCredito.getPlanAmortizacion())) {
                planAmortizacion = gson.fromJson(informacionCredito.getPlanAmortizacion(), PlanAmortizacion.class);
                List<FilaAmortizacion> filasAmortizacion = planAmortizacion.getListaAmortizacion();
                String comisionFng = planAmortizacion.getComisionFng();
                listaParametros = new VTDFactory().getParametrosPlan(filasAmortizacion, comisionFng);

            } else {
                throw new FNGBusinessException(CodigosRespuestaFNG.ERROR_PLAN_NULL.getCodigo(),
                        CodigosRespuestaFNG.ERROR_PLAN_NULL.getDescripcion(),
                        new ErrorRequestDTO(idSesion, ConstantesFNG.descargaPlan,
                                codigoProducto, ConstantesFNG.REDIRECT_HOME));
            }
        } catch (Exception e) {
            throw new FNGFailException(CodigosRespuestaFNG.ERROR_PLAN_VALORES.getCodigo(),
                    CodigosRespuestaFNG.ERROR_PLAN_VALORES.getDescripcion(), idSesion, ConstantesFNG.descargaPlan, e);
        }
        return listaParametros;
    }

    private boolean validarIntentosDescarga(String idSesion, String pasoFuncional, int numeroIntentosDescarga) {

        ContadorToken contadorTokenConsulta = new ContadorToken();
        boolean validoDescarga;
        contadorTokenConsulta.setIdSesion(idSesion);
        contadorTokenConsulta.setPasoFuncional(pasoFuncional);
        contadorTokenConsulta = entity.setContadorToken(contadorTokenConsulta);

        if (contadorTokenConsulta.getIntentosRealizados() <= numeroIntentosDescarga) {
            validoDescarga = true;

        } else {
            validoDescarga = false;
        }
        return validoDescarga;
    }


    private File getPlanAmortizacion(List<Parametro> datosPlan, ErrorRequestDTO infoError) {

        File resultFile = null;
        RespuestaDescarga respuestaDocumento = getDocumento(datosPlan, infoError);

        if (respuestaDocumento.isEstadoRespuesta()) {
            resultFile = (File) respuestaDocumento.getObjetoRespuesta();
        }

        return resultFile;
    }


    private RespuestaDescarga getDocumento(List<Parametro> listaParametros, ErrorRequestDTO infoError) {
        RespuestaDescarga respuestaDescarga = null;
        PlantillasUtil plantillasUtil = new PlantillasUtil(listaParametros, log);
        plantillasUtil.createFile(infoError);
        respuestaDescarga = plantillasUtil.getRespuestaDescarga();

        if (respuestaDescarga.isEstadoRespuesta()) {

            respuestaDescarga.setObjetoRespuesta(plantillasUtil.getFilePdf());
        } else{
            throw new FNGFailException(respuestaDescarga.getCodigo(), respuestaDescarga.getDescripcion(), infoError.getIdSesion(), infoError.getPasoFuncional());
        }
        return respuestaDescarga;
    }


    public String obtenerPlanAmortizacion(String idSesion) {
        String pasoAnterior = ConstantesFNG.pagina1bFNG;
        String pasoActual = ConstantesFNG.descargaPlan;
        String documento = null;
        InformacionTransaccion infoVisitaVD = entity.getInformacionTransaccion(
                idSesion, pasoAnterior, pasoActual);

                if (datosPlanAmortizacion != null) {
                    File cartaBienvenida = getPlanAmortizacion(datosPlanAmortizacion, infoError);
                    log.info("obtuve plan amortización");
                    byte[] fileContent = FileUtils.readFileToByteArray(cartaBienvenida);
                    log.info("array de bytes");
                    documento = java.util.Base64.getEncoder().encodeToString(fileContent);
                    log.info("String de fileContent");
                    return documento;
                } else {
                    throw new FNGBusinessException(CodigosRespuestaFNG.ERROR_DATOS_PLAN_DESCARGA.getCodigo(),
                            CodigosRespuestaFNG.ERROR_DATOS_PLAN_DESCARGA.getDescripcion(), infoError);
                }

    }

    public RespuestaServicio guardarCalificacion(List<Parametro> data, Payload payload) {
        RespuestaServicio response = new RespuestaServicio("200", "OK", "");
        Calificacion calificacion = new Calificacion();
        try {
            data.forEach(parametro -> {
                calificacion.setIdSesion(payload.getIdSesion());
                calificacion.setCodProducto(payload.getCodigoProducto());
                calificacion.setPregunta(parametro.getKey ());
                calificacion.setRespuesta(parametro.getValue ());
                this.entity.setCalificacion(calificacion);
            });
        }catch (Exception e){
            log.error("Error guardando la encuesta: "+ e.getMessage());
        }
        return response;
    }
}
