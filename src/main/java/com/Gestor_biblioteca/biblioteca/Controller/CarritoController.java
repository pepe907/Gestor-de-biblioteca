package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Entiti.Carrito;
import com.Gestor_biblioteca.biblioteca.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/agregar")
    public Carrito crearCarrito(@RequestBody Carrito carrito){
        return carritoService.crearCarrito(carrito);
    }

    @GetMapping("/ver")
    public List<Carrito> verCarrito(){
        return carritoService.verCarrito();
    }

    @GetMapping("/id")
    public Carrito verPorId(@RequestBody Long id){
        return carritoService.verPorId(id);
    }
}
