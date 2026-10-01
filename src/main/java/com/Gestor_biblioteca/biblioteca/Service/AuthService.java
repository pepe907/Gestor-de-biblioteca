package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Dto.LoginRequest;
import com.Gestor_biblioteca.biblioteca.Dto.LoginResponse;
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
       Long rolId;
       if (users.getRol() != null && users.getRol().getId() != null){
           rolId = users.getRol().getId();
       } else {
           rolId = 1L;
       }
        Rol rol = rolRepository.findById(rolId)
               .orElseThrow(() -> new RuntimeException("Rol id: " + rolId + "no existe "));
       users.setRol(rol);
       String passwordConfig = passwordEncoder.encode(users.getPassword());
       users.setPassword(passwordConfig);
       return usersRepository.save(users);
    }

    public Users login(LoginRequest loginrequest){
        if(loginrequest.getCorreo() != null){
             Users correoEncontrado = usersRepository.findByCorreo(loginrequest.getCorreo());
             if (correoEncontrado != null){
                 if (passwordEncoder.matches(loginrequest.getPassword(),correoEncontrado.getPassword())){
                     return correoEncontrado;
                 }
             }
        }
        return null;
    }
}