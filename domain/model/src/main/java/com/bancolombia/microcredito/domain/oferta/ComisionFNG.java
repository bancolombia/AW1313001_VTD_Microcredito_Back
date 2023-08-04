package com.bancolombia.microcredito.domain.oferta;

import java.io.Serializable;
import java.math.BigDecimal;

public class ComisionFNG implements Serializable {


    private static final long serialVersionUID = 287539482938583615L;


    private String monto;


    private BigDecimal comision;

    public ComisionFNG(String monto, BigDecimal comision){
        this.monto = monto;
        this.comision = comision;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }
}
