package com.fixware.smartnotes;

public class Pregunta{

    private String cuerpo;
    private Respuesta respuestas [];


    public Pregunta() {
    }

    public Pregunta(String cuerpo, Respuesta[] respuestas) {
        this.cuerpo = cuerpo;
        this.respuestas = respuestas;
    }

    


    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Respuesta[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Respuesta[] respuestas) {
        this.respuestas = respuestas;
    }
}
