package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.proxy.response.autenticacionfuerte.AutFuerteResponse;
import com.bancolombia.microcredito.domain.security.Payload;

import java.util.Map;

public interface AutenticacionFuerteRepository {

    AutFuerteResponse consultarEnrolamientoCliente(Map<String, String> propiedades, Payload payload, String pasoFuncional, String diasNovedad);

}
