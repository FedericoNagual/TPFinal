/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
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
@PrimaryKeyJoinColumn(referencedColumnName = "idPersonaCli")
public class Cliente extends Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private int celular;
    private String email;
    //necesario para conectar con el JPA y que pueda formar las clases
    @OneToOne
    private int idPersonaCli;
    @OneToMany
    private List<Venta> listaVenta;

    public Cliente() {

    }

    public Cliente(int idC, int celular, String email, int idPersonaCli, List<Venta> listaVenta, int id, String nombre, String apellido, int dni, String direccion, String nacionalidad, Date fecha_nac) {
        super(id, nombre, apellido, dni, direccion, nacionalidad, fecha_nac);
        this.id = idC;
        this.celular = celular;
        this.email = email;
        this.idPersonaCli = idPersonaCli;
        this.listaVenta = listaVenta;
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
