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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Federico
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "empleado_persona")
public class Empleado extends Persona{
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String cargo;
    private double sueldo;
    private int celular;
    private String email;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Venta> listaVenta;

    public Empleado() {
    }

    public Empleado(int id, String cargo, double sueldo, int celular, String email, Usuario usuario, List<Venta> listaVenta, String nombre, String apellido, int dni, Date fecha_nac, String direccion, String nacionalidad) {
        super(nombre, apellido, dni, fecha_nac, direccion, nacionalidad);
        this.id = id;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.celular = celular;
        this.email = email;
        this.usuario = usuario;
        this.listaVenta = listaVenta;
    }


    public List<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    
}
