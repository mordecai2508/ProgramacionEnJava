package uts.java.proyectoprueba.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uts.java.proyectoprueba.models.Proveedor;
import uts.java.proyectoprueba.services.ProveedorService;

@Controller
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/proveedores")
    public String listarProveedores(Model model){
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        model.addAttribute("proveedores",proveedores);
        return "proveedor/listaProveedores";
        
    }

    @GetMapping("/proveedores/nuevo")
    public String mostrarFomularioNuevoProveedor(Model model){
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/AgregarProveedor";
    }

    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(Proveedor proveedor){
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/editar/{id}")
    public String mostrarFormularioEditarProveedor(@PathVariable Long id, Model model){
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
        if (proveedor != null) {
            model.addAttribute("proveedor", proveedor);
            return "proveedor/editarProveedor";
        } else {
            return "redirect:/proveedores";
        }
    }

    @PostMapping("proveedores/actualizar")
    public String actualizarProveedor(Proveedor proveedor){
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("proveedores/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id){
        proveedorService.eliminarProveedor(id);
        return "redirect:/proveedores";
    }

}
