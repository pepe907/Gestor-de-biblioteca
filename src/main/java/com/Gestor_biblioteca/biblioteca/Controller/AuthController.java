package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Entiti.Users;
import com.Gestor_biblioteca.biblioteca.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public Users crear(@RequestBody  Users users){
        return authService.crearCuenta(users);
    }
}
