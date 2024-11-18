package uts.java.proyectoprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uts.java.proyectoprueba.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
