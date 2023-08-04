package com.bancolombia.microcredito.domain.planAmortizacion;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlanAmortizacion{

    private String comisionFng;
    private String tasaFijaMesVencida;
    private String tasaNominalAnualMesVencida;
    private String tasaEfectivaAnual;
    private String cuotaAproximadaMensual;
    private String valorAUsar;
    private String valorPrimeraComision;
    private String valorSegundaComision;
    private String valorSeguroVida;
    private List<FilaAmortizacion> listaAmortizacion = new ArrayList<FilaAmortizacion>();
    private String sessionKey;

}