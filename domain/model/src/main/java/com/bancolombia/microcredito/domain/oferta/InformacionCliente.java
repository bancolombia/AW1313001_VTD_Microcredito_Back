package com.bancolombia.microcredito.domain.oferta;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Data
public class InformacionCliente implements Serializable {

    private static final long serialVersionUID = -8042504980521328263L;
    private String idSolicitante;


    private String tipoDocumento;


    private String numeroDocumento;


    private String nombreCompletoCliente;

    private String direccionPrincipal;

    private String codigoCiudad;
    private String codigoDepartamento;
    private String codigoPais;

    private String telefono;
    private String celular;
    private String correoElectronicoCliente;
    private String codigoDireccionPrincipalFuente;
}
