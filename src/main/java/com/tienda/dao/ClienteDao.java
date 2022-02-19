package com.tienda.dao;

import com.tienda.domain.Clientes;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Clientes, Long>{
    
}
