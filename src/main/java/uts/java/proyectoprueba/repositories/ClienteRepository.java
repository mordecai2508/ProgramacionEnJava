package uts.java.proyectoprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uts.java.proyectoprueba.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    
}
