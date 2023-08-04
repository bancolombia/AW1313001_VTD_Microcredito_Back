package com.bancolombia.microcredito.domain.producto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Producto {

    private String nombreProducto;
    private String tipoId;
    private String codigoProducto;
    private String codigoTipoProducto;
    private String plazo;
    private String tipoVenta;
    private BigDecimal cupoConsultarPrecalBasico;
    private BigDecimal cupoEjecutarSolicitud;
    private String nombreSubProducto;
    private String idInfoTransaccion;
}
