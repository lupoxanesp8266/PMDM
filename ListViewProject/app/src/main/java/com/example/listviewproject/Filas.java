package com.example.listviewproject;

public class Filas {
    protected String titulo, subtitulo;
    protected int imagen;//Solo se devuelve el id de la imagen


    public Filas(int imagen, String titulo, String subtitulo){
        this.imagen = imagen;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }
}
