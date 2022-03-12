
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;

public interface IPersonaService {/*Una clase interface es una abstracción de lo
    que debería ejecutar una clase posteriormente, es decir, indica qué se va a
    ejecutar pero nunca explica como se ejecutará. La ventaja del Interface es que
    nos brinda una capa de seguridad, oculta el código.*/
    public List<Persona> getAllPerson();
    public void savePerson(Persona persona);
    public Persona getPersonById(long id);
    public void delete(long id);
}
