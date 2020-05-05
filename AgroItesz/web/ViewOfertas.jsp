<%@page import="Modelo.datos.ProductosDAO"%>
<%@page import="Modelo.datos.OfertasDAO" %>
<%@page import="java.util.*" %>
<%@page import="Modelo.Ofertas" %>
<%@page import="Modelo.Productos" %>
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
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <a href="principal.jsp"><img src="Images/pla1.png" height="10%" width="10%" id="logo" alt="AgroItesz" /></a>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edici�n de Ofertas</title>
</head>
<%  ProductosDAO product = ProductosDAO.getProducosDAO();
    List<Ofertas> datos = (List<Ofertas>) request.getAttribute("datosCl");
    List<Ofertas> datosF = (List<Ofertas>) request.getAttribute("datosCl");
%>

<body style="background-color: #dfd7f5;">
    <header>
        <nav id="N">
            <ul id="U">
                <li style="width: 50px;">
                    <a href="principal.jsp" style="width: 50px;"><img src="Images/arrow-left.png" height="70%" width="70%" alt="Regresar" /></a>

                </li>
                <li>
                    <a>Ofertas</a>
                </li>
                <li>
                    <form action="Controlador?accion=OfertasS" method="POST">
                        <input type="text" placeholder="b�squeda" name="busqueda">
                        <input type="text" placeholder="en base a:" name="campo">
                        <button style="width: 20%; background-color: #15b332; color: #fff; font-weight: bold;" type="submit">
                            <img src="Images/busqueda.jpg" alt="buscar" style="width: 10%; height: 10%;">
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
                                <form action="Controlador?accion=OfertasI" method="POST">
                                    <table border="0" style="width: 100%">
                                        <tbody>
                                            <tr>
                                                <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtNombre" style="width: 90%;" /></td>
                                                <td style="width: 25%" colspan="2"><input type="text" placeholder="Descripci�n" name="txtDes" style="width: 90%;" /></td>
                                                <td style="width: 25%" colspan="2"><input type="nombre" placeholder="%Descuento" name="txtModelo" style="width: 90%;" /></td>
                                            </tr>
                                            <tr>
                                                <td style="width: 25%" colspan="2"><input type="date" placeholder="Fecha Inicial" name="txtA�o" style="width: 90%;" /></td>
                                                <td style="width: 25%" colspan="2"><input type="date" placeholder="Fecha Final" name="txtCapacidad" style="width: 90%;" /></td>
                                                <td style="width: 25%" colspan="2"><input type="number" placeholder="Cantidad Minima del Producto" name="txtEstatus" style="width: 90%;" /></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label style="color: grey;font-weight: lighter;">Producto:</label>
                                                    <select name="txtProducto">
                </li>
            </ul>
        </nav>
    </header>
    <button id="btnMostrarf">+</button>
    <button id="btnMostrar"><span  class="glyphicon glyphicon-plus-sign"></span></button>
    <div style="margin-left: 180px; margin-top: 10px" id="divI">
        <form action="Controlador?accion=OfertasI" method="POST">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtPlacas" style="width: 90%;" /></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Descripci�n" name="txtMarca" style="width: 90%;" /></td>
                        <td style="width: 25%" colspan="2"><input type="nombre" placeholder="%Descuento" name="txtModelo" style="width: 90%;" /></td>
                    </tr>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="date" placeholder="Fecha Inicial" name="txtA�o" style="width: 90%;" /></td>
                        <td style="width: 25%" colspan="2"><input type="date" placeholder="Fecha Final" name="txtCapacidad" style="width: 90%;" /></td>
                        <td style="width: 25%" colspan="2"><input type="number" placeholder="Cantidad Minima del Producto" name="txtEstatus" style="width: 90%;" /></td>
                    </tr>
                    <tr>
                        <td>
                            <label style="color: grey;font-weight: lighter;">Producto:</label>
                            <select name="txtProducto">
                                <%
                                    for (Ofertas of : datosF) {
                                        String Producto = product.OneProduct(of.getIdProducto());
                                %>
                                <option value="<%=Producto%>"><%=of.getDescripcion()%></option>
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

    </div>

    <div style="margin-left: 180px; margin-top: 10px" id="divA">
        <form action="Controlador?accion=OfertasA" method="POST">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtPlacas" id="nombre" style="width: 90%;" /></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Descripci�n" name="txtMarca" id="descripcion" style="width: 90%;" /></td>
                        <td style="width: 25%" colspan="2"><input type="nombre" placeholder="%Descuento" name="txtModelo" id="descuento" style="width: 90%;" /></td>
                    </tr>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="date" placeholder="Fecha Inicial" name="txtA�o" id="fechaI" style="width: 90%;" /></td>
                        <td style="width: 25%" colspan="2"><input type="date" placeholder="Fecha Final" name="txtCapacidad" id="fechaF" style="width: 90%;" /></td>
                        <td style="width: 25%" colspan="2"><input type="number" placeholder="Cantidad Minima del Producto" id="cantidad" name="txtEstatus" style="width: 90%;" /></td>
                    </tr>
                    <tr>
                        <td id="CD">
                            
                        </td>
                        <td><label>Estatus</label>
                            <input type="radio" id="ActivoA" name="txtEstatus" value="A" required>
                            <label for="Activo">Activo</label>
                            <input type="radio" id="InactivoA" name="txtEstatus" value="I">
                            <label for="Inactivo">Inactivo</label>
                        </td>
                        <td><input type="number" name="idCl" id="idCl"/> </td>
                    </tr>
                </tbody>
            </table>

            <button type="submit" style="width: 20%; background-color: #aa0bb0; color: #fff; font-weight: bold; border-radius: 0.33em;">
                Agregar
            </button>
        </form>

    </div>

    <div>
        <table width='100%' border='0' cellpadding='0' id='customers'>
            <thead>
                <tr>
                    <th width='1%' style='border: 0;' scope='col'>#oferta</th>
                    <th width='1%' style='border: 0;' scope='col'>Nombre</th>
                    <th width='1%' style='border: 0;' scope='col'>Descripcion</th>
                    <th width='1%' style='border: 0;' scope='col'>%Descuento</th>
                    <th width='1%' style='border: 0;' scope='col'>Fecha de Inicio</th>
                    <th width='1%' style='border: 0;' scope='col'>Fecha de Fin</th>
                    <th width='1%' style='border: 0;' scope='col'>Cantidad Minima del Producto</th>
                    <th width='1%' style='border: 0;' scope='col'>Producto</th>
                    <th width='1%' style='border: 0;' scope='col'>Estatus</th>
                    <th width='1%' style='border: 0;' scope='col'>Acciones</th>

                </tr>
            </thead>
            <tbody>
                <%
                    int idc;
                    //datos = dao.consultar();
                    for (Ofertas ofe : datos) {
                %>
                <tr>
                    <td>
                        <%=  idc = ofe.getIdOfertas()%>
                    </td>
                    <td>
                        <%= ofe.getNombre()%>
                    </td>
                    <td>
                        <%= ofe.getDescripcion()%>
                    </td>
                    <td>
                        <%= ofe.getPorDescuento()%>
                    </td>
                    <td>
                        <%= ofe.getFechaInicio()%>
                    </td>
                    <td>
                        <%= ofe.getFechaFin()%>
                    </td>
                    <td>
                        <%= ofe.getCanMinProducto()%>
                    </td>

                    <%
                        String Producto = product.OneProduct(ofe.getIdProducto());
                    %>
                    <td>
                        <%=Producto%>
                    </td>
                    </form>
                    <%
                        if (ofe.getEstatus() == 'A') {
                    %>
                    <td>Activo</td>
                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                        <form action="Controlador?accion=ClientesD&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc" class="boton2">
                                <span  class='glyphicon glyphicon-ban-circle'></span></button>
                        </form>
                    </td>
                    <%    } else {%>
                    <td>Inactivo</td>
                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                        <form action="Controlador?accion=ClientesR&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc" class="boton2">
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
</body>
<script type="text/javascript">
    $(document).ready(function () {
        console.log();
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
            $('#descripcion').val($(this).parents("tr").find("td")[2].innerHTML);
            $('#descuento').val($(this).parents("tr").find("td")[3].innerHTML);
            var today = $(this).parents("tr").find("td")[4].innerHTML.toString().format('YYYY-MM-DD');
            $('#fechaI').val(today);
            $('#fechaF').val($(this).parents("tr").find("td")[5].innerHTML);
            $('#cantidad').val($(this).parents("tr").find("td")[6].innerHTML);
            var valor = $(this).parents("tr").find("td")[7].innerHTML;
            console.log(valor);
            $('#CD').html("<label style='color: grey;font-weight: lighter;'>Producto:</label>" +
                    "<select name='txtProducto'>" +
    <%
                                    for (Ofertas of : datosF) {
                                        String Producto = product.OneProduct(of.getIdProducto());
    %>
            "<option value='<%=of.getDescripcion()%>'><%=Producto%></option>" +
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
            valor=$(this).parents("tr").find("td")[0].innerHTML;
            console.log(valor);
            $('#idCl').val(valor);
            $('#idCl').hide();
            console.log($('#idCl').val());
            $('#nombre').focus();
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
                    last: "�ltimo"
                }
            }
        });
    });
</script>

</html>