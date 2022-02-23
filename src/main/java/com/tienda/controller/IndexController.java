package com.tienda.controller;

import com.tienda.domain.Clientes;
import com.tienda.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller/*El controlador va a devolver la vista que queremos mostrar en este 
caso el index_html, en el controlador se puede crear el modelo para la vista*/
@Slf4j
public class IndexController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/")
    public String incio(Model model){
        log.info("Estamos usando una arquitectura mvc");
        
        var cliente=clienteService.getClientes();
        
        model.addAttribute("cliente", cliente);
        return "index_1";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Clientes clientes){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Clientes clientes){
        clienteService.save(clientes);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idcliente}")
    public String modificarCliente(Clientes clientes, Model model){
        clientes = clienteService.getClientes(clientes);
        model.addAttribute("cliente", clientes);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idcliente}")
    public String eliminarCliente(Clientes clientes, Model model){
        clienteService.delete(clientes);
        return "redirect:/";
    }
}
