package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@Data
public class Categoria implements Serializable {

    private static final long serialVersionUID = 2074095559526711112L;
    private String codigoCategoria;
    private List<Subproducto> subproducto;
    private String seleccionado;
}
