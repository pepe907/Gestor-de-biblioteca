package com.Gestor_biblioteca.biblioteca.Dto;

public class LoginRequest {
    private String password;
    private String correo;

    public LoginRequest( String password, String correo){
        this.password = password;
        this.correo = correo;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
