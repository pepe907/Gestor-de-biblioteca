package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Entiti.Users;
import com.Gestor_biblioteca.biblioteca.Service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> verUsuarios(){
        return usersService.verUsuarios();
    }

    @PostMapping
    public Users crear(@RequestBody Users users){
        return usersService.agregar(users);
    }
}
