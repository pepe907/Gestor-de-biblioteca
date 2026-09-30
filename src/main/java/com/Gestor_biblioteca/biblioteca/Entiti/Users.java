package com.Gestor_biblioteca.biblioteca.Entiti;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true,  length = 100)
    private String correo;

    @Column(name = "password", nullable = false, length = 260)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;


    public Users(){

    }

    public Users(Rol rol ,String nombre, String correo, String password){
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}