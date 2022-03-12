
package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/personas")
        public String index(Model model){
            List<Persona> listaPersonas =personaService.getAllPerson();
            model.addAttribute("titulo", "Personas");
            model.addAttribute("personas", listaPersonas);
            return "personas";
        }
        
    @GetMapping("/nuevaPersona")
    public String nuevaPersona(Model model){
        model.addAttribute("persona", new Persona());
        //personaService.savePerson(persona);
        return "modificarPersona";
    }
    
    @PostMapping("/guardarPersona")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.savePerson(persona);
        return "redirect:/personas";
    }
    
    @GetMapping("/eliminarPersona/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona){/*El 
        PathVariable lo que hace es tomar el dato del GetMapping y se define como
        tipo long con el nombre idPersona*/
        personaService.delete(idPersona);
        return "redirect:/personas";
    }
    
    @GetMapping("/modificarPersona/{id}")
    public String modificarPersona(@PathVariable("id") Long idPersona, Model model){
        personaService.getPersonById(idPersona);
        model.addAttribute("persona", idPersona);
        return "modificarPersona";
    }
}
