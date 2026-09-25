package com.Gestor_biblioteca.biblioteca.Repository;

import com.Gestor_biblioteca.biblioteca.Entiti.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libros, Long> {

}
