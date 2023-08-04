package com.bancolombia.microcredito.domain.proxy.request;

import com.bancolombia.microcredito.domain.security.Payload;
import lombok.Data;

import java.util.Map;

@Data
public class RequestGenToken {

    Map<String, String> properties;
    Payload payload;
    String celular;
    String correo;
    String pasoFuncional;
    String otp;

    public RequestGenToken(){

    }

    public RequestGenToken(Map<String, String> props, Payload payload, String pasoActual, String celular, String correo) {
        this.properties = props;
        this.payload = payload;
        this.pasoFuncional = pasoActual;
        this.celular = celular;
        this.correo = correo;
    }
}
