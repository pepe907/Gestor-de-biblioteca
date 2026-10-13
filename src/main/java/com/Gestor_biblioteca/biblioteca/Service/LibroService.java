package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Libros;
import com.Gestor_biblioteca.biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libros agregar(Libros libro){
        return libroRepository.save(libro);
    }

    public List<Libros> verLibro(){
        return libroRepository.findAll();
    }

    public Libros mostarPorId(Long id){
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID libro incorrecto"));
    }
}
