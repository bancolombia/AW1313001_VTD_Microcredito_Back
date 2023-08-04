package com.bancolombia.microcredito.domain.contadortoken;

import lombok.Data;

@Data
public class ContadorToken {

    private String nombreCliente;
    private String documento;
    private String tipoDocumento;
    private String servicio;
    private int intentosRealizados;
    private String mecanismoEnrrolamineto;
    private String idSesion;
    private String pasoFuncional;
}
