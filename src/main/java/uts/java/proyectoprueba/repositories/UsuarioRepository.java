package uts.java.proyectoprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uts.java.proyectoprueba.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
