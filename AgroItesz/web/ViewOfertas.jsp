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
    <title>Edicion de Ofertas</title>
</head>
<%  ProductosDAO product = ProductosDAO.getProducosDAO();
    List<Ofertas> datos = (List<Ofertas>) request.getAttribute("datosCl");
    List<Productos> datosPr = product.consultar();
%>

<body style="background-color: #dfd7f5;">
    <header>
        <nav id="N">
            <ul id="U">
                <li style="width: 50px;">
                    <a href="principal.jsp" style="width: 50px;"><img src="Images/arrow-left.png" height="70%" width="70%" alt="Regresar" /></a>
                    
                </li>
                <li>
                    <a>Clientes</a>
                </li>
                <li>
                    <form action="Controlador?accion=OfertasS" method="POST" >
                        <input type="text" placeholder="búsqueda" name="busqueda" style="color: black;">
                        <label>En base a:</label>
                        <select name="campo" style="color: black;">
                            <option value="idCliente">#Oferta</option>
                            <option value="nombre">Nombre</option>
                            <option value="razonSocial">Razón Social</option>
                            <option value="limiteCredito">Limite Crédito</option>
                            <option value="direccion">Dirección</option>
                            <option value="codigoPostal">Código Postal</option>
                            <option value="rfc">RFC</option>
                            <option value="telefono">Teléfono</option>
                            <option value="email">Email</option>
                            <option value="tipo">Genero</option>
                            <option value="Ciudad">Ciudad</option>
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
    <button id="btnMostrar"><span  class="glyphicon glyphicon-plus-sign"></span></button>
    <div style="margin-left: 180px; margin-top: 10px" id="divI">
        <form action="Controlador?accion=OfertasI" method="POST" name="formInsertar">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtNombre" style="width: 90%;" required/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Descripcion" name="txtDescripcion" style="width: 90%;" required /></td>
                        <td style="width: 25%"><input type="number" placeholder="%Descuento" name="txtPorDescuento" style="width: 90%;" required/></td>
                        <td style="width: 25%"><input type="Date" placeholder="Fecha de inicio" name="txtFechaInicio" style="width: 90%;" step="0.01" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="Date" placeholder="Fecha de Fin" name="txtFechaFin" style="width: 90%;" required/></td>
                        <td><input type="number" placeholder="Cantidad minima del Producto" name="txtCantMinProducto" style="width: 90%;"/></td>
                    </tr>
                    <tr>
                        <td >
                            <label style="color: grey;font-weight: lighter;">Productos:</label>
                            <select name="txtProducto">
                                <%
                                    for (Productos pr : datosPr) {
                                        //String Ciudad = city.OneCity(cl.getIdCiudad());
System.out.println(pr.getIdProducto());
System.out.println(", "+pr.getNombre());
                                %>
                                <option value="<%= pr.getIdProducto()%>"><%= pr.getNombre()%></option>
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
    <div>
        <table width='100%' border='0' cellpadding='0' id='customers'>
            <thead>
                <tr>
                    <th  width='1%' style='border: 0;' scope='col'>#Oferta</th>
                    <th  width='10%' style='border: 0;' scope='col'>Nombre</th>
                    <th  width='25%' style='border: 0;' scope='col'>Descripcion</th>
                    <th  width='10%' style='border: 0;' scope='col'>% de Descuento</th>
                    <th  width='10%' style='border: 0;' scope='col'>Fecha de inicio</th>
                    <th  width='10%' style='border: 0;' scope='col'>Fecha de Fin</th>
                    <th  width='10%' style='border: 0;' scope='col'>Cantidad minima del producto</th>
                    <th  width='10%' style='border: 0;' scope='col'>Producto</th>
                    <th  width='10%' style='border: 0;' scope='col'>Estatus</th>
                    <th  width='10%' style='border: 0;' scope='col'>Acciones</th> 
                </tr>
            </thead>
            <tbody>
                <%
                    int ido;
                    //datos = dao.consultar();
                    for (Ofertas of : datos) {
                %>
                <tr>
                    <td><%= ido = of.getIdOfertas()%></td>
                    <td><%= of.getNombre()%></td>
                    <td><%= of.getDescripcion()%></td>
                    <td><%= of.getPorDescuento()%></td>
                    <td><%= of.getFechaInicio()%></td>
                    <td><%= of.getFechaFin()%></td>
                    <td><%= of.getCanMinProducto()%></td>
                    <%
                        String Producto = product.OneProduct(of.getIdProducto());
                    %>
                    <td><%=Producto%></td>
                    <%
                        if (of.getEstatus() == 'A') {
                    %>
                    <td>Activo</td> 
                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                        <form action="Controlador?accion=ClientesD&id=<%= ido%>" method="POST">
                            <button type="submit" value='<%= ido%>' name="idc" class="boton2">
                                <span  class='glyphicon glyphicon-ban-circle'></span></button>
                        </form></td>
                    <%    } else {                    %>
                    <td>Inactivo</td>
                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                        <form action="Controlador?accion=ClientesR&id=<%= ido%>" method="POST">
                            <button type="submit" value='<%= ido%>' name="idc" class="boton2">
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