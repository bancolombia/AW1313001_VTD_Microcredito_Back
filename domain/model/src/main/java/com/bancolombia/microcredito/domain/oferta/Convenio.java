package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Data
public class Convenio implements Serializable {

    private String nitEmpresa;

    private String nombreConvenio;

    private int diaPago;

    private String codigoConvenio;

    private String ciudadConvenio;

    private String correoElectronico;
}
