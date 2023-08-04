package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.security.Payload;

import java.util.Map;

public interface OTPRepository {

    String generarEnviarOTPODA(Map<String, String> propiedades, Payload payload, String tipoMensaje, DatosPersonales datos, String pasoFuncional);

}
