package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.proxy.request.RequestAutClienteOTP;
import com.grupobancolombia.intf.seguridadcorporativa.canales.autenticarclienteotp.v2.AutenticarClienteOTPODAResponse;
import com.grupobancolombia.intf.seguridadcorporativa.canales.autenticarclienteotp.v2.AutenticarClienteOTPSoftokenResponse;

public interface AutenticarClienteOTPRepository {

    AutenticarClienteOTPODAResponse autenticarClienteOTPODA(RequestAutClienteOTP request);

    AutenticarClienteOTPSoftokenResponse autenticarClienteOTPSoftoken(RequestAutClienteOTP request);

}
