
package logica;

import com.mysql.cj.x.protobuf.Mysqlx;
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

    //Usuario
    
    public void crearUsuario(String usuario, String contrasenia) {
        Usuario usu = new Usuario();
        usu.setNombre(usuario);
        usu.setContrasenia(contrasenia);
        
        controlPersistencia.crearUsuario(usu);
    }
    
    public Usuario buscarUsuario(int id){
        Usuario usu = new Usuario();
        
        usu = controlPersistencia.buscarUsuario(id);
        
        return usu;
    }

    
    public void eliminarUsuario(int id){
        controlPersistencia.eliminarUsuario(id);
    }
    
    public void modificarUsuario(int id,String nombreUsuario, String contrasenia){
        Usuario usu = new Usuario();
        usu.setId_usuario(id);
        usu.setNombre(nombreUsuario);
        usu.setContrasenia(contrasenia);
        
        controlPersistencia.modificarUsuario(usu);
        
    }
    
    public List<Usuario> listarUsuario(){
        return controlPersistencia.listarUsuario();
    }
    
    
    public boolean existeUsuario(String usuario, String contrasenia) {
        boolean flag= false;
        
        List<Usuario> listaUsu = listarUsuario();
        
        for (int i=0; i < listaUsu.size();i++ ){
            if (listaUsu.get(i).getNombre().equals(usuario) && listaUsu.get(i).getContrasenia().equals(contrasenia)){
                flag=true;
            }
        }
        
        return flag;
    }
    
    
    //Empleados 
    
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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        empleado.setFechaNacimiento((Date) parseFecha(fechaNacimiento));
        
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
    
    
    public Empleado buscarEmpleado(int id){
        Empleado empleado = new Empleado();
        
        empleado = controlPersistencia.buscarEmpleado(id);
        
        return empleado;
    }

    
    public void eliminarEmpleado(int id){
        controlPersistencia.eliminarEmpleado(id);
    }
    
    public void modificarEmpleado(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento, String cargo, Double sueldo){
        Empleado empleado =new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);
        
        controlPersistencia.modificarEmpleado(empleado);
        
    }
    
    public List<Empleado> listarEmpleado(){
        return controlPersistencia.listarEmpleado();
    }

    
    //Cliente
    
    
    public void crearCliente(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setDireccion(direccion);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        cliente.setFechaNacimiento(parseFecha(fechaNacimiento));
        
        controlPersistencia.crearCliente(cliente);
    }

    public Cliente buscarCliente(int id){
        Cliente cliente = new Cliente();
        cliente= controlPersistencia.buscarCliente(id);
        return cliente;
    }

    
    public void eliminarCliente(int id){
        controlPersistencia.eliminarCliente(id);
    }
    
    public void modificarCliente(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento, String cargo, Double sueldo){
        Empleado empleado =new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);
        
        controlPersistencia.modificarEmpleado(empleado);
        
    }
    
    public List<Cliente> listarCliente(){
        return controlPersistencia.listarCliente();
    }

    
    //Venta
    
    
    public void crearVenta(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setDireccion(direccion);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        cliente.setFechaNacimiento(parseFecha(fechaNacimiento));
        
        controlPersistencia.crearCliente(cliente);
    }

    public Venta buscarVenta(int id){
        Venta venta = new Venta();
        venta= controlPersistencia.buscarVenta(id);
        return venta;
    }

    
    public void eliminarVenta(int id){
        controlPersistencia.eliminarVenta(id);
    }
    
    public void modificarVenta(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento, String cargo, Double sueldo){
        Empleado empleado =new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);
        
        controlPersistencia.modificarEmpleado(empleado);
        
    }
    
    public List<Venta> listarVenta(){
        return controlPersistencia.listarVenta();
    }

    //Servicio
    
    
    public void crearServiciosTuristicos(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setDireccion(direccion);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        cliente.setFechaNacimiento(parseFecha(fechaNacimiento));
        
        controlPersistencia.crearCliente(cliente);
    }

    public ServicioTuristico buscarServiciosTuristicos(int id){
        ServicioTuristico ServiciosTuristicos = new ServicioTuristico();
        ServiciosTuristicos= controlPersistencia.buscarServicioTuristico(id);
        return ServiciosTuristicos;
    }

    
    public void eliminarServiciosTuristicos(int id){
        controlPersistencia.eliminarServicioTuristico(id);
    }
    
    public void modificarServiciosTuristicos(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento, String cargo, Double sueldo){
        Empleado empleado =new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);
        
        controlPersistencia.modificarEmpleado(empleado);
        
    }
    
    public List<ServicioTuristico> listarServiciosTuristicos(){
        return controlPersistencia.listarServicioTuristico();
    }
    
    //Paquete
    
    
    public void crearPaqueteTuristico(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setDireccion(direccion);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        cliente.setFechaNacimiento(parseFecha(fechaNacimiento));
        
        controlPersistencia.crearCliente(cliente);
    }

    public PaqueteTuristico buscarPaqueteTuristico(int id){
        PaqueteTuristico PaqueteTuristico = new PaqueteTuristico();
        PaqueteTuristico= controlPersistencia.buscarPaqueteTuristico(id);
        return PaqueteTuristico;
    }

    
    public void eliminarPaqueteTuristico(int id){
        controlPersistencia.eliminarPaqueteTuristico(id);
    }
    
    public void modificarPaqueteTuristico(String nombre, String apellido, int dni, String direccion, String nacionalidad, int celular, String email, String fechaNacimiento, String cargo, Double sueldo){
        Empleado empleado =new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);
        
        controlPersistencia.modificarEmpleado(empleado);
        
    }
    
    public List<PaqueteTuristico> listarPaqueteTuristico(){
        return controlPersistencia.listarPaqueteTuristico();
    }

}
