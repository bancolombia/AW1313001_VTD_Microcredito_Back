package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement
@Data
public class Producto implements Serializable {

    private static final long serialVersionUID = -7050962512864495637L;
    private String idProducto;
    private String nombreProducto;
    private String montoOtorgado;
    private List<Categoria> categoria;
    private List<ComisionFNG> comisionFNG;
    private List<PeriodoGraciaFNG> periodoGraciaFNG;
    private BigDecimal coberturaFng;
    private BigDecimal ivaFng;
}
