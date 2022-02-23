package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data/*Data lo que hace es generar todos los getter y setter de forma automática*/
@Entity
@Table(name="cliente")
public class Clientes implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idcliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    public Clientes() {
    }

    public Clientes(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
}
