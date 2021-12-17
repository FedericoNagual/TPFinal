
package logica;

/**
 *
 * @author Federico
 */
public class Empleado {
    int id_empleado;
    String cargo;
    Double sueldo;
    int celular;
    String email;
    
    Usuario usuario;

    public Empleado() {
    }

    public Empleado(int id_empleado, String cargo, Double sueldo, int celular, String email, Usuario usuario) {
        this.id_empleado = id_empleado;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.celular = celular;
        this.email = email;
        this.usuario = usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
