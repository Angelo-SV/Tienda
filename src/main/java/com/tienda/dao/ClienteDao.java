package com.tienda.dao;

import com.tienda.domain.Clientes;
import org.springframework.data.repository.CrudRepository;
/*Dao significa Data Access Only*/
public interface ClienteDao extends CrudRepository<Clientes, Long>{/*Se le envia
    como parámetro la clase Clientes y el tipo de dato de la llave primaria(Long.
    CRUD (Create, read, update and delete) se refiere a las funciones básicas de
    una base de datos o la capa de persistencia de un software. La interfaz
    CrudRepository proporciona los métodos para operaciones CRUD sin tener que 
    definir los métodos. El repositorio es el encargado de ir a la base de datos
    y tomar la información y mapearlos a una entidad*/
    
}
