
package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity /*Define que la clase es una entidad, mapea la base de datos*/
@Table (name="paises")/*La entidad obtiene información de la tabla que contiene
como nombre paises*/
public class Pais implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)/*Indica que el primary Key
    es autoincremental*/
    private long id;
    private String pais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
