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
        </style>
    <img src="Images/pla1.png" height="10%" width="10%" id="logo" alt="AgroItesz" />
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
    <div style="margin-left: 180px; margin-top: 10px">
        <form action="Controlador?accion=TransporteI" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td><input type="text" placeholder="Placas" name="txtPlacas"/></td>
                        <td><input type="text" placeholder="Marca" name="txtMarca"/></td>
                        <td><input type="text" placeholder="Modelo" name="txtModelo"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="Año" name="txtAño"/></td>
                        <td><input type="text" placeholder="Capacidad" name="txtCapacidad"/></td>
                        <td><input type="text" placeholder="Teléfono" name="txtTelefono"/></td>
                        <td><input type="text" placeholder="Estatus" name="txtEstatus"/></td>
                    </tr>
                </tbody>
            </table>

            <button type="submit" style="width: 20%; background-color: #aa0bb0; color: #fff; font-weight: bold; border-radius: 0.33em;">
                Agregar
            </button>
        </form>

    </div>
    <div style="margin-left: 180px; margin-top: 5px; border: 1px solid #aa0bb0; height: 420px; width: 1002px;">
        <table border="1" >
            <thead>
                <tr>
                    <th>#transporte</th>
                    <th>placas</th>
                    <th>marca</th>
                    <th>modelo</th>
                    <th>Año</th>
                    <th>Capacidad</th>
                    <th>estatus</th>
                    <th>Acciones</th> 
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
</body>

</html>