package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.proxy.request.RequestGenToken;

public interface GeneracionTokenRepository {

    String generarOtpTala(RequestGenToken req);
    String validarToken(RequestGenToken req);
}
