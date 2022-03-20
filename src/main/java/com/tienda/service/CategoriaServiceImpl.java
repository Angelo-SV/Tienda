
package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service /*Informará al controller que ésta clase es accesible como servicio desde
el controller*/
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao CategoriaDao;

    @Override
    @Transactional(readOnly = true)/*Se le instruye a la base de datos que la 
    consulta será sólo de lectura*/
    public List<Categoria> getCategoria(boolean activos) {
        var lista = (List<Categoria>) CategoriaDao.findAll();
        if(activos){lista.removeIf(e -> !e.isActivo());}
        return lista;
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        CategoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        CategoriaDao.delete(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return CategoriaDao.findById(categoria.getIdcategoria()).orElse(null);
    }
}
