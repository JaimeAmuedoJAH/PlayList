package com.jah.playlist;

import android.widget.SeekBar;

import java.io.Serializable;

//Clase POJO de cancion
public class Cancion implements Serializable {

    private int id;
    private String titulo;
    private String autor;
    private int portada;
    private int cancion;
    private transient SeekBar sbCancion;

    public Cancion(){}

    public Cancion(int id, String titulo, String autor, int portada, int cancion, SeekBar sbCancion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.portada = portada;
        this.cancion = cancion;
        this.sbCancion = sbCancion;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPortada() {
        return portada;
    }

    public int getCancion() {
        return cancion;
    }

    public SeekBar getSbCancion() {
        return sbCancion;
    }

    public void setSbCancion(SeekBar sbCancion) {
        this.sbCancion = sbCancion;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "cancion=" + cancion +
                ", portada=" + portada +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
