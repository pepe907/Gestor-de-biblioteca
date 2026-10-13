package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Carrito;
import com.Gestor_biblioteca.biblioteca.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public Carrito verPorId(Long id){
        return carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id incorrecto "));
    }

    public List<Carrito> verCarrito(){
        return carritoRepository.findAll();
    }

    public Carrito crearCarrito(Carrito carrito){
        return carritoRepository.save(carrito);
    }
}
