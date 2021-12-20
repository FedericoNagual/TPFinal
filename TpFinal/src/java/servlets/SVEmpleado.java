
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladorLogica;

/**
 *
 * @author Federico
 */
@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
//inicio los controler necesario
    ControladorLogica controlLogica = new ControladorLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for (int i=0; i <10; i++){
            System.out.println("*****");
        }
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int dni = Integer.parseInt(request.getParameter("dni"));
        String direccion = request.getParameter("direccion");
        String nacionalidad = request.getParameter("nacionalidad");
        int celular = Integer.parseInt(request.getParameter("celular"));
        String email = request.getParameter("email");
        String fechaNacimiento = request.getParameter("fechaNacimeinto");
        String cargo =request.getParameter("cargo");
        Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        
        String nombreUsuario = request.getParameter("nombreUsu");
        String contrasenia = request.getParameter("contrasenia");
        
        controlLogica.crearEmpleado(nombre,apellido,dni,direccion,nacionalidad,celular,email,fechaNacimiento,cargo,sueldo,nombreUsuario,contrasenia);
        System.out.println("Paso el controllogica crear empleado volvio al post");
        response.sendRedirect("index.jsp");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
