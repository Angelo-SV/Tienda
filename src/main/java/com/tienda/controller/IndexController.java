    package com.tienda.controller;

import com.tienda.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller/*La anotación Controller indica que la clase Java es de tipo Controladora.
El controlador va a devolver la vista que queremos mostrar en este caso el index_html, 
en el controlador se puede crear el modelo para la vista*/
@Slf4j
public class IndexController {
    @Autowired/*Permite enlazar un objeto*/
    private ArticuloService articuloService;
    //Se invoca la interfaz y spring busca la clase que la implementa en automático
    @GetMapping("/index_1")/*"Mapeo del URL"La bronca es aquí en index controller*/
    public String incio(Model model){/*Luego de mapear la URL, se genera el 
        método el cual puede tener cualquier nombre. Es decir, el método se 
        invocará cuando se solicite "/" en éste caso localhost página principal.
        Para utilizar el modelo simplemente se exporta la librería correspondiente
        y se crea el parámetro en el método sin necesidad de inicializarlo*/
        log.info("Estamos usando una arquitectura mvc");/*Muestra un mensaje al 
        usuario en la pantalla. La arquitectura MVC se basa en Model, View and 
        Controller*/
        
        var articulo=articuloService.getArticulo(true);
        
        model.addAttribute("articulo", articulo);/*Se crea el modelo para enviar la
        variable o el objeto a la vista. El dato entre comillas es el nombre de 
        la variable del modelo.*/
        return "index_1";/*El controlador siempre devolverá la vista o plantilla
        que queremos mostrar, index en éste caso. Se retorna simplemente con el 
        nombre de la vista*/
    }
}
