
package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    public List<Articulo> getArticulo(boolean activos);
    public void save(Articulo clientes);
    public void delete(Articulo clientes);
    public Articulo getArticulo(Articulo clientes);
}
