package Controlador;

import Conexion.Conexion;
import Modelo.Clientes;
import Modelo.Usuarios;
import Modelo.datos.ClientesDAO;
import Modelo.datos.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Conexion cn = new Conexion();
    Connection con;
    UsuariosDAO usrDao = new UsuariosDAO();
    Usuarios usr = new Usuarios();
    ClientesDAO cldao = new ClientesDAO();
    Clientes cl = new Clientes();
    List<Clientes> datosC = new ArrayList<>();
    int r;
    String res;

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
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Ingresar":
                String nom = request.getParameter("Usuario");
                String contra = request.getParameter("Password");
                usr.setNombre(nom);
                usr.setContrasenia(contra);
                r = usrDao.validar(usr);
                if (r == 1) {
                    cn.setUserName(nom);
                    cn.setPassword(contra);
                    con = cn.getConnection();
                    request.getSession().setAttribute("nom", nom);
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                } else {
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
                datosC = cldao.consultar();
                request.setAttribute("datosCl", datosC);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "Transportes":
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "Socios":
                request.getRequestDispatcher("ViewSocios.jsp").forward(request, response);
                break;
            case "Ofertas":
                request.getRequestDispatcher("ViewOfertas.jsp").forward(request, response);
                break;
            case "Miembros":
                request.getRequestDispatcher("ViewMiembros.jsp").forward(request, response);
                break;
            case "ClientesI":
                cl = new Clientes(0,
                        request.getParameter("txtNombre"),
                        request.getParameter("txtRazonSocial"),
                        Float.parseFloat(request.getParameter("txtLimiteCredito")), 
                        request.getParameter("txtDireccion"), 
                        request.getParameter("txtCodigoPostal"), 
                        request.getParameter("txtRFC"), 
                        request.getParameter("txtTelefono"), 
                        request.getParameter("txtEmail"), 
                        request.getParameter("txtTipo").charAt(0), 
                        Integer.parseInt(request.getParameter("txtCiudad")), 
                        request.getParameter("txtEstatus").charAt(0));
                res=cldao.insertar(cl);
                datosC = cldao.consultar();
                request.setAttribute("datosCl", datosC);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "ClientesU":
                datosC = cldao.consultarId(Integer.parseInt(request.getParameter("idc")));
                
                cl = new Clientes(datosC.get(0).getIdCliente(),
                        datosC.get(0).getNombre(),
                        datosC.get(0).getRazonSocial(),
                        datosC.get(0).getLimiteCredito(), 
                        datosC.get(0).getDireccion(), 
                        datosC.get(0).getCodigoPostal(), 
                        datosC.get(0).getCodigoPostal(), 
                        datosC.get(0).getTelefono(), 
                        datosC.get(0).getEmail(), 
                        datosC.get(0).getTipo(), 
                        datosC.get(0).getIdCiudad(), 
                        datosC.get(0).getEstado());
                res=cldao.actualizar(cl);
                datosC = cldao.consultar();
                request.setAttribute("datosCl", datosC);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "ClientesD":
                res=cldao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosC = cldao.consultar();
                request.setAttribute("datosCl", datosC);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "ClientesS":
                datosC = cldao.filtrar(request.getParameter("campo"), request.getParameter("busqueda"));
                request.setAttribute("datosCl", datosC);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
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
