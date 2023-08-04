package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Subproducto implements Serializable {

    private static final long serialVersionUID = 4538555387327358364L;
    private String idSubproducto;
    private String nombreSubproducto;
    private String descripcionSubproducto;
    private String cupoMinimo;
    private String cupoMaximo;
    private String codigoImagen;
    private List<String> listaCondiciones;
    private String deshabilitada;
    private String cupoSolicitado;
    private BigDecimal comisionDisponibilidad;
    private boolean isProductOwner;
    private List<Planes> planes;
}
