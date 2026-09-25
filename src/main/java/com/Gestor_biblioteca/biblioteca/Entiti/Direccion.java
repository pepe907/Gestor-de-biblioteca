package com.Gestor_biblioteca.biblioteca.Entiti;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id;

    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;

    @OneToMany(mappedBy = "direccion")
    private List<Users> usuarios;

    public Direccion(){

    }

    public Direccion(String direccion){
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Users> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Users> usuarios) {
        this.usuarios = usuarios;
    }
}
