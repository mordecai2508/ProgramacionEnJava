package uts.java.proyectoprueba.services;

import uts.java.proyectoprueba.repositories.ClienteRepository;
import uts.java.proyectoprueba.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerCliente(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);;
    }
}
