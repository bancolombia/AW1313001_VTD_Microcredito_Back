package com.bancolombia.microcredito.api.rest.service.confirmacion;

import com.bancolombia.microcredito.domain.constantes.ConstantesFNG;
import com.bancolombia.microcredito.domain.infocredito.InformacionCredito;
import com.bancolombia.microcredito.domain.informaciontransaccion.InformacionTransaccion;
import com.bancolombia.microcredito.domain.parameter.gateways.ConfigRepository;
import com.bancolombia.microcredito.usecase.confirmacion.ConfirmacionUseCase;
import com.bancolombia.microcredito.usecase.log.LogUseCase;
import com.bancolombia.microcredito.usecase.security.SecurityUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.core.Context;

@CrossOrigin("*")
@RestController
public class ConfirmacionService {
    private final ConfirmacionUseCase confirmacionUseCase;
    private final SecurityUseCase securityUseCase;
    private final LogUseCase logUseCase;
    private final ConfigRepository config;

    public ConfirmacionService(ConfirmacionUseCase confirmacionUseCase,SecurityUseCase securityUseCase,
                               LogUseCase logUseCase, ConfigRepository configInterface) {
        this.confirmacionUseCase = confirmacionUseCase;
        this.securityUseCase = securityUseCase;
        this.logUseCase = logUseCase;
        this.config = configInterface;
    }

    @PostMapping("/pagina1bFNG")
    public ResponseEntity<?> cargarPagina(
            @CookieValue(value = ConstantesFNG.SESSIONID_COOKIE_KEY, defaultValue = "") String sessionId,
            @Context HttpServletRequest httpRequest, @Context HttpServletResponse response,
            @Valid @RequestBody InformacionCredito request, BindingResult result) {


        InformacionTransaccion res = confirmacionUseCase.getConfirmacion(authorization,request,payload);
        response.addCookie(securityUseCase.createCookie(
                ConstantesFNG.JWT_COOKIE_KEY, ConstantesFNG.CONCAT_PREFIX.concat(res.getSessionKey())));
        response.addCookie(securityUseCase.createCookie(
                ConstantesFNG.SESSIONID_COOKIE_KEY, res.getIdSesion()));

        res.setSessionKey("");
        res.setIdSesion("");
        logUseCase.logInfoMessageInit(getClass(), payload.getIdSesion(), ConstantesFNG.pagina1bFNG,false);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }



}
