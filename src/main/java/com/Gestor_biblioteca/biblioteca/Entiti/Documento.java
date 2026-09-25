package com.Gestor_biblioteca.biblioteca.Entiti;

import jakarta.persistence.*;

@Entity
@Table(name = "documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Long id;

    @Column(name = "tarjeta", nullable = false, length = 20)
    private String tarjeta;

    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    public Documento(){

    }

    public Documento(Users users, String tarjeta, String cedula){
        this.tarjeta = tarjeta;
        this.cedula = cedula;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
