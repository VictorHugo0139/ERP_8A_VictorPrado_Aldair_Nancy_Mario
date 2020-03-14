<%@page import="Modelo.datos.ClientesDAO" %>
<%@page import="java.util.*" %>
<%@page import="Modelo.Clientes" %>
<!DOCTYPE html>
<html>

    <head>
        <style>
            /*estilo nav general*/
            nav{
                border-radius: 1em;
            }
            nav ul{
                list-style: none;
                padding: 0;
            }
            .busqueda{
                float: right;
                margin-right: 20px;
                margin-top: 7px;
                border-radius: 0.33em;
            }
            nav li{
                line-height: 3rem;
                position: relative;
            }
            nav li ul{
                position: absolute;
            }
            nav a{
                color: #fff;
                display: block;
                padding: 0 2.5em;
                text-decoration: none;
                font-size: x-large;
                transition: .5s;
            }
            nav a:hover{
                background: #301b69;
                color: #fff;
            }
            nav li ul{
                display: none;
            }
            nav li:hover ul{
                display: block;
            }
            /*Primer nivel*/
            nav>ul{
                background: #1b0c45;
                display: table;
                border-radius: 1em;
                width: 95%;
                max-width: 1000px;
                margin: auto;
            }
            nav>ul>li{
                float: left;
            }
        </style>
    <img src="Images/pla1.png" height="10%" width="10%" id="logo" alt="AgroItesz" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edición de clientes</title>
</head>
<% ClientesDAO dao = new ClientesDAO();
    List<Clientes> datos = new ArrayList<>();
%>
<body style="background-color: #dfd7f5;">
    <header>
        <nav>
            <ul>
                <li>
                    <a>Clientes</a>
                </li>
                <li class="busqueda">
                    <form action="Controlador?accion=ClientesS">
                        <button style="width: 20%; background-color: #15b332; color: #fff; font-weight: bold;" class="busqueda">
                        <img src="Images/busqueda.jpg" alt="buscar" style="width: 10%; height: 10%;">
                        Buscar
                    </button>
                    <input type="text" name="busqueda" id="busqueda" class="busqueda" style="width: 30%;">
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
                        <td><input type="text" placeholder="Razón Social" name="txtRazonSocial"/></td>
                        <td><input type="text" placeholder="Límite de crédito" name="txtLimiteCredito"/></td>
                        <td><input type="text" placeholder="Dirección" name="txtDireccion"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="Código Postal" name="txtCodigoPostal"/></td>
                        <td><input type="text" placeholder="RFC" name="txtRFC"/></td>
                        <td><input type="text" placeholder="Teléfono" name="txtTelefono"/></td>
                        <td><input type="text" placeholder="Email" name="txtEmail"/></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="Tipo" name="txtTipo"/></td>
                        <td><input type="text" placeholder="Ciudad" name="txtCiudad"/></td>
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
                    <th>razón social</th>
                    <th>limite crédito</th>
                    <th>dirección</th>
                    <th>Código Postal</th>
                    <th>rfc</th>
                    <th>teléfono</th>
                    <th>email</th>
                    <th>tipo</th>
                    <th>ciudad</th>
                    <th>estatus</th>
                    <th>Acciones</th> 
                </tr>
            </thead>
            <%
                int idc;
                datos = dao.consultar();
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
                    <%    }%>
                    <td> <form action="Controlador?accion=ClientesU&id=<%= idc%>" method="POST">
                            <button type="submit" >Editar</button>
                        </form>
                        <form action="Controlador?accion=ClientesD&id=<%= idc%>" method="POST">
                            <button type="submit"  >Eliminar</button>
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