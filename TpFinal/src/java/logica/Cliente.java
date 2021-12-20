
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

/**
 *
 * @author Federico
 */
@Entity
public class Cliente extends Persona implements Serializable{
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Cliente;
    @OneToMany
    private List<Venta> listaVenta;

    public Cliente() {
    }

    public Cliente(int id_Cliente, List<Venta> listaVenta, int id_Persona, String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, Date fechaNacimiento) {
        super(id_Persona, nombre, apellido, dni, direccion, nacionalidad, celular, email, fechaNacimiento);
        this.id_Cliente = id_Cliente;
        this.listaVenta = listaVenta;
    }

    public Cliente(List<Venta> listaVenta, String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, Date fechaNacimiento) {
        super(nombre, apellido, dni, direccion, nacionalidad, celular, email, fechaNacimiento);
        this.listaVenta = listaVenta;
    }
    

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public List<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        this.listaVenta = listaVenta;
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
