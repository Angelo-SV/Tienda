/*
Internacionalizacion -i18n - 18 letras entre I y n
Locale: Representa el lenguaje, la region geográfica, variantes del dialecto/idioma,
de un usuario
SessionLocaleResolver: guardar el Locale seleccionado por un usuario como atributo
en el request HTTP
LocaleChangeInterceptor: Detectar  cualquier cambio de parte del usuario hacia lo
que es el Locale
 */
package com.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration/*Indica que la clase es de tipo configuración*/
/*Ésta clase maneja toda la internacionalización de la página*/
public class WebConfig implements WebMvcConfigurer{/*Clase que forma parte del
    framework de Spring*/
    @Bean/*Ésta anotación indica que lo que se encuentre dentro de la clase, se 
    creará automáticamente dentro del ambiente de springboot*/
    public SessionLocaleResolver localeResolver(){/*Se está seteando por defecto
        que el idioma de la página es inglés, es el solucionador de ubicaciones*/
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("en"));/*Establece que el idioma 
        predeterminado es español*/
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){/*La clase actua
        como una intersección dinámica entre los cambios de idioma*/
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");/*"Lang"=Lenguaje se utiliza como parámetro para
        configurar el lenguaje*/
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){/*El método 
        registra unas vistas que no deben pasar por un controlador para que sean 
        ubicados y utilizados en el sitio web. Se ingresan las páginas de login 
        y las de errores*/
        registro.addViewController("/").setViewName("/nuevaPersona");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
}
