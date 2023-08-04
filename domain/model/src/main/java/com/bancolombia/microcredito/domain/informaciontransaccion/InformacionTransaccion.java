package com.bancolombia.microcredito.domain.informaciontransaccion;

import com.bancolombia.microcredito.domain.excepcionservicio.Excepciones;
import com.bancolombia.microcredito.domain.infocredito.InformacionCredito;
import com.bancolombia.microcredito.domain.infodispositivo.InformacionDispositivo;
import com.bancolombia.microcredito.domain.informacionvivienda.InformacionVivienda;
import com.bancolombia.microcredito.domain.producto.Producto;
import com.bancolombia.microcredito.domain.solicitud.Solicitud;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InformacionTransaccion {

    private String idSesion;
    private String ipCliente;
    private Date fechaHoraTransaccion;
    private String pasoFuncional;
    private String canal;
    private String id;
    private String tokenUsuario;
    private String idAplicacion;
    private String usuario;
    private String fechaYHoraUltimaVisita;
    private String fechaYHoraActual;
    private String sessionKey;
    private String idAppSecundario;
    private String tokenApp;
    private Solicitud solicitud;
    private Producto producto;
    private DatosPersonales datosPersonales;
    private InformacionDispositivo informacionDispositivo;
    private InformacionCredito informacionCredito;
    private Excepciones excepciones;
    private List<Integer> plazos;
    private InformacionVivienda informacionVivienda;

}
