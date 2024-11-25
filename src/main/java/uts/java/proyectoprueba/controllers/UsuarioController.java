package uts.java.proyectoprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uts.java.proyectoprueba.models.Usuario;
import uts.java.proyectoprueba.services.UsuarioService;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listaUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuario/listaUsuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/AgregarUsuario"; // Nombre del archivo de vista
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios"; // Redirige a la lista de productos después de guardar
    }

    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioEditarUsuarios(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuario/editarUsuario"; // Vista de formulario para editar
        } else {
            return "redirect:/usuarios"; // Redirige si no se encuentra el producto
        }
    }

    @PostMapping("/usuarios/actualizar")
    public String actualizarUsuarios(Usuario usuario) {
        usuarioService.guardarUsuario(usuario); // Usa el mismo método de guardado para actualizar
        return "redirect:/usuarios"; // Redirige a la lista después de la actualización
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios"; // Redirige a la lista de productos después de eliminar
    }
}
