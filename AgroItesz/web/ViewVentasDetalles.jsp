
<%@page import="Modelo.datos.PresentacionDAO"%>
<%@page import="Modelo.Presentacion"%>
<%@page import="Modelo.VentasDetalles"%>
<%@page import="Modelo.datos.VentasDetallesDAO"%>
<%@page import="Modelo.datos.VentasDAO"%>
<%@page import="Modelo.Ventas"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>

    <head>
        <style>
            /*estilo nav general*/
            #N {
                background-color: #1b0c45;
                margin-left: 13.5%;
                margin-right: 11%;
            }
            #U {
                list-style-type: none;
                padding: 0;
                overflow: hidden;
                background-color: #1b0c45;

            }
            #U li {
                display: inline;
            }
            #U li a {
                font-family: Arial;
                font-size: 21px;
                text-decoration: none;
                float: left;
                padding: 10px;
                background-color: #1b0c45;
                color: #fff;
                margin: 0;     
            }
            #U .seccion a:hover{
                background-color: #15b332;
            }
            #U li form {
                width: 443px;
                margin: 0;
                font-family: Arial;
                font-size: 11px;
                text-decoration: none;
                float: right;
                padding: 10px;
                background-color: #1b0c45;
                color: #fff;
            }
            #customers {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr:nth-child(even){background-color: #f2f2f2;}

            #customers tr:hover {background-color: #ddd;}

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #1b0c45;
                color: white;
            }
        </style>
        <link rel="icon" type="image/x-icon" href="Images/favicon.ico">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <a href="principal.jsp"><img src="Images/pla1.png" height="10%" width="10%" id="logo" alt="AgroItesz" /></a>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>VentasDetalle</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>   
    <script type="text/javascript" charset="utf8" 
    src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>   
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    <script type="text/javascript">
  window.addEventListener("load", function() {
        
  formActualizar.txtprecioVenta.addEventListener("keypress", soloNumerosPunto, false);
});

//Solo permite introducir numeros.
function soloNumerosPunto(e){
    alert("ddssd");
    /*   var ren = /^([0-9.]*)$/;
    if (!ren.exec(user)) {
        alert("Solo se permiten números y punto decimal");
        return false;
    }*/
  var key = window.event ? e.which : e.keyCode;
  if (key < 48 || key > 57) {
    e.preventDefault();
  }
}
    
</script>
</head>
<%
    VentasDAO Vdao = VentasDAO.getVentasDAO();
    VentasDetallesDAO VDdao = VentasDetallesDAO.getVentasDetallesDAO();
    PresentacionDAO pRdao = PresentacionDAO.getPresentacionDAO();
    List<VentasDetalles> datos = (List<VentasDetalles>) request.getAttribute("datosCl");
    List<Ventas> v = Vdao.consultar();
    List<VentasDetalles> lv = VDdao.consultar();
    List<Presentacion> p = pRdao.consultar();
%>
<body style="background-color: #dfd7f5;">
    <header>
        <nav id="N">
            <ul id="U">
                <li style="width: 50px;">
                    <a href="principal.jsp" style="width: 50px;"><img src="Images/arrow-left.png" height="70%" width="70%" alt="Regresar" /></a>
                </li>
                <li class="seccion">
                    <a href="Controlador?accion=Ventas">Ventas</a>
                </li>
                <li class="seccion">
                    <a href="Controlador?accion=VentasDetalles">Detalle de ventas</a>
                </li>
                <li>
                    <form action="Controlador?accion=VentasDetallesS" method="POST" >
                        <input type="text" placeholder="búsqueda" name="busqueda" style="color: black;">
                        <label>En base a:</label>
                        <select name="campo" style="color: black;">
                            <option value="idVentaDetalle">Venta Detalle</option>
                            <option value="precioVenta">precio Venta</option>
                            <option value="cantidad">cantidad</option>
                            <option value="subtotal">subtotal</option>
                            <option value="idVenta">venta</option>
                            <option value="idPresentacion">Presentacion</option>
                            <option value="estatus">Estatus</option>
                        </select>
                        <button style="width: 20%; background-color: #15b332; color: #fff; font-weight: bold;"  type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                            Buscar
                        </button>
                    </form> 
                </li>
            </ul>
        </nav>
    </header>
    <button id="btnMostrarf">+</button>
    <button id="btnMostrar">
        <span  class="glyphicon glyphicon-plus-sign"></span>
    </button>
    <div style="margin-left: 180px; margin-top: 10px" id="divI">
        <form action="Controlador?accion=VentasDetallesI" method="POST" name="formInsertar" onsubmit="return ValidarDetalles(formInsertar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%"><input type="text" placeholder="precio de venta"  id="txtPrecioVenta" name="txtPrecioVenta" style="width: 90%;" required maxlength="10"/></td>
                        <td style="width: 25%"><input type="text" placeholder="Cantidad" id="txtCantidad" name="txtCantidad" style="width: 90%;" required maxlength="10" /></td>
                        <td style="width: 25%"><input type="text" placeholder="subtotal" id="txtSubtotal" name="txtSubtotal" style="width: 90%;" required maxlength="10"/></td>
                    </tr>
                    <td>
                        <input type="radio" id="Activo" name="txtEstatus" value="A" required>
                        <label for="Activo">Activo</label>
                        <input type="radio" id="Inactivo" name="txtEstatus" value="I">
                        <label for="Inactivo">Inactivo</label>
                    </td>
                    <tr>
                    <td colspan="3"></td>
                    <td colspan="2">
                        <label style="color: grey;font-weight: lighter;">ventas</label>
                        <select name="txtVentas">
                            <% 
                                for (Ventas ve : v) {
                            %>
                            <option value="<%= ve.getIdVenta()%>"><%= ve.getIdVenta()%></option>
                            <%
                                }
                            %>
                        </select>

                        <label style="color: grey;font-weight: lighter;">Presentacion</label>
                        <select name="txtPresentacion">
                            <%
                                for (Presentacion pr : p) {

                            %>
                            <option value="<%= pr.getIdPresentacion()%>"><%= pr.getIdPresentacion()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                </tbody>
            </table>
            <button type="submit" style="width: 20%; background-color: #aa0bb0; color: #fff; font-weight: bold; border-radius: 0.33em;">
                Agregar
            </button>
        </form>
    </div>
    <div style="margin-left: 180px; margin-top: 10px" id="divA">
        <form action="Controlador?accion=VentasDeetallesU" method="POST" name="formActualizar" onsubmit="return ValidarA(formActualizar);">
                <table border="0" style="width: 100%">
                    <tbody>
                        <tr>
                            <td style="width: 25%"><input type="number" name="txtprecioVenta" id="precioVenta" style="width: 90%;" required/></td>
                            <td style="width: 25%"><input type="number" placeholder="cantidad" name="txtcantidad" id="cantidad" step="0.01" style="width: 90%;" required /></td>
                            <td style="width: 25%"><input type="number" placeholder="suntotal" name="txtsubtotal" id="suntotal" style="width: 90%;" step="0.01" required/></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="radio" id="ActivoA" name="txtEstatus" value="A" required>
                                <label for="Activo">Activo</label>
                                <input type="radio" id="InactivoA" name="txtEstatus" value="I">
                                <label for="Inactivo">Inactivo</label>
                            </td>
                            <td id="CD">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <input type="number" name="idCl" id="idCl"/>
                            </td>
                            <td id="CD2" colspan="2">
                            </td>
                        </tr>
                    </tbody>
                </table>
                    <button type="submit" style="width: 20%; background-color: #aa0bb0; color: #fff; font-weight: bold; border-radius: 0.33em;">
                        Actualizar
                    </button>
                    <button type="button" id="Cancel" style="width: 20%; background-color: #fc1919; color: #fff; font-weight: bold; border-radius: 0.33em;">
                        Cancelar
                    </button>
        </form>
        <br/>
    </div>
    <div id="Contenedor">
            <table width='100%' border='0' cellpadding='0' id='customers'>
                <thead>
                    <tr>
                        <th  width='1%' style='border: 0;' scope='col'>#VentaDetalle</th>
                        <th  width='10%' style='border: 0;' scope='col'>pecioVenta</th>
                        <th  width='10%' style='border: 0;' scope='col'>cantidad</th>
                        <th  width='10%' style='border: 0;' scope='col'>subtotal</th>
                        <th  width='25%' style='border: 0;' scope='col'>Estatus</th>
                        <th  width='10%' style='border: 0;' scope='col'>Venta</th>
                        <th  width='10%' style='border: 0;' scope='col'>Presentacion</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int idc;
                        //datos = dao.consultar();
                        for (VentasDetalles vD : datos) {
                    %>
                    <tr>
                        <td><%= idc = vD.getIdVentaDetalle()%></td>
                        <td><%= vD.getPrecioVenta()%></td>
                        <td><%= vD.getCantidad()%></td>
                        <td><%= vD.getSubtotal()%></td>                      
                        <%if (vD.getEstatus() == 'A') { %>
                        <td>Activo</td>
                        <% } else if (vD.getEstatus() == 'I') { 
                        %>
                        <td>Inactivo</td>
                        <% }
                            //v = Vdao.consultarId(vD.getIdVenta());
                            ///lv = VDdao.consultarId(vD.getIdVenta());
                            p = pRdao.consultarId(vD.getIdPresentacion());
                       //lv.get(0).getIdVenta()
                        %>
                        <td><%= vD.getIdVenta()%></td>
                        <td><%= p.get(0).getIdPresentacion()%></td>
                    </tr>
                    <%
                        }//fin for
                    %>
                </tbody>
            </table>
        </div>       
</body>


<script type="text/javascript">
    
    /* function ValidarDetalles(formulario)
    {
         if (formulario.txtPrecioVenta.value === "" )
        {
        alert("Todos los campos son obligatorios.");
        return false;
        }
    }*/
    function addZero(i) {
        if (i < 10) {
            i = '0' + i;
        }
        return i;
    }
</script> 
<script type="text/javascript">
    function hoyFecha() {
        var hoy = new Date();
        var dd = hoy.getDate();
        var mm = hoy.getMonth() + 1;
        var yyyy = hoy.getFullYear();

        dd = addZero(dd);
        mm = addZero(mm);

        return yyyy + '-' + mm + '-' + dd;
    }
</script> 

<script type="text/javascript">
    $(document).ready(function () {
        $('#divI').hide();
        $('#divA').hide();
        $('#btnMostrarf').hide();
        $('#btnMostrar').click(function () {
            if ($('#btnMostrarf').text() === '-') {
                $('#divI').hide();
                $('.boton').show();
                $('.boton2').show();
                $('#btnMostrarf').text('+');
                $('#btnMostrar').html("<span  class='glyphicon glyphicon-plus-sign'></span>");
            } else {
                $('#txtF').val(hoyFecha());
                $('#divI').show();
                $('.boton').hide();
                $('.boton2').hide();
                $('#btnMostrarf').text('-');
                $('#btnMostrar').html("<span  class='glyphicon glyphicon-minus-sign'></span>");
            }
        });
        $('.boton').click(function () {

            //valores obtendra el dato del td por posciones [0]
            $('#btnMostrar').hide();
            $('.boton2').hide();
            $('#divI').hide();
            $('#divA').show();
            $('#precioVenta').val($(this).parents("tr").find("td")[1].innerHTML);
            $('#CantPagada').val($(this).parents("tr").find("td")[2].innerHTML);
            $('#subtotal').val($(this).parents("tr").find("td")[3].innerHTML);
            if ($(this).parents("tr").find("td")[4].innerHTML === 'Activo') {
                $('#ActivoA').prop("checked", true);
            } else {
                $('#InactivoA').prop("checked", true);
            }

            var valor = $(this).parents("tr").find("td")[5].innerHTML;
            //console.log(valor);
            $('#CD2').html("<label style='color: grey;font-weight: lighter;'>Ventas</label>" +
                    "<select name='txtVentas'>" +
    <%                        for (Ventas ve : v) {
            //String Ciudad = city.OneCity(cl.getIdCiudad());

    %>
            "<option value='<%= ve.getIdVenta()%>'><%= ve.getIdVenta()%></option>" +
    <%
        }
    %>
            "</select>");
            $('#CD2').append("<label style='color: grey;font-weight: lighter;'>Presentacion</label>" +
                    "<select name='txtPresentacion'>" +
    <%
        for (Presentacion pr : p) {
            //String Ciudad = city.OneCity(cl.getIdCiudad());

    %>
            "<option value='<%= pr.getIdPresentacion()%>'><%= pr.getIdPresentacion()%></option>" +
    <%
        }
    %>
            "</select>");
            $('#' + valor).attr('selected', 'selected').change();

            if ($(this).parents("tr").find("td")[8].innerHTML === 'Activo') {
                $('#ActivoA').prop("checked", true);
            } else {
                $('#InactivoA').prop("checked", true);
            }
            $('#nombre').focus();

            $('#' + valor).attr('selected', 'selected').change();
            var valor = $(this).parents("tr").find("td")[0].innerHTML;
            $('#idCl').val(valor);
            $('#idCl').hide();
            //console.log($('#idCl').val());
            $('#nombre').focus();
        });
        $('#txtFechaEntregaP').val(hoyFecha());
        $('#txtFechaEntregaR').val(hoyFecha());
        $('#Cancel').click(function () {
            $('#divA').hide();
            $('#divI').hide();
            $('.boton2').show();
            $('#btnMostrar').show();
        });
        $('#customers').DataTable({
            language: {
                processing: "Procesando...",
                search: "Buscar:",
                lengthMenu: "Mostrar _MENU_ elementos",
                info: "Mostrando _START_ a _END_ de _TOTAL_ elementos",
                infoEmpty: "No se encontraron elementos para mostrar",
                infoFiltered: "(Filtrado de _MAX_ elementos en total)",
                loadingRecords: "Cargando datos...",
                zeroRecords: "No se encontraron elementos para mostrar",
                paginate: {
                    first: "Primer",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "ultimo"
                }
            }
        });
    });
</script>  
</html>
