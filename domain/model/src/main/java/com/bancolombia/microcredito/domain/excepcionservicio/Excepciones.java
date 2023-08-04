package com.bancolombia.microcredito.domain.excepcionservicio;

import com.bancolombia.microcredito.domain.error.VTDError;
import lombok.Data;

@Data
public class Excepciones {

    private String codigo;
    private String descripcion;
    private String detalle;
    private String actor;
    private String idInfoTransaccion;
    private String codigoFuncional;
    private String descripcionFuncional;
    private String tipoExcepcion;
    private String servicio;
    private String operacionServicio;

    public Excepciones(){

    }

    public Excepciones(VTDError error){

        this.setCodigo(error.getCode());
        this.setDescripcion(error.getDescripcion());
        this.setCodigoFuncional(error.getCodigoFuncional());
        this.setDescripcionFuncional(error.getDetalleFuncional());
        this.setTipoExcepcion(error.getTipoExcepcion());
        this.setServicio(error.getServicio());
        this.setOperacionServicio(error.getOperacionServicio());
    }

}
