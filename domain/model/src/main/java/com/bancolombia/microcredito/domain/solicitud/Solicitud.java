package com.bancolombia.microcredito.domain.solicitud;

import com.bancolombia.microcredito.domain.oferta.OfertaDigital;
import com.bancolombia.microcredito.domain.tablerosolicitudes.TableroSolicitudes;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Solicitud {

    private String solicitudId;
    private String numeroSolicitudVirtual;
    private Date fechaHoraSolicitud;
    private String codigo;
    private String descripcion;
    private String motivoDevolucion;
    private String dias;
    private BigInteger cupoAprobado;
    private String estadoId;
    private String usuario;
    private String bizagi;
    private OfertaDigital ofertaDigital;
    private String versionPolitica;
    private String convenioPolitica;
    private TableroSolicitudes tableroSolicitudes;
}
