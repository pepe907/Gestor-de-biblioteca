package com.Gestor_biblioteca.biblioteca.Repository;

import com.Gestor_biblioteca.biblioteca.Entiti.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
