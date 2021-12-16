
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Federico
 */
@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private int numero_venta;
    private double monto_venta;
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;
    @OneToOne
    private MedioPago medioPago;

    public Venta() {
    }

    public Venta(int id, int numero_venta, double monto_venta, Date fecha_venta, MedioPago medioPago) {
        this.id = id;
        this.numero_venta = numero_venta;
        this.monto_venta = monto_venta;
        this.fecha_venta = fecha_venta;
        this.medioPago = medioPago;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getMonto_venta() {
        return monto_venta;
    }

    public void setMonto_venta(double monto_venta) {
        this.monto_venta = monto_venta;
    }
    
    
}
