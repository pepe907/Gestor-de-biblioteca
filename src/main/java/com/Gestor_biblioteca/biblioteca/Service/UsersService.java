package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Users;
import com.Gestor_biblioteca.biblioteca.Repository.RolRepository;
import com.Gestor_biblioteca.biblioteca.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Users> verUsuarios(){
        return usersRepository.findAll();
    }

    public Users obtenerId(Long id){
        return usersRepository.findById(id).orElse(null);
    }

    public Users agregar(Users users){
        String password = bCryptPasswordEncoder.encode(users.getPassword());
        users.setPassword(password);
        return usersRepository.save(users);
    }

    public void eliminarUsuario(Long id){
        usersRepository.deleteById(id);
    }
}
