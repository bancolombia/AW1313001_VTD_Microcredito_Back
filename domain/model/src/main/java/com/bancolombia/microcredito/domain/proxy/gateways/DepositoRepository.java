package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.security.Payload;
import com.grupobancolombia.intf.producto.deposito.consultaproductodepositos.v1.InformacionCuenta;

import java.util.List;
import java.util.Map;

public interface DepositoRepository {
    List<InformacionCuenta> obtenerCuentasDeposito(Map<String, String> propiedades, Payload payload, String pasoFuncional);
}
