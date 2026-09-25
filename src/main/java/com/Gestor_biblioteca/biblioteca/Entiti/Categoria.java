package com.Gestor_biblioteca.biblioteca.Entiti;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nombre_categoria", nullable = false, length = 250)
    private String categoria;


    @OneToMany(mappedBy = "categoria")
    private List<Libros> libros;
    public Categoria(){

    }

    public Categoria(String categoria){
        this.categoria = categoria;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
