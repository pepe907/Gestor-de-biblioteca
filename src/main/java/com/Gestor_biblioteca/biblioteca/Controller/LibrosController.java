package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Dto.LibroRequest;
import com.Gestor_biblioteca.biblioteca.Entiti.Libros;
import com.Gestor_biblioteca.biblioteca.Service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
public class LibrosController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/agregar")
    public Libros agregarLibros(@RequestBody LibroRequest libroRequest){
        return libroService.agregar(libroRequest);
    }

    @PutMapping("/editar/{id}")
    public Libros editarLibros(@PathVariable Long id, @RequestBody @Valid LibroRequest libroRequest){
        return libroService.editar(id, libroRequest);
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
