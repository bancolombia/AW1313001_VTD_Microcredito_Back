package com.bancolombia.microcredito.domain.proxy.gateways;

import com.bancolombia.microcredito.domain.error.JsonApiGetErrorByCodeRequest;
import com.bancolombia.microcredito.domain.exception.ValidacionException;

import java.util.List;

public interface ProxyRepository {

     List<GetErrorsByIdAplicacionResponse> getApiError(JsonApiGetErrorByCodeRequest request, String url)throws ValidacionException;


}
