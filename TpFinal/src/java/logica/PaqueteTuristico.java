
package logica;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Federico
 */
@Entity
class PaqueteTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private int codigo_paquete;
    private double costo_paquete;
    @OneToMany
    private List<Venta> listaVenta;
    @OneToMany
    private List<ServicioTuristico> listaServicioTuristico;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int id, int codigo_paquete, double costo_paquete, List<Venta> listaVenta, List<ServicioTuristico> listaServicioTuristico) {
        this.id = id;
        this.codigo_paquete = codigo_paquete;
        this.costo_paquete = costo_paquete;
        this.listaVenta = listaVenta;
        this.listaServicioTuristico = listaServicioTuristico;
    }

    public PaqueteTuristico(int codigo_paquete, double costo_paquete, List<Venta> listaVenta, List<ServicioTuristico> listaServicioTuristico) {
        this.codigo_paquete = codigo_paquete;
        this.costo_paquete = costo_paquete;
        this.listaVenta = listaVenta;
        this.listaServicioTuristico = listaServicioTuristico;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_paquete() {
        return codigo_paquete;
    }

    public void setCodigo_paquete(int codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }

    public double getCosto_paquete() {
        return costo_paquete;
    }

    public void setCosto_paquete(double costo_paquete) {
        this.costo_paquete = costo_paquete;
    }

    public List<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }

    public List<ServicioTuristico> getListaServicioTuristico() {
        return listaServicioTuristico;
    }

    public void setListaServicioTuristico(List<ServicioTuristico> listaServicioTuristico) {
        this.listaServicioTuristico = listaServicioTuristico;
    }
    
    
}
