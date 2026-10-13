package com.Gestor_biblioteca.biblioteca.Controller;

import com.Gestor_biblioteca.biblioteca.Entiti.Documento;
import com.Gestor_biblioteca.biblioteca.Service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/agregar")
    public Documento agregarDocumento(@RequestBody Documento documento){
        return documentoService.agregarDocumento(documento);
    }

    @GetMapping("/ver")
    public List<Documento> ver(){
        return documentoService.verDocumento();
    }


    @GetMapping("/{id}")
    public Documento verPorId(@PathVariable Long id){
        return documentoService.verPorId(id);
    }
}
