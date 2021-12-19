
package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Federico
 */
@Entity
public class ServicioTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private int codigo_servicio;
    private String nombre;
    private String descripcion_breve;
    private String destino_servicio;
    private double costo_servicio;
    @Temporal(TemporalType.DATE)
    private Date fecha_servicio;
    @OneToOne
    private TipoServicioTurismo tipoServicioTuristico;
    @OneToMany
    private List<PaqueteTuristico> listaPaqueteTuristico;
    @OneToMany
    private List<Venta> listaVenta;

    public ServicioTuristico() {
    }

    public ServicioTuristico(int id, int codigo_servicio, String nombre, String descripcion_breve, String destino_servicio, double costo_servicio, Date fecha_servicio, TipoServicioTurismo tipoServicioTuristico, List<PaqueteTuristico> listaPaqueteTuristico, List<Venta> listaVenta) {
        this.id = id;
        this.codigo_servicio = codigo_servicio;
        this.nombre = nombre;
        this.descripcion_breve = descripcion_breve;
        this.destino_servicio = destino_servicio;
        this.costo_servicio = costo_servicio;
        this.fecha_servicio = fecha_servicio;
        this.tipoServicioTuristico = tipoServicioTuristico;
        this.listaPaqueteTuristico = listaPaqueteTuristico;
        this.listaVenta = listaVenta;
    }

    public ServicioTuristico(int codigo_servicio, String nombre, String descripcion_breve, String destino_servicio, double costo_servicio, Date fecha_servicio, TipoServicioTurismo tipoServicioTuristico, List<PaqueteTuristico> listaPaqueteTuristico, List<Venta> listaVenta) {
        this.codigo_servicio = codigo_servicio;
        this.nombre = nombre;
        this.descripcion_breve = descripcion_breve;
        this.destino_servicio = destino_servicio;
        this.costo_servicio = costo_servicio;
        this.fecha_servicio = fecha_servicio;
        this.tipoServicioTuristico = tipoServicioTuristico;
        this.listaPaqueteTuristico = listaPaqueteTuristico;
        this.listaVenta = listaVenta;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(int codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion_breve() {
        return descripcion_breve;
    }

    public void setDescripcion_breve(String descripcion_breve) {
        this.descripcion_breve = descripcion_breve;
    }

    public String getDestino_servicio() {
        return destino_servicio;
    }

    public void setDestino_servicio(String destino_servicio) {
        this.destino_servicio = destino_servicio;
    }

    public double getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public Date getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(Date fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public TipoServicioTurismo getTipoServicioTuristico() {
        return tipoServicioTuristico;
    }

    public void setTipoServicioTuristico(TipoServicioTurismo tipoServicioTuristico) {
        this.tipoServicioTuristico = tipoServicioTuristico;
    }

    public List<PaqueteTuristico> getListaPaqueteTuristico() {
        return listaPaqueteTuristico;
    }

    public void setListaPaqueteTuristico(List<PaqueteTuristico> listaPaqueteTuristico) {
        this.listaPaqueteTuristico = listaPaqueteTuristico;
    }

    public List<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }
    
    
}
