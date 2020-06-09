<%@page import="Modelo.datos.MiembrosDAO"%>
<%@page import="Modelo.Asociaciones"%>
<%@page import="Modelo.datos.AsociacionesDAO"%>
<%@page import="Modelo.Miembros"%>
<%@page import="Modelo.datos.ClientesDAO" %>
<%@page import="java.util.*" %>
<%@page import="Modelo.Clientes" %>
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
    <title>Edición de clientes</title>
</head>
<% 
    MiembrosDAO midao=MiembrosDAO.getMiembrosDAO();
    ClientesDAO cldao=ClientesDAO.getClientesDAO();
    AsociacionesDAO asdao=AsociacionesDAO.geAsociacionestDAO();
    List<Miembros> datos = (List<Miembros>) request.getAttribute("datosCl");
    List<Clientes> datosCl = cldao.consultar();
    List<Asociaciones> datosas = asdao.consultar();
%>
<body style="background-color: #dfd7f5;">
    <header>
        <nav id="N">
            <ul id="U">
                <li style="width: 50px;">
                    <a href="principal.jsp" style="width: 50px;"><img src="Images/arrow-left.png" height="70%" width="70%" alt="Regresar" /></a>
                    
                </li>
                <li>
                    <a>Miembros</a>
                </li>
                <li>
                    <form action="Controlador?accion=MiembrosS" method="POST" >
                        <input type="text" placeholder="búsqueda" name="busqueda" style="color: black;">
                        <label>En base a:</label>
                        <select name="campo" style="color: black;">
                            <option value="idCliente">#Miembro</option>
                            <option value="Asociacion">Asociacion</option>
                            <option value="estatus">Estatus</option>
                            <option value="fechaIncorporación">Fecha</option>
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
    <button id="btnMostrar"><span  class="glyphicon glyphicon-plus-sign"></span></button>
    <div style="margin-left: 180px; margin-top: 10px" id="divI">
        <form action="Controlador?accion=MiembrosI" method="POST" name="formInsertar" onsubmit="return Validar(formInsertar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2">
                            <label style="color: grey;font-weight: lighter;">Cliente:</label>
                            <select name="txtClientes">
                                <%
                                    for (Clientes cl : datosCl) {
                                        //String Ciudad = city.OneCity(cl.getIdCiudad());

                                %>
                                <option value="<%= cl.getIdCliente()%>"><%= cl.getNombre()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                        <td style="width: 25%" colspan="2">
                            <select name="txtAsociaciones">
                                <%
                                    for (Asociaciones as : datosas) {
                                        //String Ciudad = city.OneCity(cl.getIdCiudad());

                                %>
                                <option value="<%= as.getIdAsociacion()%>"><%= as.getNombre()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                        <td><label>Estatus</label>
                            <input type="radio" id="Activo" name="txtEstatus" value="A" required>
                            <label for="Activo">Activo</label>
                            <input type="radio" id="InActivo" name="txtEstatus" value="I" required>
                            <label for="Inactivo">Inactivo</label>
                        </td>
                        <td style="width: 25%" colspan="2"><input type="Date" placeholder="Fecha Incorporación" name="txtFecha" id="txtFecha" style="width: 90%;" value="" required/></td>
                    </tr>
                </tbody>
            </table>

            <button type="submit" style="width: 20%; background-color: #aa0bb0; color: #fff; font-weight: bold; border-radius: 0.33em;">
                Agregar
            </button>
        </form>
        </br>
    </div>


    <div style="margin-left: 180px; margin-top: 10px" id="divA">
        
        <form action="Controlador?accion=MiembrosA" method="POST" name="formActualizar" onsubmit="return ValidarA(formActualizar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td id="CD">

                        </td>
                        <td id="CD2">

                        </td>
                    </tr>
                     <tr>
                        <td style="width: 25%"><input type="Date" placeholder="Fecha" name="txtFecha" id="txtFechaA" style="width: 90%;" value="" required/></td>
                        <td style="width: 25%" colspan="2" id="CD"></td>
                        <td style="width: 25%" colspan="2" id="CD2"></td>
                        <td><label>Estatus</label>
                            <input type="radio" id="ActivoA" name="txtEstatus" value="A" required>
                            <label for="Activo">Activo</label>
                            <input type="radio" id="InactivoA" name="txtEstatus" value="I">
                            <label for="Inactivo">Inactivo</label>
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
        </br>
    </div>
    <div>
        <table width='100%' border='0' cellpadding='0' id='customers'>
            <thead>
                <tr>
                    <th  width='1%' style='border: 0;' scope='col'>#Miembro</th>
                    <th  width='1%' style='border: 0;' scope='col'>Cliente</th>
                    <th  width='10%' style='border: 0;' scope='col'>Asociacion</th>
                    <th  width='25%' style='border: 0;' scope='col'>Fecha Incorporacion</th>
                    <th  width='10%' style='border: 0;' scope='col'>Estatus</th>
                    <th  width='10%' style='border: 0;' scope='col'>Acciones</th> 
                </tr>
            </thead>
            <tbody>
                <%
                    int idm;
                    //datos = dao.consultar();
                    for (Miembros mi : datos) {
                %>
                <tr>
                    <td><%= idm = mi.getIdMiembro()%></td>
                <%
                    datosCl = cldao.consultarId(mi.getIdCliente());
                    String cli=datosCl.get(0).getNombre();
                %>
                <td><%= cli %></td>
                 <%
                    datos = midao.OneAsociation(mi.getIdAsosaciones());
                    String as=datosas.get(0).getNombre();
                %>
                <td><%= as %></td>
                <td><%=mi.getFechaIncorporacion()%></td>
                        <%
                            if (mi.getEstatus() == 'A') {
                        %>
                        <td>Activo</td> 
                        <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                            <form action="Controlador?accion=MiembrosD&id=<%= idm%>" method="POST">
                                <button type="submit" value='<%= idm%>' name="idc" class="boton2">
                                    <span  class='glyphicon glyphicon-ban-circle'></span></button>
                            </form></td>
                            <%    } else {%>
                        <td>Inactivo</td>
                        <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                            <form action="Controlador?accion=MiembrosR&id=<%= idm%>" method="POST">
                                <button type="submit" value='<%= idm%>' name="idc" class="boton2">
                                    <span  class='glyphicon glyphicon-ok-circle'></span></button>
                            </form></td>
                            <%    }%>                        
                    </tr>
                    <%
                        }
                    %>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>   
    <script type="text/javascript" charset="utf8" 
    src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>   
    <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>        
</body>
<script type="text/javascript">
            function addZero(i) {
                if (i < 10) {
                    i = '0' + i;
                }
                return i;
            }
        </script> 
        <script type="text/javascript">
        function dia() {
        var hoy = new Date();
        var dd = hoy.getDate();

        return dd;
    }
        </script> 
        <script type="text/javascript">
        function mes() {
        var hoy = new Date();
        var mm = hoy.getMonth() + 1;

        return mm;
    }
        </script> 
        <script type="text/javascript">
        function ano() {
        var hoy = new Date();
        var yyyy = hoy.getFullYear();

        return yyyy;
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
                $('#txtFecha').val(hoyFecha());
                $('#divI').hide();
                $('.boton').show();
                $('.boton2').show();
                $('#btnMostrarf').text('+');
                $('#btnMostrar').html("<span  class='glyphicon glyphicon-plus-sign'></span>");
            } else {
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
            $('#txtFechaA').val($(this).parents("tr").find("td")[3].innerHTML);
            var valor = $(this).parents("tr").find("td")[1].innerHTML;
                    $('#CD').html("<label style='color: grey;font-weight: lighter;'>Cliente:</label>" +
                            "<select name='txtCliente'>"+
                            
            <%
                String a;
                datosCl = cldao.consultar();
                for (Clientes tr : datosCl) {
                    a= tr.getIdCliente() +":"+ tr.getNombre();
            %>
                    "<option value='<%= tr.getIdCliente()%>' id='<%= a.replaceAll(" ", "") %>'><%= a%></option>" +
            <%
                }
            %>
                    "</select>"
                    );
            var valor = $(this).parents("tr").find("td")[2].innerHTML;
                    $('#CD2').html("<label style='color: grey;font-weight: lighter;'>Asosiacion:</label>" +
                            "<select name='txtAsociacion'>"+
                            
            <%
                datosas = asdao.consultar();
                for (Asociaciones as : datosas) {
                    a= as.getIdAsociacion() +":"+ as.getNombre();
            %>
                    "<option value='<%= as.getIdAsociacion()%>' id='<%= a.replaceAll(" ", "") %>'><%= a%></option>" +
            <%
                }
            %>
                    "</select>"
                    );
                    $('#' + valor.split(' ').join('')).attr('selected', 'selected').change();
            $('#' + valor).attr('selected', 'selected').change();
            if ($(this).parents("tr").find("td")[4].innerHTML === 'Activo') {
                $('#ActivoA').prop("checked", true);
            } else {
                $('#InactivoA').prop("checked", true);
            }
            $('#' + valor).attr('selected', 'selected').change();
                    var valor = $(this).parents("tr").find("td")[0].innerHTML;
                    $('#idCl').val(valor);
                    $('#idCl').hide();
            console.log($('#idCl').val());
            $('#nombre').focus();
        });
            $('#txtFecha').val(hoyFecha());
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
                    last: "Último"
                }
            }
        });
    });
</script>  
</html>