package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Rol;
import com.Gestor_biblioteca.biblioteca.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Rol crearRol(Rol rol){
        return rolRepository.save(rol);
    }

    public List<Rol> verRoles(){
        return rolRepository.findAll();
    }

    public Rol verPorId(Long id){
        return rolRepository.findById(id).orElse(null);
    }

    public void eliminarPorId(Long id){
        rolRepository.deleteById(id);
    }
}