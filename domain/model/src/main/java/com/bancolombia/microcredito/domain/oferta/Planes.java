package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Planes {

    private String idPlan;

    private BigDecimal factorSeguroDesempleo;
    private List<Tasas> tasas;
    private List<SeguroProducto> seguroProducto;
}
