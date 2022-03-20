
package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service /*Informará al controller que ésta clase es accesible como servicio desde
el controller*/
public class ArticuloServiceImpl1 implements ArticuloService {
    
    @Autowired
    private ArticuloDao ArticuloDao;

    @Override
    @Transactional(readOnly = true)/*Se le instruye a la base de datos que la 
    consulta será sólo de lectura*/
    public List<Articulo> getArticulo(boolean activos) {
        var lista = (List<Articulo>) ArticuloDao.findAll();
        if(activos){lista.removeIf(e -> !e.isActivo());}
        return lista;
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        ArticuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        ArticuloDao.delete(articulo);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return ArticuloDao.findById(articulo.getIdarticulo()).orElse(null);
    }
}
