package persistencia;

import java.util.List;
import logica.Empleado;
import logica.Usuario;

/**
 *
 * @author Federico
 */
public class ControladorPersistencia {

    //Instancio los JPA controller necesarios 
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    
    
    public void crearEmpleado(Empleado empleado, Usuario usuario) {
        usuarioJPA.create(usuario);
        empleadoJPA.create(empleado);
    }
/*
    public List<Usuario> traerUsuarios() {
       //incompleto
       return 
    }
  */  

    public void crearUsuario(Usuario usu) {
        usuarioJPA.create(usu);
    }
}
