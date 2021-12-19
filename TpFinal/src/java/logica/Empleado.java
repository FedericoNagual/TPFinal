
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

/**
 *
 * @author Federico
 */
@Entity
public class Empleado extends Persona {
    
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_empleado;
    @Basic
    private String cargo;
    private double sueldo;
    @OneToOne
    private Usuario usuario;
    @OneToMany
    private List<Venta> listaVenta;

    public Empleado() {
    }

    public List<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }

    public Empleado(int id_empleado, String cargo, double sueldo, Usuario usuario, List<Venta> listaVenta, int id_Persona, String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, Date fechaNacimiento) {
        super(id_Persona, nombre, apellido, dni, direccion, nacionalidad, celular, email, fechaNacimiento);
        this.id_empleado = id_empleado;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.listaVenta = listaVenta;
    }

    public Empleado(String cargo, double sueldo, Usuario usuario, List<Venta> listaVenta, String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, Date fechaNacimiento) {
        super(nombre, apellido, dni, direccion, nacionalidad, celular, email, fechaNacimiento);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.listaVenta = listaVenta;
    }

    


    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    @Override
    public void setCelular(int celular) {
        this.celular=celular;
    }

    @Override
    public int getCelular() {
        return this.celular;
    }

    @Override
    public void setEmail(String email) {
        this.email=email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    
}
