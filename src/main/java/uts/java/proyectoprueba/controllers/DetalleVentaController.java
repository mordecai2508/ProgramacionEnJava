package uts.java.proyectoprueba.controllers;

import uts.java.proyectoprueba.models.DetalleVenta;
import uts.java.proyectoprueba.models.Venta;
import uts.java.proyectoprueba.services.DetalleVentaService;
import uts.java.proyectoprueba.services.ProductoService;
import uts.java.proyectoprueba.services.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/ventas/detalles/{id}")
    public String listarDetalles(@PathVariable Long id, Model model) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        model.addAttribute("venta", venta);
        return "venta/listaDetalles";
    }

    @GetMapping("/detalles/nuevo/{id}")
    public String nuevoDetalle(@PathVariable Long id, Model model) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        model.addAttribute("detalle", new DetalleVenta());
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("venta", venta);
        return "venta/editarDetalle";
    }

    @PostMapping("/detalles/guardar")
    public String guardarDetalle(DetalleVenta detalle) {
        detalleVentaService.guardarDetalle(detalle);
        return "redirect:/ventas/detalles/" + detalle.getVenta().getId();
    }
}
