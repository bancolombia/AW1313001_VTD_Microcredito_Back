package com.bancolombia.microcredito.domain.oferta;

import com.bancolombia.microcredito.domain.exception.ValidacionException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@Data
public class SeguroProducto implements Serializable {


    private int montoMinimoSeguro;

    private int montoMaximoSeguro;

    private BigDecimal factor;

    public void setMontoMinimoSeguro(int montoMinimoSeguro) throws ValidacionException {
       this.montoMinimoSeguro = montoMinimoSeguro;
    }

}
