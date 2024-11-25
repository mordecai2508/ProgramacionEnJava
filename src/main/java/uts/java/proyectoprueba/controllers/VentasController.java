package uts.java.proyectoprueba.controllers;

import uts.java.proyectoprueba.models.DetalleVenta;
import uts.java.proyectoprueba.models.Venta;
import uts.java.proyectoprueba.services.VentaService;
import uts.java.proyectoprueba.services.ClienteService;
import uts.java.proyectoprueba.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class VentasController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/ventas")
    public String listarVentas(Model model){
        List<Venta> ventas = ventaService.listarVentas();
        model.addAttribute("ventas",ventas);
        return "venta/listaVentas";
        
    }

    @GetMapping("ventas/nueva")
    public String mostrarFormularioVenta(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("productos", productoService.listarProductos());
        return "venta/AgregarVenta";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@RequestParam("clienteId") Long clienteId,
                              @RequestParam("fecha") LocalDate fecha,
                              @RequestParam("productoId") Long productoId,
                              @RequestParam("cantidad") Integer cantidad) {

        Venta venta = new Venta();
        venta.setCliente(clienteService.obtenerCliente(clienteId));
        venta.setFecha(fecha);

        DetalleVenta detalle = new DetalleVenta();
        detalle.setProducto(productoService.obtenerProductoPorId(productoId));
        detalle.setCantidad(cantidad);
        detalle.setVenta(venta);

        venta.getDetalles().add(detalle);

        ventaService.guardarVenta(venta);

        return "redirect:/ventas";
    }
}