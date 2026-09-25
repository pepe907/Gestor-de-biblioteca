package com.Gestor_biblioteca.biblioteca.Entiti;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users users;

    @ManyToMany
    @JoinTable(
            name = "carrito_libro",
            joinColumns = @JoinColumn(name =  "id_carrito"),
            inverseJoinColumns = @JoinColumn(name = "id_libro")
    )
    private List<Libros> libros;

    public Carrito(){

    }

    public Carrito(int cantidad, Users users){
        this.cantidad = cantidad;
        this.users = users;
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

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}