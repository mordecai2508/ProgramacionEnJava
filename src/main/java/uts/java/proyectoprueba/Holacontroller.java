package uts.java.proyectoprueba;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class Holacontroller {
    
    @RequestMapping("/hola")
    public String hola(){
        return "Hello World";
    }
}
