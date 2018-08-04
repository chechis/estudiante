package com.example.chechis.estudiante.adapter;

public class Tarea {

    private int id;
    private String tarea;
    private String estudiante;
    private String asignatura;
    private String nota;

    public Tarea() {
    }

    public Tarea(int id, String tarea, String estudiante, String asignatura, String nota) {
        this.id = id;
        this.tarea = tarea;
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public Tarea(String tarea, String estudiante, String asignatura, String nota) {
        this.tarea = tarea;
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Id: "+id+"\nTarea: "+tarea+"\nEstudiante: "+estudiante+"\nAsignatura: "+asignatura+"\nNota: "+nota+"\n\n";
    }

}
