package uts.java.proyectoprueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uts.java.proyectoprueba.models.Producto;
import uts.java.proyectoprueba.models.Proveedor;
import uts.java.proyectoprueba.repositories.ProveedorRepository;

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedors() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardarProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }
}
