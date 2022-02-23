
package com.tienda.service;

import com.tienda.domain.Clientes;
import java.util.List;

public interface ClienteService {
    public List<Clientes> getClientes();
    public void save(Clientes clientes);
    public void delete(Clientes clientes);
    public Clientes getClientes(Clientes clientes);
}
