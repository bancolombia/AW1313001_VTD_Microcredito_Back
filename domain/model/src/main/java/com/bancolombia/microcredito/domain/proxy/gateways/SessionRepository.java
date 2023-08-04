package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.security.Payload;

import java.util.Map;

public interface SessionRepository {
    String mantenerSesion(Map<String, String> propiedades, Payload payload, String pasoFuncional);
    boolean cerrarSesion(Map<String, String> propiedades, Payload payload, String pasoFuncional);
}
