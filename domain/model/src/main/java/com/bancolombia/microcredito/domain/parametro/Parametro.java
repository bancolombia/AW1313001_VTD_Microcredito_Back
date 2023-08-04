package com.bancolombia.microcredito.domain.parametro;

import lombok.Data;

@Data
public class Parametro {


    private final String key;


    private final String value;


    public Parametro( String value) {
        this.key = key;
        this.value = value;
    }
}
