package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Rol;
import com.Gestor_biblioteca.biblioteca.Entiti.Users;
import com.Gestor_biblioteca.biblioteca.Repository.RolRepository;
import com.Gestor_biblioteca.biblioteca.Repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users crearCuenta(Users users){
        if(users.getRol() != null && users.getId() != null){
            Rol rol = rolRepository.findById(users.getRol().getId())
                    .orElseThrow(() -> new RuntimeException(" El rol con id" + users.getRol().getId() + "No existe"));
            users.setRol(rol);
        }else {
            throw new RuntimeException(" El Usuario Necesita un rol para registrarse ");
        }

        String passwordConfig = passwordEncoder.encode(users.getPassword());
        users.setPassword(passwordConfig);
        return usersRepository.save(users);
    }

    public Users login(Users users){
        if(users.getCorreo() != null && users.getPassword() != null){
             Users correoEncontrado = usersRepository.findByCorreo(users.getCorreo());
             if (correoEncontrado != null){
                 if (correoEncontrado.getPassword().equals(users.getPassword())){
                     return users;
                 }
             }
        }
        return null;
    }
}