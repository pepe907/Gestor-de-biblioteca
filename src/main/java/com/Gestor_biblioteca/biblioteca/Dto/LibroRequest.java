package com.Gestor_biblioteca.biblioteca.Dto;

public class LibroRequest {
    private String nombreLibro;
    private String autor;
    private String descripcion;
    private Long idCategoria;

    public LibroRequest(long idCategoria,String nombreLibro, String autor, String descripcion){
        this.idCategoria = idCategoria;
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
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
