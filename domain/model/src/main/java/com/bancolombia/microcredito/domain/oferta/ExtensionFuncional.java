package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExtensionFuncional implements Serializable {

    private static final long serialVersionUID = 2539924380826843882L;
    private String llave;
    private String valor;
}
