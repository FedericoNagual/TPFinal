
package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ControladorPersistencia;

/**
 *
 * @author Federico
 */
public class ControladorLogica {

    ControladorPersistencia controlPersistencia = new ControladorPersistencia();

    public void crearEmpleado(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento, String cargo, Double sueldo, String nombreUsuario, String contrasenia) {
        //Creo empleado , usuario y lista venta
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        List<Venta> listaVenta = new ArrayList<Venta>();
        
        //cargo empleado
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        //Parseo de fechas
        
        empleado.setFechaNacimiento(parseFecha(fechaNacimiento));
        
        
        System.out.println("Paso el parseo");
        
        
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);
        
        //usuario
        usuario.setNombre(nombre);
        usuario.setContrasenia(contrasenia);
        
        //Agregar
        empleado.setUsuario(usuario);
        empleado.setListaVenta(listaVenta);
        
        controlPersistencia.crearEmpleado(empleado, usuario);
    }
    
    public Date parseFecha(String fecha){
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public String parseFecha(Date fechaDate){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = sdf.format(fechaDate);
        return fecha;
    }

    public void existeUsuario(String usuario, String contrasenia) {
        Usuario usu = new Usuario();
        usu.setNombre(usuario);
        usu.setContrasenia(contrasenia);
        
        List<Usuario> listaUsuario = new LinkedList<Usuario>();
        
        //listaUsuario=controlPersistencia.traerUsuarios();
    }

    public void crearUsuario(String usuario, String contrasenia) {
        Usuario usu = new Usuario();
        usu.setNombre(usuario);
        usu.setContrasenia(contrasenia);
        
        controlPersistencia.crearUsuario(usu);
    }
}
