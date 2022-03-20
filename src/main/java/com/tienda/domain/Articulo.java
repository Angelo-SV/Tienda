package com.tienda.domain;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data/*Data lo que hace es generar todos los getter y setter de forma automática,
pertenece a la librería loombok*/
@Entity/*Permite mapear los datos o la tabla desde la base de datos MySQL*/
@Table(name="articulo")/*Especifica el nombre de la tabla de la cual se está
obtieniendo los datos desde MySQL*/
public class Articulo implements Serializable{/*La clase debe implementar 
    Serializable cuando trabaja con bases de datos, la clase serializable convierte
    un objeto en una secuencia de bytes para almacenarlo o transmitirlo a la 
    memoria, a una base de datos o a un archivo.*/
    private static final long serialVersionUID= 1L;/*Crea un atributo para que 
    se pueda realizar el mapeo a la base de datos de tipo Long*/
    @Id/*Define la llave primaria*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private Long idarticulo;
    private Long idcategoria;
    private String descripcion;
    private String detalle;
    private Double precio;
    private int existencias;
    private boolean activo;

    public Articulo() {
    }

    public Articulo(Long idcategoria, String descripcion, String detalle, Double precio, int existencias, boolean activo) {
        this.idcategoria = idcategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
}
