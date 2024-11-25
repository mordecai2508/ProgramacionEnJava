package uts.java.proyectoprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uts.java.proyectoprueba.models.DetalleVenta;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

    /**
     * Encuentra todos los detalles de venta asociados a una venta específica.
     *
     * @param ventaId El ID de la venta.
     * @return Lista de detalles de venta.
     */
    List<DetalleVenta> findByVentaId(Long ventaId);
}
