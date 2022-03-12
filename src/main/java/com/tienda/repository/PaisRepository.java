

/*El repositorio realiza las consultas a la base de datos*/
package com.tienda.repository;
import com.tienda.entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais,Long>{/*El repositorio
    solicita la información de la base de datos y la guarda en la entidad*/
    
}
