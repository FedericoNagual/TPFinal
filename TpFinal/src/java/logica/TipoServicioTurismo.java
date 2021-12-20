/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Federico
 */
@Entity
public class TipoServicioTurismo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_TipoServicioTurismo;
    @Basic
    private String nombre;

    public TipoServicioTurismo(String nombre) {
        this.nombre = nombre;
    }

    public TipoServicioTurismo() {
    }

    public TipoServicioTurismo(int id_TipoServicioTurismo, String nombre) {
        this.id_TipoServicioTurismo = id_TipoServicioTurismo;
        this.nombre = nombre;
    }

    public int getId_TipoServicioTurismo() {
        return id_TipoServicioTurismo;
    }

    public void setId_TipoServicioTurismo(int id_TipoServicioTurismo) {
        this.id_TipoServicioTurismo = id_TipoServicioTurismo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
