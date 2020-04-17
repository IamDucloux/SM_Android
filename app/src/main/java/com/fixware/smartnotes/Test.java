package com.fixware.smartnotes;

public class Test {

    private String title;
    private Pregunta preguntas [];

    public Test() {
    }

    public Test(String title, Pregunta[] preguntas) {
        this.title = title;
        this.preguntas = preguntas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Pregunta[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Pregunta[] preguntas) {
        this.preguntas = preguntas;
    }


}
