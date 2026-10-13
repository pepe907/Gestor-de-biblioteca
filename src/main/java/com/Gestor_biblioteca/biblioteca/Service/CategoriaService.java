package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Categoria;
import com.Gestor_biblioteca.biblioteca.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria crearCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> verCategoria(){
        return categoriaRepository.findAll();
    }

    public Categoria verPorId(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error en el id de la categoria" ));
    }
}
