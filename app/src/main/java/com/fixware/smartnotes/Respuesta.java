package com.fixware.smartnotes;

public class Respuesta {

    private String respuesta;
    private Boolean Correct;

    public Respuesta() {
    }

    public Respuesta(String respuesta, Boolean correct) {
        this.respuesta = respuesta;
        Correct = correct;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getCorrect() {
        return Correct;
    }

    public void setCorrect(Boolean correct) {
        Correct = correct;
    }
}

