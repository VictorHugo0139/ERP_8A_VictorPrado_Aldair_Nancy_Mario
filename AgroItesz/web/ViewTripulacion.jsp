<%-- 
    Document   : ViewTripulacion
    Created on : 14/05/2020, 05:35:56 PM
    Author     : resid
--%>

    <%@page import="java.util.List"%>
        <%@page import="Modelo.datos.TripulacionDAO"%>
            <%@page import="Modelo.Tripulacion" %>
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
                        
                        #customers td,
                        #customers th {
                            border: 1px solid #ddd;
                            padding: 8px;
                        }
                        
                        #customers tr:nth-child(even) {
                            background-color: #f2f2f2;
                        }
                        
                        #customers tr:hover {
                            background-color: #ddd;
                        }
                        
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
                    <title>Edici�n de Tripulacion</title>
                </head>
                <% //CultivosDAO dao = new CultivosDAO();
    TripulacionDAO dao= new TripulacionDAO();
    List<Tripulacion> datos = (List<Tripulacion>) request.getAttribute("datosCl");
%>

                    <body style="background-color: #dfd7f5;">
                        <header>
                            <nav id="N">
                                <ul id="U">
                                    <li style="width: 50px;">
                                        <a href="principal.jsp" style="width: 50px;"><img src="Images/arrow-left.png" height="70%" width="70%" alt="Regresar" /></a>

                                    </li>
                                    <li>
                                        <a>Tripulaci�n</a>
                                    </li>
                                    <li>
                                        <form action="Controlador?accion=CultivosS" method="POST">
                                            <input type="text" placeholder="b�squeda" name="busqueda" style="color: black;">
                                            <label>En base a:</label>
                                            <select name="campo" style="color: black;">
                            <option value="idEmpleado">#Empleado</option>
                            <option value="idEnvio">#Envio</option>
                            <option value="rol">Rol</option>
                            <option value="Estatus">Estatus</option>
                        </select>
                                            <button style="width: 20%; background-color: #15b332; color: #fff; font-weight: bold;" type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                            Buscar
                        </button>
                                        </form>

                                    </li>
                                </ul>
                            </nav>
                        </header>
                        <!--Aqui se comienza a insertar -->
                        <button id="btnMostrarf">+</button>
                        <button id="btnMostrar"><span  class="glyphicon glyphicon-plus-sign"></span></button>
                        <div style="margin-left: 180px; margin-top: 10px" id="divI">
                            <form action="Controlador?accion=TripulacionI" method="POST" name="formInsertar" onsubmit="return Validar(formInsertar);">
                                <table border="0" style="width: 100%">
                                    <tbody>
                                        <tr>
                                            <td style="width: 25%" colspan="2"><input type="text" placeholder="idEmpleado" name="txtidEmpleado" style="width: 90%;" required/></td>
                                            <td style="width: 25%" colspan="2"><input type="text" placeholder="idEnvio" name="txtEnvio" style="width: 90%;" required /></td>
                                            <td style="width: 25%" colspan="2"><input type="text" placeholder="rol" name="txtRol" style="width: 90%;" required /></td>
                                        </tr>
                                        <td><label>Estatus</label>
                                            <input type="radio" id="Activo" name="txtEstatus" value="A" required>
                                            <label for="Activo">Activo</label>
                                            <input type="radio" id="Inactivo" name="txtEstatus" value="I">
                                            <label for="Inactivo">Inactivo</label>
                                        </td>
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

                            <form action="Controlador?accion=TrippulacionU" method="POST" name="formActualizar" onsubmit="return ValidarA(formActualizar);">
                                <table border="0" style="width: 100%">
                                    <tbody>
                                        <tr>
                                            <td style="width: 25%" colspan="2"><input type="text" placeholder="idEmpleado" name="txtidEmpleado" style="width: 90%;" required/></td>
                                            <td style="width: 25%" colspan="2"><input type="text" placeholder="idEnvio" name="txtEnvio" style="width: 90%;" required /></td>
                                            <td style="width: 25%" colspan="2"><input type="text" placeholder="rol" name="txtRol" style="width: 90%;" required /></td>
                                        </tr>
                                        <td id='CD'>

                                        </td>
                                        <td><label>Estatus:</label>
                                            <input type="radio" id="ActivoA" name="txtEstatusA" value="A" required>
                                            <label for="Activo">Activo</label>
                                            <input type="radio" id="InactivoA" name="txtEstatusA" value="I">
                                            <label for="Inactivo">Inactivo</label>
                                        </td>
                                        <td><input type="number" name="idCl" id="idCl" /> </td>
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
                                        <th id='tde' width='10%' style='border: 0;' scope='col'>idEmpleado</th>
                                        <th id='tde' width='30%' style='border: 0;' scope='col'>idEnvio</th>
                                        <th id='tde' width='20%' style='border: 0;' scope='col'>Rol</th>
                                        <th id='tde' width='10%' style='border: 0;' scope='col'>Estatus</th>
                                        <th width='10%' style='border: 0;' scope='col'>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                     int idTrip;
               //datos =  dao.consultar();
               for(Tripulacion tr : datos){
                %>
                                        <tr>
                                            <td>
                                                <%= idTrip = tr.getIdEmpleado()%>
                                            </td>
                                            <td>
                                                <%= tr.getIdEnvio()%>
                                            </td>
                                            <td>
                                                <%= tr.getRol()%>
                                            </td>
                                            <%
                        if (tr.getEstado() == 'A') {
                    %>
                                                <td>Activo</td>
                                                <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                                                    <form action="Controlador?accion=TripulacionD&id=<%= idTrip%>" method="POST">
                                                        <button type="submit" value='<%= idTrip%>' name="idc" class="boton2">
                                <span  class='glyphicon glyphicon-ban-circle'></span></button>
                                                    </form>
                                                </td>
                                                <%    } else {                    %>
                                                    <td>Inactivo</td>
                                                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                                                        <form action="Controlador?accion=TripulacionR&id=<%= idTrip%>" method="POST">
                                                            <button type="submit" value='<%= idTrip%>' name="idc" class="boton2">
                            <span  class='glyphicon glyphicon-ok-circle'></span></button>
                                                        </form>
                                                    </td>
                                                    <%    }%>


                                        </tr>
                                        <%
                    }
                %>
                                </tbody>
                            </table>
                        </div>
                        <script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
                        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
                        <!-- Latest compiled and minified CSS -->
                        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

                        <!-- Optional theme -->
                        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

                        <!-- Latest compiled and minified JavaScript -->
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

                        <script type="text/javascript">
                            $(document).ready(function() {
                                $('#divI').hide();
                                $('#divA').hide();
                                $('#btnMostrarf').hide();
                                $('#btnMostrar').click(function() {
                                    if ($('#btnMostrarf').text() === '-') {
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
                                $('.boton').click(function() {
                                    $('#btnMostrar').hide();
                                    $('.boton2').hide();
                                    $('#divI').hide();
                                    $('#divA').show();
                                    $('#txtNombre').val($(this).parents("tr").find("td")[1].innerHTML);
                                    $('#txtcostoAsesoria').val($(this).parents("tr").find("td")[2].innerHTML);
                                    var valor = $(this).parents("tr").find("td")[7].innerHTML;
                                    //console.log(valor);
                                    $('#' + valor).attr('selected', 'selected').change();

                                    if ($(this).parents("tr").find("td")[8].innerHTML === 'Activo') {
                                        $('#ActivoA').prop("checked", true);
                                    } else {
                                        $('#InactivoA').prop("checked", true);
                                    }
                                    console.log($(this).parents("tr").find("td")[0].innerHTML);
                                    valor = $(this).parents("tr").find("td")[0].innerHTML;
                                    console.log(valor);
                                    $('#nombre').focus();

                                });
                                $('#txtFechaI').val(hoyFecha());
                                $('#txtFechaF').val(hoyFecha());
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
                                            last: "�ltimo"
                                        }
                                    }
                                });
                            });
                        </script>

                    </body>

                </html>