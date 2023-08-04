package com.bancolombia.microcredito.domain.planAmortizacion;

import lombok.Data;

@Data
public class FilaAmortizacion{

    private int mes;
    private int intereses;
    private int abonoACapital;
    private int cuotaCalculada;
    private int seguros;
    private int totalCuota;
    private int comisionFng;
    private int saldoACapital;

}