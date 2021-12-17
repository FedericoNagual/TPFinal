
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladorEmpleado;

/**
 *
 * @author Federico
 */
@WebServlet(name = "SVEmpleado", urlPatterns = {"/SVEmpleado"})
public class SVEmpleado extends HttpServlet {
//inicio los controler necesario
    ControladorEmpleado controlEmp = new ControladorEmpleado();
    
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
        String nombreUsuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("password");
        String cargo =request.getParameter("cargo");
        Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        String email = request.getParameter("email");
        
        controlEmp.crearEmpleado(nombreUsuario,contrasenia,cargo,sueldo,celular,email);
        
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
