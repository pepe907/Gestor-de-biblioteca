package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Entiti.Libros;
import com.Gestor_biblioteca.biblioteca.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
public class LibrosController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/agregar")
    public Libros agregarLibros(@RequestBody Libros libros){
        return libroService.agregar(libros);
    }

    @GetMapping("/ver")
    public List<Libros> verLibros(){
        return libroService.verLibro();
    }

    @GetMapping("/id")
    public Libros verPorId(@RequestBody Long id){
        return libroService.mostarPorId(id);
    }
}
