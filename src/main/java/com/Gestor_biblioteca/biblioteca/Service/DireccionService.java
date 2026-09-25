package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Direccion;
import com.Gestor_biblioteca.biblioteca.Repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> verDireccion(){
        return direccionRepository.findAll();
    }

    public Direccion agregaDireccion(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    public Direccion verPorId(Long id){
        return direccionRepository.findById(id).orElse(null);
    }

    public void eliminarDireccionPorId(Long id){
        direccionRepository.deleteById(id);
    }
}