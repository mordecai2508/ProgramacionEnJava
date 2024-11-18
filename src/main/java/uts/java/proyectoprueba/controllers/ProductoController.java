
package uts.java.proyectoprueba.controllers;

import uts.java.proyectoprueba.models.Producto;
import uts.java.proyectoprueba.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "producto/listaProductos";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/AgregarProducto"; // Nombre del archivo de vista
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos"; // Redirige a la lista de productos después de guardar
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "producto/editarProducto"; // Vista de formulario para editar
        } else {
            return "redirect:/productos"; // Redirige si no se encuentra el producto
        }
    }

    @PostMapping("/productos/actualizar")
    public String actualizarProducto(Producto producto) {
        productoService.guardarProducto(producto); // Usa el mismo método de guardado para actualizar
        return "redirect:/productos"; // Redirige a la lista después de la actualización
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos"; // Redirige a la lista de productos después de eliminar
    }
}
