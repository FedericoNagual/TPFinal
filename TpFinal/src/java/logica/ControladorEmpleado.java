
package logica;

/**
 *
 * @author Federico
 */
public class ControladorEmpleado {

    public void crearEmpleado(String nombreUsuario, String contrasenia, String cargo, Double sueldo, int celular, String email) {
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        //Asigno valores a empleado
        empleado.setCargo(cargo);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setSueldo(sueldo);
        //Asigno valores a usuario
        usuario.setNombre(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        //Agrego usuario a empleado
        empleado.setUsuario(usuario);
    }
    
}
