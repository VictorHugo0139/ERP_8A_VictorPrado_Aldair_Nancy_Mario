package Controlador;

import Conexion.Conexion;
import Modelo.Clientes;
import Modelo.Cultivos;
import Modelo.Usuarios;
import Modelo.Transporte;
import Modelo.Ofertas;
import Modelo.Asociaciones;
import Modelo.Miembros;
import Modelo.datos.ClientesDAO;
import Modelo.datos.CultivosDAO;
import Modelo.datos.TransporteDAO;
import Modelo.datos.UsuariosDAO;
import Modelo.datos.OfertasDAO;
import Modelo.datos.AsociacionesDAO;
import Modelo.datos.MiembrosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

//    Conexion cn = new Conexion();
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    UsuariosDAO usrDao = UsuariosDAO.getUsuariosDAO();
    Usuarios usr = new Usuarios();
    ClientesDAO cldao = ClientesDAO.getClientesDAO();
    MiembrosDAO midao = MiembrosDAO.getMiembrosDAO();
    CultivosDAO culdao = new CultivosDAO();
    Clientes cl = new Clientes();
    Miembros mi = new Miembros();
    Cultivos cul = new Cultivos();
    List<Clientes> datosC = new ArrayList<>();
    List<Miembros> datosM = new ArrayList<>();
    List<Cultivos> datosCu = new ArrayList<>();
    TransporteDAO trdao = TransporteDAO.getTransporteDAO();
    Transporte tr = new Transporte();
    List<Transporte> datosT = new ArrayList<>();
    OfertasDAO ofdao = OfertasDAO.getOfertasDAO();
    Ofertas of = new Ofertas();
    List<Ofertas> datosO = new ArrayList<>();
    AsociacionesDAO asdao = AsociacionesDAO.geAsociacionestDAO();
    Asociaciones as = new Asociaciones();
    List<Asociaciones> datosA = new ArrayList<>();
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
            case "Cambio":
                cn.closeConnection();//Cierro sesión del Usuario actual y abro la del siguiente.
            /*No puse break;
                porque quiero que llegue hasta el break de Ingresar*/
            case "Ingresar":
                String nom = request.getParameter("Usuario");
                String contra = request.getParameter("Password");
                usr.setNombre(nom);
                usr.setContrasenia(contra);
                r = usrDao.validar(usr);
                if (r == 1) {
                    cn.setUserName(nom);
                    cn.setPassword(contra);
                    con = cn.getConexion();
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
                datosCu = culdao.consultar();
                request.setAttribute("datosCl", datosCu);
                request.getRequestDispatcher("ViewCultivos.jsp").forward(request, response);
                break;
            case "Clientes":
                datosC = cldao.consultar();
                request.setAttribute("datosCl", datosC);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "Transportes":
                datosT = trdao.consultar();
                request.setAttribute("datosCl", datosT);
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "Socios":
                datosA = asdao.consultar();
                request.setAttribute("datosCl", datosA);
                request.getRequestDispatcher("ViewSocios.jsp").forward(request, response);
                break;
            case "Ofertas":
                datosO = ofdao.consultar();
                request.setAttribute("datosCl", datosO);
                request.getRequestDispatcher("ViewOfertas.jsp").forward(request, response);
                break;
            case "OfertasAsosacion":
                request.getRequestDispatcher("ViewOfertasAsosacion.jsp").forward(request, response);
                break;
            case "Miembros":
                datosM = midao.consultar();
                request.setAttribute("datosCl", datosM);
                request.getRequestDispatcher("ViewMiembros.jsp").forward(request, response);
                break;
            case "ClientesI":
                cl = new Clientes(0,
                        request.getParameter("txtNombre") + " " + request.getParameter("txtApellido"),
                        request.getParameter("txtRazonSocial"),
                        Float.parseFloat(request.getParameter("txtLimiteCredito")),
                        request.getParameter("txtCalle") + " No. " + request.getParameter("txtNumero"),
                        request.getParameter("txtCodigoPostal"),
                        request.getParameter("txtRFC"),
                        request.getParameter("txtTelefono"),
                        request.getParameter("txtEmail"),
                        request.getParameter("txtTipo").charAt(0),
                        Integer.parseInt(request.getParameter("txtCiudad")),
                        request.getParameter("txtEstatus").charAt(0));
                res = cldao.insertar(cl);
                datosC = cldao.consultar();
                request.setAttribute("datosCl", datosC);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "ClientesU":
                cl = new Clientes(Integer.parseInt(request.getParameter("idCl")),
                        request.getParameter("txtNombre"),
                        request.getParameter("txtRazonSocial"),
                        Float.parseFloat(request.getParameter("txtLimiteCredito")),
                        request.getParameter("txtUbicacion"),
                        request.getParameter("txtCodigoPostal"),
                        request.getParameter("txtRFC"),
                        request.getParameter("txtTelefono"),
                        request.getParameter("txtEmail"),
                        request.getParameter("txtTipoA").charAt(0),
                        Integer.parseInt(request.getParameter("txtCiudad")),
                        request.getParameter("txtEstatusA").charAt(0));
                res = cldao.actualizar(cl);
                datosC = cldao.consultar();
                request.setAttribute("datosCl", datosC);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "ClientesD":
                res = cldao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosC = cldao.consultar();
                request.setAttribute("datosCl", datosC);
                request.getRequestDispatcher("ViewClientes.jsp").forward(request, response);
                break;
            case "ClientesR":
                res = cldao.reactivar(Integer.parseInt(request.getParameter("idc")));
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
            case "TransporteD":
                res = trdao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosT = trdao.consultar();
                request.setAttribute("datosCl", datosT);
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "TransporteR":
                res = trdao.reactivar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosT = trdao.consultar();
                request.setAttribute("datosCl", datosT);
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "TransporteI":
                tr = new Transporte(0,
                        request.getParameter("txtPlacas"),
                        request.getParameter("txtMarca"),
                        request.getParameter("txtModelo"),
                        Integer.parseInt(request.getParameter("txtAño")),
                        Integer.parseInt(request.getParameter("txtCapacidad")),
                        request.getParameter("txtEstatus").charAt(0));
                res = trdao.insertar(tr);
                datosT = trdao.consultar();
                request.setAttribute("datosCl", datosT);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "TransporteU":
                tr = new Transporte(Integer.parseInt(request.getParameter("idTr")),
                        request.getParameter("txtPlacas"),
                        request.getParameter("txtMarca"),
                        request.getParameter("txtModelo"),
                        Integer.parseInt(request.getParameter("txtAño")),
                        Integer.parseInt(request.getParameter("txtCapacidad")),
                        request.getParameter("txtEstatus").charAt(0));
                res = trdao.actualizar(cl);
                datosT = trdao.consultar();
                request.setAttribute("datosCl", datosT);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "OfertasI":
                of = new Ofertas(0,
                        request.getParameter("txtNombre"),
                        request.getParameter("txtDescripcion"),
                        Integer.parseInt(request.getParameter("txtPorDescuento")),
                        Date.valueOf("txtFechaInicio"),
                        Date.valueOf("txtFechaFin"),
                        Integer.parseInt("txtCantMinProducto"),
                        request.getParameter("txtEstatus").charAt(0),
                        Integer.parseInt(request.getParameter("txtProducto")));
                res = ofdao.insertar(cl);
                datosO = ofdao.consultar();
                request.setAttribute("datosCl", datosO);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewOfertas.jsp").forward(request, response);
                break;
            case "OfertasD":
                res = ofdao.eliminar(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("resp", res);
                datosO = ofdao.consultar();
                request.setAttribute("datosCl", datosO);
                request.getRequestDispatcher("ViewOfertas.jsp").forward(request, response);
                break;
                case "OfertasR":
                res = ofdao.reactivar(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("resp", res);
                datosO = ofdao.consultar();
                request.setAttribute("datosCl", datosO);
                request.getRequestDispatcher("ViewOfertas.jsp").forward(request, response);
                break;
            case "MiembrosI":
                mi = new Miembros(Integer.parseInt(request.getParameter("txtClientes")),
                        Integer.parseInt(request.getParameter("txtAsociaciones")),
                        request.getParameter("txtEstatus").charAt(0),
                        Date.valueOf(LocalDate.MIN));
                res = midao.insertar(mi);
                datosM = midao.consultar();
                request.setAttribute("datosCl", datosM);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewMiembros.jsp").forward(request, response);
                break;
            case "MiembrosD":
                res = midao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosM = midao.consultar();
                request.setAttribute("datosCl", datosM);
                request.getRequestDispatcher("ViewMiembros.jsp").forward(request, response);
                break;
            case "MiembrosR":
                res = midao.reactivar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosM = midao.consultar();
                request.setAttribute("datosCl", datosM);
                request.getRequestDispatcher("ViewMiembros.jsp").forward(request, response);
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
