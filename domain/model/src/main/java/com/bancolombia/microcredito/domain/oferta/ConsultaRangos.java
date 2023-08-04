package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

@Data
public class ConsultaRangos {

    String numeroSolicitud;
    String paso;
    int rango1;
    int rango2;
    int tiempoEspera;
    String idSesion;
    String pasoFuncional;

    public ConsultaRangos(String numeroSolicitud, String paso, int rango1, int rango2, int tiempoEspera, String idSesion, String pasoFuncional) {
        this.numeroSolicitud = numeroSolicitud;
        this.paso = paso;
        this.rango1 = rango1;
        this.rango2 = rango2;
        this.tiempoEspera = tiempoEspera;
        this.idSesion = idSesion;
        this.pasoFuncional = pasoFuncional;
    }
}
