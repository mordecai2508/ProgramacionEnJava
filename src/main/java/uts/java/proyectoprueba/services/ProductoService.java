package uts.java.proyectoprueba.services;

import uts.java.proyectoprueba.repositories.ProductoRepository;
import uts.java.proyectoprueba.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
    
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

}

