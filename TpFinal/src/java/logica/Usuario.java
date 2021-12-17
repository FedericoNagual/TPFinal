
package logica;

/**
 *
 * @author Federico
 */
public class Usuario {
    int id_usuario;
    String nombre ;
    String contrasenia;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, String contrasenia) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
