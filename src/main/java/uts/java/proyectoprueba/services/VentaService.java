package uts.java.proyectoprueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uts.java.proyectoprueba.models.Venta;
import uts.java.proyectoprueba.repositories.VentaRepository;

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> listarVentas(){
        return ventaRepository.findAll();
    }

    public Venta guardarVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    public Venta obtenerVentaPorId(Long id){
        return ventaRepository.findById(id).orElse(null);
    }

}
