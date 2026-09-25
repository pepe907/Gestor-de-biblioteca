package com.Gestor_biblioteca.biblioteca.Repository;

import com.Gestor_biblioteca.biblioteca.Entiti.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
