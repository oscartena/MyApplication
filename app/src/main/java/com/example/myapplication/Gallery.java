package com.example.myapplication;

public class Gallery {
    private Integer imagen;
    private String titulo;

    public Gallery(int imagen, String titulo){
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
