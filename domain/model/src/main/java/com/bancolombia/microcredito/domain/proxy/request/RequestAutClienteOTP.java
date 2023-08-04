package com.bancolombia.microcredito.domain.proxy.request;

import com.bancolombia.microcredito.domain.security.Payload;
import lombok.Value;

import java.util.Map;

@Value
public class RequestAutClienteOTP {

    Map<String, String> properties;
    Payload payload;
    String tipoDocumento;
    String pasoFuncional;
    String otp;
    String canal;

}
