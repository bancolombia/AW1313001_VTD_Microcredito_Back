package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConfirmacionTransaccion implements Serializable {

    private static final long serialVersionUID = 5645983996689707919L;
    private String codigo;
    private String descripcion;
}
