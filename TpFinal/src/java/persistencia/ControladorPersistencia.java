package persistencia;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.Usuario;
import logica.PaqueteTuristico;
import logica.MedioPago;
import logica.ServicioTuristico;
import logica.TipoServicioTurismo;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Federico
 */
public class ControladorPersistencia {

    //Instancio los JPA controller necesarios 
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    ServicioTuristicoJpaController servicioJPA = new ServicioTuristicoJpaController();
    PaqueteTuristicoJpaController paqueteJPA = new PaqueteTuristicoJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();

    //Usuario
    public void crearUsuario(Usuario usu) {
        try {
            usuarioJPA.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario buscarUsuario(int id) {
        Usuario usuario = new Usuario();

        usuario = usuarioJPA.findUsuario(id);

        return usuario;
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarUsuario(Usuario usu) {
        try {
            usuarioJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> listaUsuarios = usuarioJPA.findUsuarioEntities();

        return listaUsuarios;
    }

    //Empleado
    public void crearEmpleado(Empleado empleado, Usuario usuario) {
        try {
            usuarioJPA.create(usuario);
            empleadoJPA.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(int id) {
        Empleado empleado = new Empleado();

        empleado = empleadoJPA.findEmpleado(id);

        return empleado;
    }

    public void eliminarEmpleado(int id) {
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEmpleado(Empleado empleado) {
        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> listarEmpleado() {
        List<Empleado> listaEmpleado = new LinkedList<Empleado>();

        listaEmpleado = empleadoJPA.findEmpleadoEntities();

        return listaEmpleado;
    }

    //Cliente
    public void crearCliente(Cliente cliente) {
        try {
            clienteJPA.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente buscarCliente(int id) {
        Cliente cliente = new Cliente();
        cliente = clienteJPA.findCliente(id);
        return cliente;
    }

    public void eliminarCliente(int id) {
        try {
            clienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarCliente(Cliente cliente) {
        try {
            clienteJPA.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> listarCliente() {
        List<Cliente> listaCliente = new LinkedList<Cliente>();

        listaCliente = clienteJPA.findClienteEntities();

        return listaCliente;
    }

    //Servicio
    
    public void crearServicio(ServicioTuristico servicio) {
        try {
            servicioJPA.create(servicio);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServicioTuristico buscarServicioTuristico(int id) {
        ServicioTuristico servicioTuristico = new ServicioTuristico();
        servicioTuristico = servicioJPA.findServicioTuristico(id);
        return servicioTuristico;
    }

    public void eliminarServicioTuristico(int id) {
        try {
            servicioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarServicioTuristico(ServicioTuristico servicioTuristico) {
        try {
            servicioJPA.edit(servicioTuristico);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ServicioTuristico> listarServicioTuristico() {
        List<ServicioTuristico> listaServicioTuristico = new LinkedList<ServicioTuristico>();

        listaServicioTuristico = servicioJPA.findServicioTuristicoEntities();

        return listaServicioTuristico;
    }
    //Paquete
    
    public void crearPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
        try {
            paqueteJPA.create(paqueteTuristico);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PaqueteTuristico buscarPaqueteTuristico(int id) {
        PaqueteTuristico paqueteTuristico = new PaqueteTuristico();
        paqueteTuristico = paqueteJPA.findPaqueteTuristico(id);
        return paqueteTuristico;
    }

    public void eliminarPaqueteTuristico(int id) {
        try {
            paqueteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
        try {
            paqueteJPA.edit(paqueteTuristico);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PaqueteTuristico> listarPaqueteTuristico() {
        List<PaqueteTuristico> listaPaqueteTuristico = new LinkedList<PaqueteTuristico>();

        listaPaqueteTuristico= paqueteJPA.findPaqueteTuristicoEntities();

        return listaPaqueteTuristico;
    }
    //Venta
    
    public void crearVenta(Venta venta) {
        try {
            ventaJPA.create(venta);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Venta buscarVenta(int id) {
        Venta venta = new Venta();
        venta=ventaJPA.findVenta(id);
        return venta;
    }

    public void eliminarVenta(int id) {
        try {
            ventaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarVenta(Venta venta) {
        try {
            ventaJPA.edit(venta);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Venta> listarVenta() {
        List<Venta> listaVenta = new LinkedList<Venta>();

        listaVenta= ventaJPA.findVentaEntities();

        return listaVenta;
    }
}
