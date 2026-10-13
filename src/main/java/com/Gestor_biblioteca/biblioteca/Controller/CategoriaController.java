package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Entiti.Categoria;
import com.Gestor_biblioteca.biblioteca.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/agregar")
    public Categoria agregarCategoria(@RequestBody Categoria categoria){
        return categoriaService.crearCategoria(categoria);
    }

    @GetMapping("/ver")
    public List<Categoria> verCaategorias(){
        return categoriaService.verCategoria();
    }

    @GetMapping("/verId")
    public Categoria verPorId(@RequestBody Long id){
        return categoriaService.verPorId(id);
    }
}