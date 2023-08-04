package com.bancolombia.microcredito.domain.respuestaservicio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaServicio {

    private String codigo;
    private String descripcion;
    private String redirect;

}
