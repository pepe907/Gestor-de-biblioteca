package com.Gestor_biblioteca.biblioteca.Entiti;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;

    @Column(name = "nombreLibro", nullable = false, length = 150)
    private String nombreLibro;

    @Column(name = "autor", nullable = false, length = 150)
    private String autor;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Libros(){

    }

    public Libros(Categoria categoria, String nombreLibro, String autor, String descripcion){
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
