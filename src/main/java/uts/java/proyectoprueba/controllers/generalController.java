package uts.java.proyectoprueba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class generalController {

    @GetMapping("/")
    public String listarProductos() {

        return "index.html";
    }
}
