package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Cabecera implements Serializable {

    private static final long serialVersionUID = 39557730884840081L;
    private String estadoTransaccion;
    private String pasoFuncional;
    private String numeroSolicitud;
    private List<ExtensionFuncional> extensionFuncional;
}
