<%@page import="Modelo.datos.TransporteDAO" %>
<%@page import="java.util.*" %>
<%@page import="Modelo.Transporte" %>
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
     <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <a href="principal.jsp"><img src="Images/pla1.png" height="10%" width="10%" id="logo" alt="AgroItesz" /></a>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edición de Transportes</title>
</head>
<% TransporteDAO dao = new TransporteDAO();
    List<Transporte> datos = (List<Transporte>)request.getAttribute("datosCl");
%>
<body style="background-color: #dfd7f5;">
    <header>
        <nav id="N">
            <ul id="U">
                <li>
                    <a>Transportes</a>
                </li>
                <li>
                    <form action="Controlador?accion=TransportesS" method="POST" >
                        <input type="text" placeholder="búsqueda" name="busqueda"   > 
                        <input type="text" placeholder="en base a:" name="campo" > 
                        <button style="width: 20%; background-color: #15b332; color: #fff; font-weight: bold;"  type="submit">
                            <img src="Images/busqueda.jpg" alt="buscar" style="width: 10%; height: 10%;">
                            Buscar
                        </button>
                    </form>

                </li>
            </ul>
        </nav>
    </header>
    <button id="btnMostrar">+</button>
    <div style="margin-left: 180px; margin-top: 10px" id="divI">
        <form action="Controlador?accion=TransporteI" method="POST">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Placas" name="txtPlacas" style="width: 90%;"/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Marca" name="txtMarca" style="width: 90%;"/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Modelo" name="txtModelo" style="width: 90%;"/></td>
                    </tr>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="number" placeholder="Año" name="txtAño" style="width: 90%;"/></td>
                        <td style="width: 25%" colspan="2"><input type="numer" placeholder="Capacidad" name="txtCapacidad" style="width: 90%;"/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Estatus" name="txtEstatus" style="width: 90%;"/></td>
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
                    <th  width='1%' style='border: 0;' scope='col'>#transporte</th>
                    <th  width='1%' style='border: 0;' scope='col'>placas</th>
                    <th  width='1%' style='border: 0;' scope='col'>marca</th>
                    <th  width='1%' style='border: 0;' scope='col'>modelo</th>
                    <th  width='1%' style='border: 0;' scope='col'>Año</th>
                    <th  width='1%' style='border: 0;' scope='col'>Capacidad</th>
                    <th  width='1%' style='border: 0;' scope='col'>estatus</th>
                    <th  width='1%' style='border: 0;' scope='col'>Acciones</th> 
                </tr>
            </thead>
            <%
                int idc;
                //datos = dao.consultar();
                for (Transporte tr : datos) {
            %>
            <tbody>
                <tr>
                    <td><%=  idc = tr.getIdTransporte()%></td>
                    <td><%= tr.getPlacas()%></td>
                    <td><%= tr.getMarca()%></td>
                    <td><%= tr.getModelo()%></td>
                    <td><%= tr.getAño()%></td>
                    <td><%= tr.getCapacidad()%></td>
                    <%
                        if (tr.getEstado() == 'A') {
                    %>
                    <td>Activo</td> 
                    <%    } else {                    %>
                    <td>Inactivo</td>
                    <%    }%>                        </form>

                    <td> <form action="Controlador?accion=TransporteU&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc">Editar</button>
                        </form>
                        <form action="Controlador?accion=TransporteD&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc">Eliminar</button>
                        </form>
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
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#divI').hide();
        $('#btnMostrar').click(function (){
            if($('#btnMostrar').text()=='-'){
                $('#divI').hide();
                $('#btnMostrar').text('+');
            }else{
                $('#divI').show();
                $('#btnMostrar').text('-');
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