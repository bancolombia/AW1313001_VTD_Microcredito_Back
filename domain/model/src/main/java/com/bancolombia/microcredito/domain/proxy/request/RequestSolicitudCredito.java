package com.bancolombia.microcredito.domain.proxy.request;

import com.bancolombia.microcredito.domain.infocredito.InformacionCredito;
import com.bancolombia.microcredito.domain.security.Payload;
import lombok.Data;

import java.util.Map;

@Data
public class RequestSolicitudCredito {
    private Map<String, String> propiedades;
    private Payload payload;
    private byte[] archivoTrazabilidad;
    private String otp;
    private String idSolicitante;
    private boolean isAsesor;
    private String codigoAsesor;
    private DatosPersonales datosPersonales;
    private InformacionCredito informacionCredito;
    private String pasoFuncional;
}
