
package logica;

import java.util.Date;
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
public class Cliente extends Persona{
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_Cliente;
    @Basic
    int celular;
    String email;

    public Cliente() {
    }

    public Cliente(int id_Cliente, int celular, String email, String nombre, String apellido, int dni, String direccion, String nacionalidad, Date fechaNacimiento) {
        super(nombre, apellido, dni, direccion, nacionalidad, fechaNacimiento);
        this.id_Cliente = id_Cliente;
        this.celular = celular;
        this.email = email;
    }

    
    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
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
