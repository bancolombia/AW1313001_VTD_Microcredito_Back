package com.bancolombia.microcredito.domain.oferta;

import java.io.Serializable;

public class PeriodoGraciaFNG implements Serializable {

    private static final long serialVersionUID = -8746979140693336466L;
    private String meses;

    public PeriodoGraciaFNG(String meses){
        this.meses = meses;
    }

    public String getMeses() {
        return meses;
    }

    public void setMeses(String meses) {
        this.meses = meses;
    }
}
