package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Entiti.Rol;
import com.Gestor_biblioteca.biblioteca.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> verRoles(){
        return rolService.verRoles();
    }

    @PostMapping
    public Rol agregaRol(@RequestBody Rol rol){
        return rolService.crearRol(rol);
    }
}
