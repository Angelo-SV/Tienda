
package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller /*El controlador se encarga del back-end de la aplicación, la clase
spring incluye m*/
public class LoginController {
    @GetMapping({"/","/perro"})/*El controlador le indica al proyecto que en caso 
    de que se ingrese con "slash" o con la dirección perro lo redireccione al 
    login.html, para que funcione se debe ingresar el archivo (login en este caso) 
    en la carpeta de templates. El controlodor es el medio entre el back-end y el 
    front-end, recibe las peticiones y las ejecuta. Es el que captura las URL Request
    */
    public String index(){
        return "login";
    }
}
