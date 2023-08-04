package com.bancolombia.microcredito.api.rest.service.finalizacion;

import com.bancolombia.microcredito.domain.constantes.ConstantesFNG;
import com.bancolombia.microcredito.domain.parameter.gateways.ConfigRepository;
import com.bancolombia.microcredito.domain.parametro.Parametro;
import com.bancolombia.microcredito.domain.response.ResponseService;
import com.bancolombia.microcredito.domain.respuestaservicio.RespuestaServicio;
import com.bancolombia.microcredito.usecase.finalizacion.FinalizacionUseCase;
import com.bancolombia.microcredito.usecase.log.LogUseCase;
import com.bancolombia.microcredito.usecase.security.SecurityUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
import java.util.List;

@RestController
public class FinalizacionService {

    private final FinalizacionUseCase finalizacionUseCase;
    private final SecurityUseCase securityUseCase;
    private final LogUseCase logUseCase;
    private final ConfigRepository config;

    public FinalizacionService(FinalizacionUseCase finalizacionUseCase, SecurityUseCase securityUseCase,
                               LogUseCase logUseCase, ConfigRepository configInterface) {
        this.finalizacionUseCase = finalizacionUseCase;
        this.securityUseCase = securityUseCase;
        this.logUseCase = logUseCase;
        this.config = configInterface;
    }



    @PostMapping("/descargarPlan")
    public ResponseService descargarPlan(
            @CookieValue(value = ConstantesFNG.SESSIONID_COOKIE_KEY, defaultValue = "") String sessionId,
            @Context HttpServletRequest httpRequest, @Context HttpServletResponse response) {

        logUseCase.logInfoMessageInit(getClass(), payload.getIdSesion(), ConstantesFNG.descargaPlan, true);
        String res = finalizacionUseCase.obtenerPlanAmortizacion(sessionId);
        logUseCase.logInfoMessageInit(getClass(), payload.getIdSesion(), ConstantesFNG.descargaPlan, false);

        return new ResponseService(res);
    }

    @PostMapping("/calificar")
    public ResponseEntity<?> guardarCalificacion(
            @CookieValue(value = ConstantesFNG.SESSIONID_COOKIE_KEY, defaultValue = "") String sessionId,
            @Context HttpServletRequest httpRequest, @Context HttpServletResponse response,
            @Valid @RequestBody List<Parametro> data, BindingResult result) {


        if (result.hasErrors()) {
         return new ResponseEntity<>(Util.validateRequest(result), HttpStatus.BAD_REQUEST);
         }


        logUseCase.logInfoMessageInit(getClass(), payload.getIdSesion(), ConstantesFNG.calificacion, true);
        RespuestaServicio res = finalizacionUseCase.guardarCalificacion(data, payload);
        logUseCase.logInfoMessageInit(getClass(), payload.getIdSesion(), ConstantesFNG.calificacion, false);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}