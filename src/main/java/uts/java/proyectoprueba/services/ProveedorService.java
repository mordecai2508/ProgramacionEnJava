package uts.java.proyectoprueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uts.java.proyectoprueba.models.Proveedor;
import uts.java.proyectoprueba.repositories.ProveedorRepository;

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardarProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }
    
    public Proveedor obtenerProveedorPorId(Long id){
        return proveedorRepository.findById(id).orElse(null);
    }

    public void eliminarProveedor(Long id){
        proveedorRepository.deleteById(id);
    }
}
