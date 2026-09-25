package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Entiti.Direccion;
import com.Gestor_biblioteca.biblioteca.Service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public List<Direccion> verDireccion(){
        return direccionService.verDireccion();
    }

    @PostMapping
    public Direccion crearDireccion(@RequestBody Direccion direccion){
        return direccionService.agregaDireccion(direccion);
    }

}
