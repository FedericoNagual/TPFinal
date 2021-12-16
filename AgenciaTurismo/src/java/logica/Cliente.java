/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Federico
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "cliente_persona")
public class Cliente extends Persona {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private int celular;
    private String email;
    @OneToMany
    private List<Venta> listaVenta;

    public Cliente() {

    }

    public Cliente(int id, int celular, String email, String nombre, String apellido, int dni, Date fecha_nac, String direccion, String nacionalidad) {
        super(nombre, apellido, dni, fecha_nac, direccion, nacionalidad);
        this.id = id;
        this.celular = celular;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
