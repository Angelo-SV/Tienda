package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data/*Data lo que hace es generar todos los getter y setter de forma automática,
pertenece a la librería loombok*/
@Entity/*Permite mapear los datos o la tabla desde la base de datos MySQL*/
@Table(name="cliente")/*Especifica el nombre de la tabla de la cual se está
obtieniendo los datos desde MySQL*/
public class Clientes implements Serializable{/*La clase debe implementar 
    Serializable cuando trabaja con bases de datos, la clase serializable convierte
    un objeto en una secuencia de bytes para almacenarlo o transmitirlo a la 
    memoria, a una base de datos o a un archivo.*/
    private static final long serialVersionUID= 1L;/*Crea un atributo para que 
    se pueda realizar el mapeo a la base de datos de tipo Long*/
    @Id/*Define la llave primaria*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idcliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    
    @JoinColumn(name="id_credito", referencedColumnName = "id_credito")/*Agrega la 
    asociación con la clase/tabla crédito*/
    @ManyToOne/*Especifica el tipo de asociación*/
    private Credito credito;

    public Clientes() {
    }

    public Clientes(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Clientes(Long idcliente, String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }
    
    
}
