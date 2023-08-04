package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.exception.ValidacionException;
import com.bancolombia.microcredito.domain.security.Payload;

import java.util.Map;

public interface DatosComercialesRepository {

    boolean isCodigoAsesor(Map<String, String> propiedades, Payload payload, String pasoFuncional, String codigoAsesor) throws ValidacionException;
}
