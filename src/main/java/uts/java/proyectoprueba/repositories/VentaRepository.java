package uts.java.proyectoprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uts.java.proyectoprueba.models.Venta;

public interface VentaRepository extends JpaRepository<Venta,Long> {

    
}