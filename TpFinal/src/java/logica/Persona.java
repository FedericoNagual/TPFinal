
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Federico
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id_Persona;
    @Basic
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected String direccion;
    protected String nacionalidad;
    protected int celular;
    protected String email;
    @Temporal(TemporalType.DATE)
    protected Date fechaNacimiento;

    public Persona() {
    }

    public Persona(int id_Persona, String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, Date fechaNacimiento) {
        this.id_Persona = id_Persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    
    

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
    public abstract void setCelular(int celular);
    public abstract int getCelular();
    public abstract void setEmail(String email);
    public abstract String getEmail();
    
}
