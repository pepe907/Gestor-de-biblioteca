package com.Gestor_biblioteca.biblioteca.Service;

import com.Gestor_biblioteca.biblioteca.Entiti.Documento;
import com.Gestor_biblioteca.biblioteca.Repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public Documento agregarDocumento(Documento documento){
        return documentoRepository.save(documento);
    }

    public List<Documento> verDocumento(){
        return documentoRepository.findAll();
    }

    public Documento verPorId(Long id){
        return documentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error id Documento"));
    }
}
