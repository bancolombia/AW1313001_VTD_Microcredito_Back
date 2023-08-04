package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.proxy.request.RequestSolicitudCredito;
import com.bancolombia.microcredito.domain.security.Payload;
import com.bcol.vtd.proxy.gestionsolcreditoconsumo.util.PeticionGestionSolicitudCreditoConsumov2;
import com.grupobancolombia.intf.producto.comun.gestionsolicitudcreditoconsumo.v2.AvanzarSolicitudCreditoConsumoResponse;
import com.grupobancolombia.intf.producto.comun.gestionsolicitudcreditoconsumo.v2.CrearSolicitudCreditoConsumoResponse;

import java.util.Map;

public interface GestionSolicitudRepository {

    CrearSolicitudCreditoConsumoResponse crearSolicitudCreditoConsumo(Map<String, String> propiedades, PeticionGestionSolicitudCreditoConsumov2 peticion, Payload payload, String pasoFuncional);

    AvanzarSolicitudCreditoConsumoResponse avanzarSolicitudCreditoConsumo(RequestSolicitudCredito request);

    AvanzarSolicitudCreditoConsumoResponse avanzarSolicitudMomento2(RequestSolicitudCredito request);
}
