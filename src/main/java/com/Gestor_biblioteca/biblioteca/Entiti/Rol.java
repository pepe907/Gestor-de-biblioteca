package com.Gestor_biblioteca.biblioteca.Entiti;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private List<Users> usuarios;

    public Rol(){

    }

    public Rol(String descripcion){
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Users> getUsuarios() { return usuarios; }
    public void setUsuarios(List<Users> usuarios) { this.usuarios = usuarios; }
}
