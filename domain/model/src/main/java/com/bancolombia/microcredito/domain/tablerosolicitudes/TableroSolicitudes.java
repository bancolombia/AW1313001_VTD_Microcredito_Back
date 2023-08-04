package com.bancolombia.microcredito.domain.tablerosolicitudes;

import lombok.Data;

import java.util.Date;

@Data
public class TableroSolicitudes {

    private String idTableroSolicitudes;
    private Date fecha;
    private String estado;
    private String identificacion;
    private String codigoProducto;
    private String nombreProducto;

}
