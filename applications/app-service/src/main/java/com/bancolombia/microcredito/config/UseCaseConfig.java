package com.bancolombia.microcredito.config;

import com.bancolombia.microcredito.domain.log.gateways.LoggerRepository;
import com.bancolombia.microcredito.domain.parameter.gateways.ConfigRepository;
import com.bancolombia.microcredito.domain.proxy.gateways.*;
import com.bancolombia.microcredito.domain.security.gateways.SecurityRepository;
import com.bancolombia.microcredito.domain.ventadigital.gateways.VentaDigitalRepository;
import com.bancolombia.microcredito.usecase.atributos.AtributosUseCase;
import com.bancolombia.microcredito.usecase.confirmacion.ConfirmacionUseCase;
import com.bancolombia.microcredito.usecase.error.ErrorUseCase;
import com.bancolombia.microcredito.usecase.finalizacion.FinalizacionUseCase;
import com.bancolombia.microcredito.usecase.generarotp.GenerarOTPUseCase;
import com.bancolombia.microcredito.usecase.log.LogUseCase;
import com.bancolombia.microcredito.usecase.oferta.OfertaUseCase;
import com.bancolombia.microcredito.usecase.plan.PlanUseCase;
import com.bancolombia.microcredito.usecase.security.SecurityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ErrorUseCase errorUseCase(ConfigRepository config, LoggerRepository log,
                                     ProxyRepository proxy, VentaDigitalRepository entity) {
        return new ErrorUseCase(config, log, proxy, entity);
    }

    @Bean
    public LogUseCase logUseCase(LoggerRepository log) {
        return new LogUseCase(log);
    }

    @Bean
    public SecurityUseCase securityUseCase(
            SecurityRepository security,
            SessionRepository sessionRepository,
            LoggerRepository loggerRepository,
            ConfigRepository config,
            VentaDigitalRepository entity) {
        return new SecurityUseCase(security, sessionRepository, loggerRepository, config, entity);
    }

    @Bean
    public AtributosUseCase atributosUseCase(VentaDigitalRepository entityInterface, ConfigRepository config,
                                             SecurityRepository security, LoggerRepository log,
                                             AutenticacionFuerteRepository authFuerteRepository,
                                             GestionSolicitudRepository solicitudRepository,
                                             SessionRepository sessionRepository,
                                             ErrorUseCase errorUseCase) {
        return new AtributosUseCase(entityInterface, config, security, log,
                authFuerteRepository, solicitudRepository, sessionRepository, errorUseCase);
    }

    @Bean
    public OfertaUseCase ofertaUseCase(VentaDigitalRepository entityInterface, ConfigRepository config,
                                       SecurityRepository security, LoggerRepository log,
                                       DepositoRepository depositoRepository) {
        return new OfertaUseCase(entityInterface, config, security, log, depositoRepository);
    }

    @Bean
    public PlanUseCase planUseCase(VentaDigitalRepository entityInterface, ConfigRepository config,
                                     SecurityRepository security, LoggerRepository log) {
        return new PlanUseCase(entityInterface, config, security, log);
    }

    @Bean
    public ConfirmacionUseCase confirmacionUseCase(VentaDigitalRepository entityInterface, ConfigRepository config,
                                                   SecurityRepository security, LoggerRepository log,
                                                   GestionSolicitudRepository solicitudRepository) {
        return new ConfirmacionUseCase(entityInterface, config, security, log, solicitudRepository);
    }

    @Bean
    public DocumentoUseCase documentoUseCase(VentaDigitalRepository entityInterface, ConfigRepository config,
                                             LoggerRepository log,
                                             GestionSolicitudRepository solicitudRepository,
                                             DatosComercialesRepository comercialRepository,
                                             ErrorUseCase errorUseCase) {
        return new DocumentoUseCase(entityInterface, config, log,
                solicitudRepository, comercialRepository, errorUseCase);
    }

    @Bean
    public ValidateOTPUseCase validateOTPUseCase(VentaDigitalRepository entityInterface, ConfigRepository config,
                                               LoggerRepository log,
                                               AutenticarClienteOTPRepository autClienteOTPRepository,
                                               GeneracionTokenRepository genTokenRepository) {
        return new ValidateOTPUseCase(entityInterface, config, log,
                autClienteOTPRepository, genTokenRepository);
    }

    @Bean
    public GenerarOTPUseCase generarOTPUseCase(VentaDigitalRepository entityInterface, ConfigRepository config,
                                              LoggerRepository log,
                                              OTPRepository otpRepository,
                                              GeneracionTokenRepository genTokenRepository) {
        return new GenerarOTPUseCase(entityInterface, config, log, otpRepository,genTokenRepository);
    }

    @Bean
    public FinalizacionUseCase finalizacionUseCase(VentaDigitalRepository entityInterface,
                                                   SecurityRepository security, LoggerRepository log, ConfigRepository config) {
        return new FinalizacionUseCase(entityInterface, security, log, config);
    }
}
