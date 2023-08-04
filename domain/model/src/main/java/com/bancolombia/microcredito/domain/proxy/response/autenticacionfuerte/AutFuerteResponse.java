package com.bancolombia.microcredito.domain.proxy.response.autenticacionfuerte;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class AutFuerteResponse {

    private String tipoDocumento;
    private String numeroDocumento;
    private String mecanismo;
    private String correoElectronico;
    private String numeroCelular;
    private Date fechaInscripcion;
    private Date ultimaFechaModificacionDatos;
    private Date ultimaFechaModificacionMecanismo;
    private String estadoServicioOTP;
    private String metodoEnvioOTPODA;

}
