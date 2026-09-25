package com.Gestor_biblioteca.biblioteca.Repository;

import com.Gestor_biblioteca.biblioteca.Entiti.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
