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
        </style>
    <img src="Images/pla1.png" height="10%" width="10%" id="logo" alt="AgroItesz" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edici�n de clientes</title>
</head>
<% ClientesDAO dao = new ClientesDAO();
    List<Clientes> datos = (List<Clientes>)request.getAttribute("datosCl");
%>
<body style="background-color: #dfd7f5;">
    <header>
        <nav id="N">
            <ul id="U">
                <li>
                    <a>Clientes</a>
                </li>
                <li>
                    <form action="Controlador?accion=ClientesS" method="POST" >
                        <input type="text" placeholder="b�squeda" name="busqueda"   > 
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
        <form action="Controlador?accion=ClientesI" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td><input type="text" placeholder="Nombre" name="txtNombre"/></td>
                        <td><input type="text" placeholder="Raz�n Social" name="txtRazonSocial"/></td>
                        <td><input type="number" placeholder="L�mite de cr�dito" name="txtLimiteCredito"/></td>
                        <td><input type="text" placeholder="Direcci�n" name="txtDireccion"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="C�digo Postal" name="txtCodigoPostal"/></td>
                        <td><input type="text" placeholder="RFC" name="txtRFC"/></td>
                        <td><input type="text" placeholder="Tel�fono" name="txtTelefono"/></td>
                        <td><input type="text" placeholder="Email" name="txtEmail"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="Tipo" name="txtTipo"/></td>
                        <td><input type="number" placeholder="Ciudad" name="txtCiudad"/></td>
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
                    <th>#cliente</th>
                    <th>nombre</th>
                    <th>raz�n social</th>
                    <th>limite cr�dito</th>
                    <th>direcci�n</th>
                    <th>C�digo Postal</th>
                    <th>rfc</th>
                    <th>tel�fono</th>
                    <th>email</th>
                    <th>tipo</th>
                    <th>ciudad</th>
                    <th>estatus</th>
                    <th>Acciones</th> 
                </tr>
            </thead>
            <%
                int idc;
                //datos = dao.consultar();
                for (Clientes cl : datos) {
            %>
            <tbody>
                <tr>
                    <td><%=  idc = cl.getIdCliente()%></td>
                    <td><%= cl.getNombre()%></td>
                    <td><%= cl.getRazonSocial()%></td>
                    <td><%= cl.getLimiteCredito()%></td>
                    <td><%= cl.getDireccion()%></td>
                    <td><%= cl.getCodigoPostal()%></td>
                    <td><%= cl.getRfc()%></td>
                    <td><%= cl.getTelefono()%></td>
                    <td><%= cl.getEmail()%></td>
                    <td><%= cl.getTipo()%></td>

                    <td><%= cl.getIdCiudad()%></td>
                    <%
                        if (cl.getEstado() == 'A') {
                    %>
                    <td>Activo</td> 
                    <%    } else {                    %>
                    <td>Inactivo</td>
                    <%    }%>                        </form>

                    <td> <form action="Controlador?accion=ClientesU&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc">Editar</button>
                        </form>
                        <form action="Controlador?accion=ClientesD&id=<%= idc%>" method="POST">
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