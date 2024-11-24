package uts.java.proyectoprueba.controllers;
import uts.java.proyectoprueba.models.Cliente;
import uts.java.proyectoprueba.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    

    @GetMapping("clientes")
    public String listarClientes(Model model){
        List<Cliente> clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "cliente/listaClientes";
    }
    
    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioNuevoCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente/AgregarCliente";
    }

    @PostMapping("/clientes/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable Long id, Model model){
        Cliente cliente = clienteService.obtenerCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "cliente/editarCliente";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/actualizar")
    public String actualizarCliente(Cliente cliente){
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }    
}
