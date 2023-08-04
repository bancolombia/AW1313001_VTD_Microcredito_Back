package com.bancolombia.microcredito.domain.informaciontransaccion.gateways;

import com.bancolombia.microcredito.domain.informaciontransaccion.InformacionTransaccion;
import com.bancolombia.microcredito.domain.ventadigital.VentaDigital;

import java.util.List;

public interface InformacionTransaccionRepository {
    /**
     * findAll
     * @return listado de items
     */
    List<InformacionTransaccion> findAll();

    /**
     * save
     * @param dto objeto de entrada
     * @return el dto de retorno
     */
    InformacionTransaccion save(InformacionTransaccion dto);

    /**
     * findById
     * @param id del item
     * @return  el dto de retorno
     */
    InformacionTransaccion findById(String id);

    /**
     * deleteById
     * @param id del item
     */
    void deleteById(String id);

    VentaDigital findByIdSesion(String idSesion);
}
