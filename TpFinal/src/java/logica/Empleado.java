
package logica;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Federico
 */
@Entity
public class Empleado extends Persona {
    
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id_empleado;
    @Basic
    String cargo;
    double sueldo;
    int celular;
    String email;
    @OneToOne
    Usuario usuario;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int dni, String direccion, String nacionalidad,Date fechaNacimiento,int id_empleado, String cargo, double sueldo, int celular, String email, Usuario usuario) {
        super(nombre, apellido, dni, direccion, nacionalidad, fechaNacimiento);
        this.id_empleado = id_empleado;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.celular = celular;
        this.email = email;
        this.usuario = usuario;
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
