package com.bancolombia.microcredito.domain.datoscuenta;

import lombok.Data;

import java.io.Serializable;

@Data
public class DatosCuenta implements Serializable, Comparable<DatosCuenta> {

    private static final long serialVersionUID = -5933296204399969490L;


    public String numeroCuenta;


    private String tipoCuenta;

    private int diasInactividad;


}
