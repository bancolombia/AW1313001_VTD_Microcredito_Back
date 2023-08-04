package com.bancolombia.microcredito.domain.oferta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OfertaDigital implements Serializable {

    private Cabecera cabecera;
    private Oferta oferta;
    private List<Documentos> documentos;
    private ConfirmacionTransaccion confirmacionTransaccion;
}
