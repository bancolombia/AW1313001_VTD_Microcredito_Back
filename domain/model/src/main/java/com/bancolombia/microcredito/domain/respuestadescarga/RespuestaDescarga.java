package com.bancolombia.microcredito.domain.respuestadescarga;

import lombok.Data;

@Data
public class RespuestaDescarga {

    private boolean estadoRespuesta = true;
    private Object objetoRespuesta;
    private String descripcion;
    private String codigo;


    public void setError(String codigo, String descripcion) {
        this.setCodigo(codigo);
        this.setDescripcion(descripcion);
        this.estadoRespuesta = false;
    }

}

