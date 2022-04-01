
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*De la capa de negocio se debe implementar un servicio, por lo que se debe crear
un interface y una clase que lo implemente como tal*/
@Service/*Define que la clase es de tipo servicio*/
public class PersonaService implements IPersonaService{
    
    @Autowired//Inyección de dependencias
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> getAllPerson() {
        return (List<Persona>)personaRepository.findAll();
    }

    @Override
    @Transactional
    public void savePerson(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona getPersonById(long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }
}
