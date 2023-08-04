package com.bancolombia.microcredito.domain.util;

import com.bancolombia.microcredito.domain.datoscuenta.DatosCuenta;
import lombok.Data;

import java.util.List;

@Data
public class CargaUtil {

    String codigoAsesor;
    String otp;
    String idSolicitante;
    List<DatosCuenta> listaCuentas;
    boolean existeCodigoAsesor;

}
