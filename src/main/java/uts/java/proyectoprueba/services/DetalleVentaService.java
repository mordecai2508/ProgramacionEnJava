package uts.java.proyectoprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uts.java.proyectoprueba.models.DetalleVenta;
import uts.java.proyectoprueba.repositories.DetalleVentaRepository;

import java.util.List;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    /**
     * Guardar un detalle de venta en la base de datos.
     *
     * @param detalle El detalle de venta a guardar.
     * @return El detalle de venta guardado.
     */
    public DetalleVenta guardarDetalle(DetalleVenta detalle) {
        return detalleVentaRepository.save(detalle);
    }

    /**
     * Listar todos los detalles de venta.
     *
     * @return Lista de detalles de venta.
     */
    public List<DetalleVenta> listarDetalles() {
        return detalleVentaRepository.findAll();
    }

    /**
     * Buscar un detalle de venta por su ID.
     *
     * @param id El ID del detalle de venta.
     * @return El detalle de venta encontrado o null si no existe.
     */
    public DetalleVenta obtenerDetallePorId(Long id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    /**
     * Eliminar un detalle de venta por su ID.
     *
     * @param id El ID del detalle de venta a eliminar.
     */
    public void eliminarDetalle(Long id) {
        detalleVentaRepository.deleteById(id);
    }

    /**
     * Listar los detalles de venta asociados a una venta específica.
     *
     * @param ventaId El ID de la venta.
     * @return Lista de detalles de venta para esa venta.
     */
    public List<DetalleVenta> listarDetallesPorVenta(Long ventaId) {
        return detalleVentaRepository.findByVentaId(ventaId);
    }
}
