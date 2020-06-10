
<%@page import="Modelo.datos.ClienteCultivoDAO"%>
<%@page import="Modelo.datos.CultivosDAO"%>
<%@page import="Modelo.datos.ClientesDAO"%>
<%@page import="Modelo.datos.CiudadesDAO"%>
<%@page import="java.util.*" %>
<%@page import="Modelo.Clientes" %>
<%@page import="Modelo.Ciudades" %>
<%@page import="Modelo.Cultivos" %>
<%@page import="Modelo.ClienteCultivo" %>

<html>

   
    <head>
        <style>
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
    <title>Edición de Cultivos</title>
</head>
<% 
    ClientesDAO cl=ClientesDAO.getClientesDAO();
    CiudadesDAO city = CiudadesDAO.getCiudadesDAO();
    ClienteCultivoDAO CC= ClienteCultivoDAO.getClienteCultivoDAO();
    CultivosDAO Cu = CultivosDAO.getCultivosDAO();
    List<ClienteCultivo> datos = CC.consultar();
    List<Clientes> datosCl = cl.consultar();
    List<Ciudades> datosCiu = city.consultar();
    List<Cultivos> datosCu = Cu.consultar();
%>
<body style="background-color: #dfd7f5;">
    <header>
        <nav id="N">
            <ul id="U">
                <li style="width: 50px;">
                    <a href="principal.jsp" style="width: 50px;"><img src="Images/arrow-left.png" height="70%" width="70%" alt="Regresar" /></a>
                    
                </li>
                <li>
                    <a>Cultivos</a>
                </li>
                <li>
                    <form action="Controlador?accion=CultivosS" method="POST" >
                        <input type="text" placeholder="búsqueda" name="busqueda" style="color: black;">
                        <label>En base a:</label>
                        <select name="campo" style="color: black;">
                            <option value="idClienteCultivo">#ClienteCultivo</option>
                            <option value="extension">Extension</option>
                            <option value="Ubicacion">Ubicacion</option>
                            <option value="idCliente">#Cliente</option>
                            <option value="idCultivo">#Cultivo</option>
                            <option value="idCiudad">#Ciudad</option>
                            <option value="Estatus">Estatus</option>
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
   <!--Aqui se comienza a insertar --> 
    <button id="btnMostrarf">+</button>
    <button id="btnMostrar"><span  class="glyphicon glyphicon-plus-sign"></span></button>
    <div style="margin-left: 180px; margin-top: 10px" id="divI">
        <form action="Controlador?accion=ClienteCultivoI" method="POST" name="formInsertar" onsubmit="return Validar(formInsertar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="number" placeholder="Extension" name="txtExtension" style="width: 90%;" required/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Ubicacion" name="txtUbicacion" style="width: 90%;" required /></td>
                    </tr>
                    <tr>
                        <td>
                                <label style="color: grey;font-weight: lighter;">Cliente:</label>
                                <select name="txtCliente">
                                    <%
                                        for (Clientes cli : datosCl) {
                                    %>
                                    <option value="<%= cli.getIdCliente()%>"><%= cli.getNombre()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                            <td>
                                <label style="color: grey;font-weight: lighter;">Cultivo:</label>
                                <select name="txtCultivo">
                                    <%
                                        for (Cultivos cu : datosCu) {
                                    %>
                                    <option value="<%= cu.getIdCultivo()%>"><%= cu.getIdCultivo()+" "+ cu.getNombre()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                            <td >
                                <label style="color: grey;font-weight: lighter;">Ciudad:</label>
                                <select name="txtCiudad">
                                    <%
                                        for (Ciudades ci : datosCiu) {
                                            //String Ciudad = city.OneCity(cl.getIdCiudad());

                                    %>
                                    <option value="<%= ci.getIdCiudad()%>"><%= ci.getNombre()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
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
        
        <form action="Controlador?accion=CultivosU" method="POST" name="formActualizar" onsubmit="return ValidarA(formActualizar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtNombre" id='nombre'  style="width: 90%;" required/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="costoAsesoria" name="txtcostoAsesoria" id='costoAsesoria'  style="width: 90%;" required /></td>
                    </tr>
                    <tr>   
                        <td><label>Estatus:</label>
                            <input type="radio" id="ActivoA" name="txtEstatusA" value="A" required>
                            <label for="Activo">Activo</label>
                            <input type="radio" id="InactivoA" name="txtEstatusA" value="I">
                            <label for="Inactivo">Inactivo</label>
                        </td>
                        <td><input type="number" name="idTr" id="idTr"/> </td>
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
                     <th id='tde' width='10%' style='border: 0;' scope='col'>idCultivo</th>
                     <th id='tde' width='30%' style='border: 0;' scope='col'>Nombre</th>
                     <th id='tde' width='20%' style='border: 0;' scope='col'>costoAseesoria</th>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>Estatus</th>
                     <th  width='10%' style='border: 0;' scope='col'>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                     int idCul;
               //datos =  dao.consultar();
               for(Cultivos cl : datos){
                %>
                <tr>
                    <td><%= idCul = cl.getIdCultivo()%></td>
                    <td><%= cl.getNombre()%></td>
                    <td><%= cl.getCostoAsesoria()%></td>
                    <%
                        if (cl.getEstado() == 'A') {
                    %>
                    <td>Activo</td> 
                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                        <form action="Controlador?accion=CultivosD&id=<%= idCul%>" method="POST">
                            <button type="submit" value='<%= idCul%>' name="idc" class="boton2">
                                <span  class='glyphicon glyphicon-ban-circle'></span></button>
                        </form></td>
                    <%    } else {                    %>
                    <td>Inactivo</td>
                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                        <form action="Controlador?accion=CultivosR&id=<%= idCul%>" method="POST">
                            <button type="submit" value='<%= idCul%>' name="idc" class="boton2">
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
                $('#divI').show();
                $('.boton').hide();
                $('.boton2').hide();
                $('#btnMostrarf').text('-');
                $('#btnMostrar').html("<span  class='glyphicon glyphicon-minus-sign'></span>");
            }
        });
        $('.boton').click(function () {
            $('#btnMostrar').hide();
            $('.boton2').hide();
            $('#divI').hide();
            $('#divA').show();
            $('#nombre').val($(this).parents("tr").find("td")[1].innerHTML);
            $('#costoAsesoria').val($(this).parents("tr").find("td")[2].innerHTML);
            if ($(this).parents("tr").find("td")[3].innerHTML === 'Activo') {
                $('#ActivoA').prop("checked", true);
            } else {
                $('#InactivoA').prop("checked", true);
            }
            console.log($(this).parents("tr").find("td")[0].innerHTML);
            valor=$(this).parents("tr").find("td")[0].innerHTML;
            console.log(valor);
            $('#idTr').val(valor);
            $('#idTr').hide();
            console.log($('#idTr').val());
            $('#nombre').focus();
        });
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
    
</body>
</html>