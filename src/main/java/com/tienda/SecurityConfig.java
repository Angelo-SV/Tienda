package com.tienda;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
/*Le indica al ambiente de Spring que la clase es un archivo de 
configuración*/
@EnableWebSecurity/*Indica al ambiente de Spring que utilizará un recurso de 
seguridad web*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);

        return daoAuthenticationProvider;
    }

    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }

    //El siguiente método funciona para hacer la autenticacion del usuario
    @Override
    protected void configure(AuthenticationManagerBuilder auth){/*Este método crea
            un elemento que instancia usuarios con sus contraseñas y roles*/
            //throws Exception {
            //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
            auth.authenticationProvider(authenticationProvider());
          }
        //auth.inMemoryAuthentication()/*El método va a crear una autenticación en memoria*/
               /* .withUser("admin")//Se crea un usuario llamado Admin
                .password("{noop}123")//La anotación noop evita que la contraseña sea encriptada
                .roles("ADMIN", "VENDEDOR", "USER")//Define los roles para el usuario
                .and()
                .withUser("vendedor")
                .password("{noop}123")
                .roles("VENDEDOR", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");*/

    //El siguiente método funciona para realizar la autorización de accesos
    @Override
    protected void configure(HttpSecurity http) throws Exception {/*El método recibe
        un parámetro de tipo HTTP*/
        http.authorizeRequests()/*Realiza una consulta de autorización, consulta si 
                hay permiso para entrar a un Mapping en particular*/
                .antMatchers("/personas")
                .hasRole("ADMIN")/*El usuario podrá ingresar a todos los mapping
                indicados anteriormente si cumple con el rol indicado*/
                .antMatchers("/PersonaNueva", "/personas")
                .hasAnyRole("USER", "VENDEDOR", "ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER", "ADMIN", "VENDEDOR")
                .and()/*Si el usuario no se encuentra autenticado, se enviará primero
                a la página de login para que lo haga*/
                .formLogin()
                .loginProcessingUrl("/signin").permitAll();
                /*.loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");*/
    }

}
