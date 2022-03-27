    package com.tienda.controller;

import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
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
public class ArticuloController {
    @Autowired/*Permite enlazar un objeto*/
    private ArticuloService articuloService;
    //Se invoca la interfaz y spring busca la clase que la implementa en automático
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/articulo/listado")/*"Mapeo del URL"La bronca es aquí en index controller*/
    public String incio(Model model){/*Luego de mapear la URL, se genera el 
        método el cual puede tener cualquier nombre. Es decir, el método se 
        invocará cuando se solicite "/" en éste caso localhost página principal.
        Para utilizar el modelo simplemente se exporta la librería correspondiente
        y se crea el parámetro en el método sin necesidad de inicializarlo*/
        log.info("Estamos usando una arquitectura mvc");/*Muestra un mensaje al 
        usuario en la pantalla. La arquitectura MVC se basa en Model, View and 
        Controller*/
        var articulo=articuloService.getArticulo(false);
        model.addAttribute("articulo", articulo);/*Se crea el modelo para enviar la
        variable o el objeto a la vista. El dato entre comillas es el nombre de 
        la variable del modelo.*/
        return "articulo/listado";/*El controlador siempre devolverá la vista o plantilla
        que queremos mostrar, index en éste caso. Se retorna simplemente con el 
        nombre de la vista*/
    }
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulos, Model model){
        var categorias = categoriaService.getCategoria(true);
        model.addAttribute("categorias", categorias);
        return "articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulos){
        articuloService.save(articulos);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificar/{idarticulo}")
    public String modificarArticulo(Articulo articulos, Model model){
        var categorias = categoriaService.getCategoria(true);
        articulos = articuloService.getArticulo(articulos);
        model.addAttribute("articulo", articulos);
        return "articulo/modificar";
    }
    
    @GetMapping("/articulo/eliminar/{idarticulo}")
    public String eliminarArticulo(Articulo articulos, Model model){
        articuloService.delete(articulos);
        return "redirect:/articulo/listado";
    }
}
