package com.bancolombia.microcredito.domain.parametroCalificacion;

public class ParametroCalificacion {

    String pregunta;
    String respuesta;
    public ParametroCalificacion () {}
    public ParametroCalificacion(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
