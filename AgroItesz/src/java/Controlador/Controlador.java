package Controlador;

import Conexion.Conexion;
import Modelo.Clientes;
import Modelo.Cultivos;
import Modelo.Usuarios;
import Modelo.Transporte;
import Modelo.Ofertas;
import Modelo.Asociaciones;
import Modelo.Miembros;
import Modelo.Ventas;
import Modelo.Presentacion;
import Modelo.datos.PresentacionDAO;
import Modelo.Envios;
import Modelo.Ventas;
import Modelo.VentasDetalles;
import Modelo.Tripulacion;
import Modelo.Mantenimientos;
import Modelo.Visitas;
import Modelo.datos.ClientesDAO;
import Modelo.datos.CultivosDAO;
import Modelo.datos.TransporteDAO;
import Modelo.datos.UsuariosDAO;
import Modelo.datos.OfertasDAO;
import Modelo.datos.AsociacionesDAO;
import Modelo.datos.MiembrosDAO;
import Modelo.datos.VentasDAO;
import Modelo.datos.EnviosDAO;
import Modelo.datos.VisitasDAO;
import Modelo.datos.VentasDetallesDAO;
import Modelo.datos.TripulacionDAO;
import Modelo.datos.MantenimientosDAO;
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
    int j;
    String subtotal,pres,cant,precio;
    ArrayList<String> valor =new ArrayList<>();
    ArrayList<String> valorpres =new ArrayList<>();
    ArrayList<String> valorcant =new ArrayList<>();
    ArrayList<String> valorprecio =new ArrayList<>();
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    UsuariosDAO usrDao = UsuariosDAO.getUsuariosDAO();
    Usuarios usr = new Usuarios();
    ClientesDAO cldao = ClientesDAO.getClientesDAO();
    VentasDAO Vdao = VentasDAO.getVentasDAO();
    VentasDetallesDAO VDdao = VentasDetallesDAO.getVentasDetallesDAO();
    Presentacion p = new Presentacion();
    PresentacionDAO pRdao = new PresentacionDAO();
    MiembrosDAO midao = MiembrosDAO.getMiembrosDAO();
    CultivosDAO culdao = new CultivosDAO();
    Clientes cl = new Clientes();
    Ventas v=new Ventas();
    VentasDetalles vD=new VentasDetalles();
    Miembros mi = new Miembros();
    Cultivos cul = new Cultivos();
    List<Clientes> datosC = new ArrayList<>();
    List<Presentacion> datosPr = new ArrayList<>();
    List<Ventas> datosV = new ArrayList<>();
    List<VentasDetalles> datosVD = new ArrayList<>();
    List<Miembros> datosM = new ArrayList<>();
    List<Cultivos> datosCu = new ArrayList<>();
    TransporteDAO trdao = TransporteDAO.getTransporteDAO();
    Transporte tr = new Transporte();
    List<Transporte> datosT = new ArrayList<>();
    OfertasDAO ofdao = OfertasDAO.getOfertasDAO();
    Ofertas of = new Ofertas();
    List<Ofertas> datosO = new ArrayList<>();
    AsociacionesDAO Asdao = AsociacionesDAO.geAsociacionestDAO();
    Asociaciones As = new Asociaciones();
    List<Asociaciones> datosA = new ArrayList<>();
    EnviosDAO endao = EnviosDAO.getEnviosDAO();
    Envios en = new Envios();
    List<Envios> datosE = new ArrayList<>();
    TripulacionDAO tripdao = TripulacionDAO.getTripulacionDAO();
    Tripulacion trip = new Tripulacion();
    List<Tripulacion> datosTrip = new ArrayList<>();
    MantenimientosDAO mandao = MantenimientosDAO.getMantenimientosDAO();
    VisitasDAO visdao = VisitasDAO.getVisitasDAO();
    Mantenimientos mant = new Mantenimientos();
    Visitas vis = new Visitas();
    List<Mantenimientos> datosMant = new ArrayList<>();
    List<Visitas> datosVis = new ArrayList<>();
    
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
            case "Ventas":
                datosV = Vdao.consultar();
                datosVD = VDdao.consultar();
                request.setAttribute("rev", 0);
                request.setAttribute("datosClU", datosVD);
                request.setAttribute("datosCl", datosV);
                request.getRequestDispatcher("ViewVentas.jsp").forward(request, response);
                break;
            case "VentasDetalles":
                datosVD = VDdao.consultar();
                request.setAttribute("datosCl", datosVD);
                request.getRequestDispatcher("ViewVentasDetalles.jsp").forward(request, response);
                break;
            case "Transportes":
                datosT = trdao.consultar();
                request.setAttribute("datosCl", datosT);
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "Socios":
                datosA = Asdao.consultar();
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
                case "AsociacionesI":
                As = new Asociaciones(0,
                        request.getParameter("txtNombre"),
                        request.getParameter("txtEstatus").charAt(0));
                res = Asdao.insertar(As);
                datosA =  Asdao.consultar();
                request.setAttribute("datosCl", datosA);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewSocios.jsp").forward(request, response);
                break;

            case "AsociacionesU":
                As = new Asociaciones(Integer.parseInt(request.getParameter("idCl")),
                        request.getParameter("txtNombre"),
                        request.getParameter("txtEstatus").charAt(0));
                res = Asdao.actualizar(As);
                datosA = Asdao.consultar();
                request.setAttribute("datosCl", datosA);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewSocios.jsp").forward(request, response);
                break;
                
                
                
            case "AsociacionesD":
                res = Asdao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosA = Asdao.consultar();
                request.setAttribute("datosCl", datosA);
                request.getRequestDispatcher("ViewSocios.jsp").forward(request, response);
                break;
            case "AsociacionesR":
                res = Asdao.reactivar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosA = Asdao.consultar();
                request.setAttribute("datosCl", datosA);
                request.getRequestDispatcher("ViewSocios.jsp").forward(request, response);
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
                res = trdao.actualizar(tr);
                datosT = trdao.consultar();
                request.setAttribute("datosCl", datosT);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewTransportes.jsp").forward(request, response);
                break;
            case "OfertasI":
                of = new Ofertas(Integer.parseInt(request.getParameter("idCl")),
                        request.getParameter("txtNombre"),
                        request.getParameter("txtDescripcion"),
                        Integer.parseInt(request.getParameter("txtPorDescuento")),
                        Date.valueOf(request.getParameter("txtFechaInicio")),
                        Date.valueOf(request.getParameter("txtFechaFin")),
                        Integer.parseInt(request.getParameter("txtCantMinProducto")),
                        request.getParameter("txtEstatus").charAt(0),
                        Integer.parseInt(request.getParameter("txtProducto")));
                res = ofdao.insertar(of);
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
            case "OfertasU":
                of = new Ofertas(Integer.parseInt(request.getParameter("idCl")),
                        request.getParameter("txtNombre"),
                        request.getParameter("txtDescripcion"),
                        Integer.parseInt(request.getParameter("txtPorDescuento")),
                        Date.valueOf(request.getParameter("txtFechaInicio")),
                        Date.valueOf(request.getParameter("txtFechaFin")),
                        Integer.parseInt(request.getParameter("txtCantMinProducto")),
                        request.getParameter("txtEstatus").charAt(0),
                        Integer.parseInt(request.getParameter("txtProducto")));
                res = ofdao.actualizar(of);
                datosO = ofdao.consultar();
                request.setAttribute("datosCl", datosO);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewOfertas.jsp").forward(request, response);
                break;
            case "MiembrosI":
                mi = new Miembros(0,
                        Integer.parseInt(request.getParameter("txtClientes")),
                        Integer.parseInt(request.getParameter("txtAsociaciones")),
                        request.getParameter("txtEstatus").charAt(0),
                        Date.valueOf(request.getParameter("txtFecha")));
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
            case "MiembrosU":
                mi = new Miembros(Integer.parseInt(request.getParameter("idCl")),
                        Integer.parseInt(request.getParameter("txtCliente")),
                        Integer.parseInt(request.getParameter("txtAsociacion")),
                        request.getParameter("txtEstatus").charAt(0),
                        Date.valueOf(request.getParameter("txtFechaA")));
                res = midao.actualizar(mi);
                datosM = midao.consultar();
                request.setAttribute("datosCl", datosM);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewMiembros.jsp").forward(request, response);
                break;
            case "CultivosI":
                cul = new Cultivos(0,
                        request.getParameter("txtNombre"),
                        Float.parseFloat(request.getParameter("txtcostoAsesoria")),
                        request.getParameter("txtEstatus").charAt(0));
                res = culdao.insertar(cul);
                datosCu = culdao.consultar();
                request.setAttribute("datosCl", datosCu);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewCultivos.jsp").forward(request, response);
                break;
            case "CultivosD":
                res = culdao.eliminar(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("resp", res);
                datosCu = culdao.consultar();
                request.setAttribute("datosCl", datosCu);
                request.getRequestDispatcher("ViewCultivos.jsp").forward(request, response);
                break;
            case "CultivosR":
                res = culdao.reactivar(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("resp", res);
                datosCu = culdao.consultar();
                request.setAttribute("datosCl", datosCu);
                request.getRequestDispatcher("ViewCultivos.jsp").forward(request, response);
                break;
            case "CultivosU":
                cul = new Cultivos(Integer.parseInt(request.getParameter("idTr")),
                        request.getParameter("txtNombre"),
                        Float.parseFloat(request.getParameter("txtcostoAsesoria")),
                        request.getParameter("txtEstatusA").charAt(0));
                res = culdao.actualizar(cul);
                datosCu = culdao.consultar();
                request.setAttribute("datosCl", datosCu);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewCultivos.jsp").forward(request, response);
                break;
            case "CultivosS":
                datosCu = culdao.filtrar(request.getParameter("campo"), request.getParameter("busqueda"));
                request.setAttribute("datosCl", datosCu);
                request.getRequestDispatcher("ViewCultivos.jsp").forward(request, response);
                break;
            case "Envios":
                datosE = endao.consultar();
                request.setAttribute("datosCl", datosE);
                request.getRequestDispatcher("ViewEnvios.jsp").forward(request, response);
                break;  
             case "VentasI":
                 valor.clear();
                 valorpres.clear();
                 valorcant.clear();
                 valorprecio.clear();
                 v=new Ventas(0,
                         new Date(20200608),
                         Float.parseFloat(request.getParameter("totalE")),
                         Float.parseFloat(request.getParameter("recibido")),
                         request.getParameter("coment"), 
                         'P', 
                         request.getParameter("pago").charAt(0), 
                         Integer.parseInt(request.getParameter("client")), 
                         Integer.parseInt(request.getParameter("suc")), 
                         Integer.parseInt(request.getParameter("empl")));
                 res=Vdao.insertar(v);
                 
                 
//                 System.out.println("Prueba- Cliente: "+request.getParameter("client")+"\n"
//                         + "Cant Recibida: "+request.getParameter("recibido")+"\n"
//                         + "Total a pagar: "+request.getParameter("totalE")+"\n"
//                         + "Modo de pago: "+request.getParameter("pago")+"\n"
//                         + "Comentario: "+request.getParameter("coment")+"\n");
                 int j=0;
                 subtotal=request.getParameter("valores");
                 pres=request.getParameter("pres");
                 cant=request.getParameter("cant");
                 precio=request.getParameter("precio");
//                 System.out.println("array: "+ subtotal);
//                 System.out.println("Length: "+subtotal.length());
                 for (int i = 0; i < subtotal.length(); i++) {
//                     System.out.println("array: "+ subtotal);
//                     System.out.println("J: "+j);
//                     System.out.println("Index: "+subtotal.indexOf("/"));
                     valor.add(j, subtotal.substring(0,subtotal.indexOf("/")));
                     valorpres.add(j, pres.substring(0,pres.indexOf("/")));
                     valorcant.add(j, cant.substring(0,cant.indexOf("/")));
                     valorprecio.add(j, precio.substring(0,precio.indexOf("/")));
                     subtotal=subtotal.substring(subtotal.indexOf("/")+1);
                     pres=pres.substring(pres.indexOf("/")+1);
                     cant=cant.substring(cant.indexOf("/")+1);
                     precio=precio.substring(precio.indexOf("/")+1);
                     j++;
                     i=-1;
                 }
                 for (int i = 0; i < valor.size(); i++) {
//                     System.out.println("Subtotal"+i+": "+valor.get(i)+"\n"
//                             + "Presentacion"+i+": "+valorpres.get(i)+"\n"
//                                     + "Cantidad"+i+": "+valorcant.get(i)+"\n"
//                                             + "Precio"+i+": "+valorprecio.get(i));
                     vD=new VentasDetalles(0,
                         Float.parseFloat(valorprecio.get(i)),
                         Float.parseFloat(valorcant.get(i)),
                         Float.parseFloat(valor.get(i)),
                         Vdao.maxid(),
                         Integer.parseInt(valorpres.get(i)),
                         'A');
                     res=VDdao.insertar(vD);
                 }
                 datosV = Vdao.consultar();
                request.setAttribute("datosCl", datosV);  
                request.getRequestDispatcher("ViewVentas.jsp").forward(request, response);
                break;
            case "VentasU":
                v = new Ventas(Integer.parseInt(request.getParameter("idCl")),
                        Date.valueOf(request.getParameter("txtFecha")),
                        Float.parseFloat(request.getParameter("txtTotalPagar")),
                        Float.parseFloat(request.getParameter("txtCantPagada")),
                        request.getParameter("txtComentarios"),
                        request.getParameter("txtEstatus").charAt(0),
                        request.getParameter("txtTipo").charAt(0),
                        Integer.parseInt(request.getParameter("txtCliente")),
                        Integer.parseInt(request.getParameter("txtSucursal")),
                        Integer.parseInt(request.getParameter("txtEmpleado")));
                res = Vdao.actualizar(v);
                datosV = Vdao.consultar();
                request.setAttribute("datosCl", datosV);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewVentas.jsp").forward(request, response);
                break;
            case "VentasD":
                res = Vdao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosV = Vdao.consultar();
                request.setAttribute("datosCl", datosV);
                request.getRequestDispatcher("ViewVentas.jsp").forward(request, response);
                break;
            case "VentasR":
                res = Vdao.reactivar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosV = Vdao.consultar();
                request.setAttribute("datosCl", datosV);
                request.getRequestDispatcher("ViewVentas.jsp").forward(request, response);
                break;
            case "EnviosI":
                en = new Envios(0,
                        Date.valueOf(request.getParameter("txtFechaEntregaP")),
                        Date.valueOf(request.getParameter("txtFechaEntregaR")),
                        request.getParameter("txtDireccion"),
                        Integer.parseInt(request.getParameter("txtCP")),
                        Integer.parseInt(request.getParameter("txtVenta")),
                        Integer.parseInt(request.getParameter("txtTransporte")),
                        Integer.parseInt(request.getParameter("txtCiudad")),
                        request.getParameter("txtEstatus").charAt(0));
                res = endao.insertar(en);
                datosE = endao.consultar();
                request.setAttribute("datosCl", datosE);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewEnvios.jsp").forward(request, response);
                break;
                
            case "VentasDetallesI":
                
                vD = new VentasDetalles(0,
                        Float.parseFloat(request.getParameter("estas")),
                        Float.parseFloat(request.getParameter("cantidad")),
                        Float.parseFloat(request.getParameter("Subtotal")),
                        Integer.parseInt(request.getParameter("pro")),
                        Integer.parseInt(request.getParameter("txtPresentacion")),
                        'A');
                res = VDdao.insertar(vD);
                datosV = Vdao.consultar();
                datosVD = VDdao.consultar();
                request.setAttribute("datosClU", datosVD);
                request.setAttribute("datosCl", datosVD);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewVentasAdd.jsp").forward(request, response);
                break;
                
            case "VentasDetallesU":
                vD = new VentasDetalles(Integer.parseInt(request.getParameter("idCl")),
                        Float.parseFloat(request.getParameter("txtprecioVenta")),
                        Float.parseFloat(request.getParameter("txtcantidad")),
                        Float.parseFloat(request.getParameter("txtsubtotal")),
                        Integer.parseInt(request.getParameter("txtVentas")),
                        Integer.parseInt(request.getParameter("txtPresentacion")),
                         request.getParameter("txtEstatus").charAt(0));
                res = VDdao.actualizar(vD);
                datosVD = VDdao.consultar();
                request.setAttribute("datosCl", datosVD);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewVentasDetalles.jsp").forward(request, response);
                break;
            case "VentasDetallesD":
                res = VDdao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosVD = VDdao.consultar();
                request.setAttribute("datosCl", datosVD);
                request.getRequestDispatcher("ViewVentasDetalles.jsp").forward(request, response);
                break;
            case "VentasDetallesR":
                res = VDdao.reactivar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosVD = VDdao.consultar();
                request.setAttribute("datosCl", datosVD);
                request.getRequestDispatcher("ViewVentasDetalles.jsp").forward(request, response);
                break;
                case "VentasDetallesS":
                
                        
                datosVD = VDdao.filtrar(request.getParameter("campo"), request.getParameter("busqueda"));
                request.setAttribute("datosCl", datosVD);
                request.getRequestDispatcher("ViewVentasDetalles").forward(request, response);
                break;
                
                case "EnviosU":
                en = new Envios(Integer.parseInt(request.getParameter("idCl")),
                        Date.valueOf(request.getParameter("txtFechaEntregaP")),
                        Date.valueOf(request.getParameter("txtFechaEntregaR")),
                        request.getParameter("txtDireccion"),
                        Integer.parseInt(request.getParameter("txtCP")),
                        Integer.parseInt(request.getParameter("txtVenta")),
                        Integer.parseInt(request.getParameter("txtTransporte")),
                        Integer.parseInt(request.getParameter("txtCiudad")),
                        request.getParameter("txtEstatus").charAt(0));
                res = endao.actualizar(en);
                datosE = endao.consultar();
                request.setAttribute("datosCl", datosE);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewEnvios.jsp").forward(request, response);
                break;
                case "EnviosD":
                res = endao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosE = endao.consultar();
                request.setAttribute("datosCl", datosE);
                request.getRequestDispatcher("ViewEnvios.jsp").forward(request, response);
                break;
                case "EnviosR":
                res = endao.reactivar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosE = endao.consultar();
                request.setAttribute("datosCl", datosE);
                request.getRequestDispatcher("ViewEnvios.jsp").forward(request, response);
                break;
            case "Tripulacion":
                datosTrip = tripdao.consultar();
                request.setAttribute("datosCl", datosTrip);
                request.getRequestDispatcher("ViewTripulacion.jsp").forward(request, response);  
            break;
            case "TripulacionI":
                trip = new Tripulacion(
                Integer.parseInt(request.getParameter("txtidEmpleado")),
                Integer.parseInt(request.getParameter("txtEnvio")),
                request.getParameter("txtRol"),
                request.getParameter("txtEstatus").charAt(0),
                0);
                res = tripdao.insertar(trip);
                datosTrip = tripdao.consultar();
                request.setAttribute("datosCl", datosTrip);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewTripulacion.jsp").forward(request, response);
            break;
            case "TripulacionU":
                trip = new Tripulacion(
                Integer.parseInt(request.getParameter("txtidEmpleado")),
                Integer.parseInt(request.getParameter("txtEnvio")),
                request.getParameter("txtRol"),
                request.getParameter("txtEstatus").charAt(0),
                Integer.parseInt(request.getParameter("idTrip")));
                res = tripdao.actualizar(trip);
                datosTrip = tripdao.consultar();
                request.setAttribute("datosCl", datosTrip);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewTripulacion.jsp").forward(request, response);
            break;
            case "TripulacionD":
                res = tripdao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosTrip = tripdao.consultar();
                request.setAttribute("datosCl", datosTrip);
                request.getRequestDispatcher("ViewTripulacion.jsp").forward(request, response);
            break;
            case "TripulacionR":
                res = tripdao.reactivar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosTrip = tripdao.consultar();
                request.setAttribute("datosCl", datosTrip);
                request.getRequestDispatcher("ViewTripulacion.jsp").forward(request, response);
            break;
            case "Mantenimientos":
                datosMant = mandao.consultar();
                request.setAttribute("datosCl", datosMant);
                request.getRequestDispatcher("ViewMantenimientos.jsp").forward(request, response);  
            break;
            case "MantenimientosI":
                mant = new Mantenimientos(0,
                        Date.valueOf(request.getParameter("txtFecha")),
                        request.getParameter("txtTaller"),
                        Integer.parseInt(request.getParameter("txtCosto")),
                        request.getParameter("txtComentario"),
                        request.getParameter("txtTipo"),
                        Integer.parseInt(request.getParameter("txtTransporte")),
                        request.getParameter("txtEstatus").charAt(0));
                res = mandao.insertar(mant);
                datosMant = mandao.consultar();
                request.setAttribute("datosCl", datosMant);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewMantenimientos.jsp").forward(request, response);
                break;
                case "MantenimientosD":
                res = mandao.eliminar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosMant = mandao.consultar();
                request.setAttribute("datosCl", datosMant);
                request.getRequestDispatcher("ViewMantenimientos.jsp").forward(request, response);
                break;
                case "MantenimientosR":
                res = mandao.reactivar(Integer.parseInt(request.getParameter("idc")));
                request.setAttribute("resp", res);
                datosMant = mandao.consultar();
                request.setAttribute("datosCl", datosMant);
                request.getRequestDispatcher("ViewMantenimientos.jsp").forward(request, response);
                break;
                case "MantenimientosU":
                mant = new Mantenimientos(Integer.parseInt(request.getParameter("idCl")),
                        Date.valueOf(request.getParameter("txtFecha")),
                        request.getParameter("txtTaller"),
                        Float.parseFloat(request.getParameter("txtCosto")),
                        request.getParameter("txtComentario"),
                        request.getParameter("txtTipo"),
                        Integer.parseInt(request.getParameter("txtTransporte")),
                        request.getParameter("txtEstatus").charAt(0));
                res = mandao.actualizar(mant);
                datosMant = mandao.consultar();
                request.setAttribute("datosCl", datosMant);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewMantenimientos.jsp").forward(request, response);
                break;
                case "Visitas":
                datosVis = visdao.consultar();
                request.setAttribute("datosCl", datosVis);
                request.getRequestDispatcher("ViewVisitas.jsp").forward(request, response);
               
                    break;
                case "VisitasI":
                vis = new Visitas(0,
                        Date.valueOf(request.getParameter("txtFechaEntregaP")),
                        Date.valueOf(request.getParameter("txtFechaEntregaR")),
                        request.getParameter("txtComentarios"),
                        request.getParameter("txtEstatus").charAt(0),
                        Float.parseFloat(request.getParameter("txtCosto")),
                        Integer.parseInt(request.getParameter("txtClienteCultivo")),
                        Integer.parseInt(request.getParameter("txtEmpleado")),
                        Integer.parseInt(request.getParameter("txtTransporte")));
                res = visdao.insertar(vis);
                datosVis = visdao.consultar();
                request.setAttribute("datosCl", datosVis);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewVisitas.jsp").forward(request, response);
                break;
                case "VisitasD":
                res = visdao.eliminar(Integer.parseInt(request.getParameter("ido")));
                request.setAttribute("resp", res);
                datosVis = visdao.consultar();
                request.setAttribute("datosCl", datosVis);
                request.getRequestDispatcher("ViewVisitas.jsp").forward(request, response);
                break;
                case "VisitasR":
                res = visdao.reactivar(Integer.parseInt(request.getParameter("ido")));
                request.setAttribute("resp", res);
                datosVis = visdao.consultar();
                request.setAttribute("datosCl", datosVis);
                request.getRequestDispatcher("ViewVisitas.jsp").forward(request, response);
                break;
                case "VisitasU":
                vis = new Visitas(Integer.parseInt(request.getParameter("idCl")),
                        Date.valueOf(request.getParameter("txtFechaEntregaP")),
                        Date.valueOf(request.getParameter("txtFechaEntregaR")),
                        request.getParameter("txtComentarios"),
                        request.getParameter("txtEstatus").charAt(0),
                        Float.parseFloat(request.getParameter("txtCosto")),
                        Integer.parseInt(request.getParameter("txtClienteCultivo")),
                        Integer.parseInt(request.getParameter("txtCiudad")),
                        Integer.parseInt(request.getParameter("txtTransporte")));
                res = visdao.actualizar(vis);
                datosVis = visdao.consultar();
                request.setAttribute("datosCl", datosVis);
                request.setAttribute("resp", res);
                request.getRequestDispatcher("ViewVisitas.jsp").forward(request, response);
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
