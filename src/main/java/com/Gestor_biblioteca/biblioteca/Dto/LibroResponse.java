package com.Gestor_biblioteca.biblioteca.Dto;

public class LibroResponse {
    private Long id;
    private String nombreLibro;
    private String autor;
    private String descripcion;

    public LibroResponse(Long id, String nombreLibro, String autor, String descripcion){
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.descripcion = descripcion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
