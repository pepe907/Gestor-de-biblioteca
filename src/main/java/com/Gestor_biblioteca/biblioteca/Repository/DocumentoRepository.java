package com.Gestor_biblioteca.biblioteca.Repository;

import com.Gestor_biblioteca.biblioteca.Entiti.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
