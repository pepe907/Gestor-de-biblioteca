package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Dto.LoginRequest;
import com.Gestor_biblioteca.biblioteca.Dto.LoginResponse;
import com.Gestor_biblioteca.biblioteca.Dto.RegisterRequest;
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

    public Users crearCuenta(RegisterRequest registerRequest){
        Long rolId = 4L;

        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol " + rolId + "no disponible"));

        Users users = new Users();
        users.setNombre(registerRequest.getNombre());
        users.setCorreo(registerRequest.getCorreo());
        users.setPassword(registerRequest.getPassword());
        String config = passwordEncoder.encode(registerRequest.getPassword());
        users.setPassword(config);
        users.setRol(rol);
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