package com.bancolombia.microcredito.technical.log;


import com.bancolombia.microcredito.domain.log.gateways.LoggerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Repository;

@Repository
public class LoggerAdapter implements LoggerRepository {

    private static final Logger logger = LogManager.getLogger(LoggerAdapter.class);


    @Override
    public void setId(String id) {
        ThreadContext.put("sessionId", id);
    }

    @Override
    public void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    @Override
    public void error(String message, Exception ex) {
        if (logger.isErrorEnabled()) {
            logger.error(message, ex);
        }
    }

    @Override
    public void error(String message) {
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    @Override
    public void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (logger.isInfoEnabled()) {
            logger.info(message, params);
        }
    }

    @Override
    public void warn(String message, Exception ex) {
        if (logger.isWarnEnabled()) {
            logger.warn(message, ex);
        }
    }

    @Override
    public void warn(String message) {
        if (logger.isWarnEnabled()) {
            logger.fatal(message);
        }
    }

    @Override
    public void fatal(String message) {
        if (logger.isFatalEnabled()) {
            logger.fatal(message);
        }
    }

    @Override
    public void fatal(String message, Exception ex) {
        if (logger.isFatalEnabled()) {
            logger.fatal(message, ex);
        }
    }
	
}
