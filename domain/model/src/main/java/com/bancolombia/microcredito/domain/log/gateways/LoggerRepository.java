package com.bancolombia.microcredito.domain.log.gateways;

public interface LoggerRepository {

    void setId(String id);

    /**
     *
     * @param message: lo que se quire loguear
     */
    void debug(String message);

    /**
     *
     * @param message: lo que se quire loguear
     * @param ex: error
     */
    void error(String message, Exception ex);

    /**
     *
     * @param message: lo que se quire loguear
     */
    void error(String message);

    /**
     *
     * @param message: lo que se quire loguear
     */
    void info(String message);

    /**
     *
     * @param message Mensaje a mostrar en log
     * @param params parámetros para incrustar en log
     */
    void info(String message, Object... params);


    /**
     *
     * @param message: lo que se quire loguear
     * @param ex: error
     */
    void warn(String message, Exception ex);


    /**
     *
     * @param message: lo que se quire loguear
     */
    void warn(String message);


    /**
     *
     * @param message: lo que se quire loguear
     */
    void fatal(String message);


    /**
     *
     * @param message: lo que se quire loguear
     * @param ex: error
     */
    void fatal(String message, Exception ex);



}
