    package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller/*La anotación Controller indica que la clase Java es de tipo Controladora.
El controlador va a devolver la vista que queremos mostrar en este caso el index_html, 
en el controlador se puede crear el modelo para la vista*/
@Slf4j
public class CategoriaController {
    @Autowired/*Permite enlazar un objeto*/
    private CategoriaService categoriaService;
    //Se invoca la interfaz y spring busca la clase que la implementa en automático
    @GetMapping("/categoria/listado")/*"Mapeo del URL"La bronca es aquí en index controller*/
    public String incio(Model model){/*Luego de mapear la URL, se genera el 
        método el cual puede tener cualquier nombre. Es decir, el método se 
        invocará cuando se solicite "/" en éste caso localhost página principal.
        Para utilizar el modelo simplemente se exporta la librería correspondiente
        y se crea el parámetro en el método sin necesidad de inicializarlo*/
        log.info("Estamos usando una arquitectura mvc");/*Muestra un mensaje al 
        usuario en la pantalla. La arquitectura MVC se basa en Model, View and 
        Controller*/
        var categoria=categoriaService.getCategoria(false);
        model.addAttribute("categoria", categoria);/*Se crea el modelo para enviar la
        variable o el objeto a la vista. El dato entre comillas es el nombre de 
        la variable del modelo.*/
        return "categoria/listado";/*El controlador siempre devolverá la vista o plantilla
        que queremos mostrar, index en éste caso. Se retorna simplemente con el 
        nombre de la vista*/
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categorias){
        return "categoria/modificar";
    }
    
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categorias){
        categoriaService.save(categorias);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idcategoria}")
    public String modificarCategoria(Categoria categorias, Model model){
        categorias = categoriaService.getCategoria(categorias);
        model.addAttribute("categoria", categorias);
        return "categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{idcategoria}")
    public String eliminarCategoria(Categoria categorias, Model model){
        categoriaService.delete(categorias);
        return "redirect:/categoria/listado";
    }
}
