package com.bancolombia.microcredito.domain.parameter.gateways;

import java.util.Map;

public interface ConfigRepository {

    public String getValue(String key);
    public Map<String, String> getParametersGestionSesion();
    public Map<String, String> getParametersProductosDeposito();
    public Map<String, String> getParametersDatosSolicitudCredito();
    public Map<String, String> getParametersAutenticacionFuerte();
    public Map<String, String> getParametersGeneracionToken();
    public Map<String, String>  getParametersGenerarOTP();
    public Map<String, String> getParametersCodigoAsesor();
    public Map<String, String> getParametersAutenticarClienteOTP();
}
