package com.bancolombia.microcredito.domain.infodispositivo;

import lombok.Data;

@Data
public class InformacionDispositivo {

    private String deviceBrowser;
    private String dispositivo;
    private String userAgent;
    private String sistemaOperativo;
    private String versionSistemaOperativo;
    private String idInfoTransaccion;
}
