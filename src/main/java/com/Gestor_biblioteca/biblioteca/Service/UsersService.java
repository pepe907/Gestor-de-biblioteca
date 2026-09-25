package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Direccion;
import com.Gestor_biblioteca.biblioteca.Entiti.Rol;
import com.Gestor_biblioteca.biblioteca.Entiti.Users;
import com.Gestor_biblioteca.biblioteca.Repository.DireccionRepository;
import com.Gestor_biblioteca.biblioteca.Repository.RolRepository;
import com.Gestor_biblioteca.biblioteca.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    public List<Users> verUsuarios(){
        return usersRepository.findAll();
    }

    public Users obtenerId(Long id){
        return usersRepository.findById(id).orElse(null);
    }

    public Users agregar(Users users){

        if (users.getRol() != null && users.getRol().getId() != null){
            Rol rol = rolRepository.findById(users.getRol().getId())
                    .orElseThrow(() -> new RuntimeException("El rol con ID " + users.getRol().getId() + " no existe"));
            users.setRol(rol);
        }else{
            throw new RuntimeException("EL Usuario debe tener un rol valido");
        }


        if (users.getDireccion() != null && users.getDireccion().getId() != null){
            Direccion direccion = direccionRepository.findById(users.getDireccion().getId())
                    .orElseThrow(() -> new RuntimeException("La dirección con ID " + users.getDireccion().getId() + " no existe"));
            users.setDireccion(direccion);
        }else {
            users.setDireccion(null);
        }

        return usersRepository.save(users);
    }

    public void eliminarUsuario(Long id){
        usersRepository.deleteById(id);
    }
}
