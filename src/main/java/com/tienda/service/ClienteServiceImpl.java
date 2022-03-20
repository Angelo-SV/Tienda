
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Clientes;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service /*Informará al controller que ésta clase es accesible como servicio desde
el controller*/
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)/*Se le instruye a la base de datos que la 
    consulta será sólo de lectura*/
    public List<Clientes> getClientes() {
        return (List<Clientes>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Clientes clientes) {
        Credito credito = clientes.getCredito();
        credito = creditoDao.save(credito);
        clientes.setCredito(credito);
        clienteDao.save(clientes);
    }

    @Override
    @Transactional
    public void delete(Clientes clientes) {
        clienteDao.delete(clientes);
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes getClientes(Clientes clientes) {
        return clienteDao.findById(clientes.getIdcliente()).orElse(null);
    }
    
}
