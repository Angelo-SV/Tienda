package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Clientes;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller/*El controlador va a devolver la vista que queremos mostrar en este 
caso el index_html, en el controlador se puede crear el modelo para la vista*/
@Slf4j
public class IndexController {
    @Autowired
    private ClienteDao clientedao;
    @GetMapping("/")
    public String incio(Model model){
        log.info("Estamos usando una arquitectura mvc");
        
        var cliente=clientedao.findAll();
        model.addAttribute("cliente", cliente);
        return "index_1";
    }
}
