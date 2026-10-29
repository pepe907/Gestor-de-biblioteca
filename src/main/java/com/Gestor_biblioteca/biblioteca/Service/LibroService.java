package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Dto.LibroRequest;
import com.Gestor_biblioteca.biblioteca.Entiti.Categoria;
import com.Gestor_biblioteca.biblioteca.Entiti.Libros;
import com.Gestor_biblioteca.biblioteca.Repository.CategoriaRepository;
import com.Gestor_biblioteca.biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Libros agregar(LibroRequest libroRequest){

        Categoria categoria = categoriaRepository.findById(libroRequest.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoria " + libroRequest.getIdCategoria() + "No existe"));

        Libros libro = Libros.builder()
                .nombreLibro(libroRequest.getNombreLibro())
                .autor(libroRequest.getAutor())
                .descripcion(libroRequest.getDescripcion())
                .categoria(categoria)
                .build();
        return libroRepository.save(libro);
    }

    public Libros editar(Long id, LibroRequest libroRequest){
        Libros existente = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("libro no encontrado : " + id));

        existente.setNombreLibro(libroRequest.getNombreLibro());
        existente.setAutor(libroRequest.getAutor());
        existente.setDescripcion(libroRequest.getDescripcion());

        return libroRepository.save(existente);
    }

    public List<Libros> verLibro(){
        return libroRepository.findAll();
    }

    public Libros mostarPorId(Long id){
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID libro incorrecto"));
    }
}
