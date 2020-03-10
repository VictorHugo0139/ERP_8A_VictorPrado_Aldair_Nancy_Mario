
package Controlador;

import Conexion.Conexion;
import Modelo.Usuarios;
import Modelo.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {
    Conexion cn = new Conexion();
    Connection con;
    UsuariosDAO usrDao= new UsuariosDAO();
    Usuarios usr= new Usuarios();
    int r;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        switch(accion){
            case "Ingresar":
                String nom=request.getParameter("Usuario");
            String contra=request.getParameter("Password");
            usr.setNombre(nom);
            usr.setContrasenia(contra);
            r=usrDao.validar(usr);
            if (r==1) {
                cn.setUserName(nom);
                cn.setPassword(contra);
                con=cn.getConnection();
                request.getSession().setAttribute("nom", nom);
                request.getRequestDispatcher("principal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
                break;
            case "Salir":
                cn.closeConnection();
            request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "Cultivos":
                request.getRequestDispatcher("ViewCultivos.jsp").forward(request, response);
                break;
            case "Clientes":
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "Transportes":
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "Socios":
                request.getRequestDispatcher("ViewSocios.jsp").forward(request, response);
                break;
            case "ClientesI":
                System.out.println("Estoy ingresando datos");
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
