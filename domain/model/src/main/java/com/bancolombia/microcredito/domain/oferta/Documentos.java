package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import java.io.Serializable;

@Data
public class Documentos implements Serializable {

    private static final long serialVersionUID = -1788030306555100002L;
    private String idSubproducto;
    private String tipoDocumento;
    private String documento;
    private String descripcion;
}
