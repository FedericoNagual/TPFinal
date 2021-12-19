package logica;

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
public class MedioPago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_MedioPago;
    @Basic
    private String nombre;
    private String descripcion;

    public MedioPago(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public MedioPago() {
    }

    public MedioPago(int id_MedioPago, String nombre, String descripcion) {
        this.id_MedioPago = id_MedioPago;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_MedioPago() {
        return id_MedioPago;
    }

    public void setId_MedioPago(int id_MedioPago) {
        this.id_MedioPago = id_MedioPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
