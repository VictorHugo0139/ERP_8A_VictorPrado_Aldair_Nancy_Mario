<%@page import="Modelo.datos.ClientesDAO" %>
<%@page import="Modelo.datos.CiudadesDAO" %>
<%@page import="java.util.*" %>
<%@page import="Modelo.Clientes" %>
<%@page import="Modelo.Ciudades" %>
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
    <title>Edición de clientes</title>
</head>
<% //ClientesDAO dao = new ClientesDAO();
    CiudadesDAO city = CiudadesDAO.getCiudadesDAO();
    List<Clientes> datos = (List<Clientes>) request.getAttribute("datosCl");
    //List<Clientes> datosF = (List<Clientes>) request.getAttribute("datosCl");
    List<Ciudades> datosCiu = city.consultar();
%>
<body style="background-color: #dfd7f5;">
    <header>
        <nav id="N">
            <ul id="U">
                <li style="width: 50px;">
                    <a href="principal.jsp" style="width: 50px;"><img src="Images/arrow-left.png" height="50%" width="50%" alt="Regresar" /></a>
                    
                </li>
                <li>
                    <a>Clientes</a>
                </li>
                <li>
                    <form action="Controlador?accion=ClientesS" method="POST" >
                        <input type="text" placeholder="búsqueda" name="busqueda"   >
                        <label>En base a:</label>
                        <select name="campo">
                            <option value="idCliente">#Cliente</option>
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
        <form action="Controlador?accion=ClientesI" method="POST" name="formInsertar" onsubmit="return Validar(formInsertar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtNombre" style="width: 90%;" required/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Apellido" name="txtApellido" style="width: 90%;" required /></td>
                        <td style="width: 25%"><input type="text" placeholder="Razón Social" name="txtRazonSocial" style="width: 90%;" required/></td>
                        <td style="width: 25%"><input type="number" placeholder="Límite de crédito" name="txtLimiteCredito" style="width: 90%;" step="0.01" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="text" placeholder="Nombre de la calle" name="txtCalle" style="width: 90%;" required/></td>
                        <td><input type="number" placeholder="Numero" name="txtNumero" style="width: 90%;"/></td>
                        <td><input type="number" placeholder="Código Postal" name="txtCodigoPostal" style="width: 80%;" required/></td>
                        <td><input type="text" placeholder="RFC" name="txtRFC" required/></td>
                        <td colspan="2"><input type="email" placeholder="Email" name="txtEmail" style="width: 90%;" required/></td>
                    </tr>
                    <tr>
                        <td><input type="tel" placeholder="Teléfono" name="txtTelefono" required/></td>
                        <td><label>Genero:</label></td>
                        <td colspan="2"><input type="radio" id="Masculino" name="txtTipo" value="M" required>
                            <label for="Masculino">Masculino</label>
                            <input type="radio" id="Femenino" name="txtTipo" value="F">
                            <label for="Femenino">Femenino</label>
                            <input type="radio" id="Otro" name="txtTipo" value="O">
                            <label for="Otro">Otro</label>
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
        
        <form action="Controlador?accion=ClientesU" method="POST" name="formActualizar" onsubmit="return ValidarA(formActualizar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtNombre" id="nombre" style="width: 90%;" required/></td>
                        <td style="width: 25%"><input type="text" placeholder="Razón Social" name="txtRazonSocial" id="razonSocial" style="width: 90%;" required/></td>
                        <td style="width: 25%"><input type="number" placeholder="Límite de crédito" name="txtLimiteCredito" id="limiteCredito" step="0.01" style="width: 90%;" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="text" placeholder="Nombre de la calle" name="txtUbicacion" id="ubicacion" style="width: 90%;" required/></td>
                        <td><input type="number" placeholder="Código Postal" name="txtCodigoPostal" id="codigoPostal" style="width: 80%;" required/></td>
                        <td><input type="text" placeholder="RFC" name="txtRFC" id="RFC" required/></td>
                        <td colspan="2"><input type="email" placeholder="Email" name="txtEmail" id="email" style="width: 90%;" required/></td>
                    </tr>
                    <tr>
                        <td><input type="tel" placeholder="Teléfono" name="txtTelefono" id="telefono" required/></td>
                        <td><label>Genero:</label></td>
                        <td colspan="2"><input type="radio" id="MasculinoA" name="txtTipoA" value="M" required>
                            <label for="Masculino">Masculino</label>
                            <input type="radio" id="FemeninoA" name="txtTipoA" value="F">
                            <label for="Femenino">Femenino</label>
                            <input type="radio" id="OtroA" name="txtTipoA" value="O">
                            <label for="Otro">Otro</label>
                        </td>
                        <td id='CD'>

                        </td>
                        <td><label>Estatus:</label>
                            <input type="radio" id="ActivoA" name="txtEstatusA" value="A" required>
                            <label for="Activo">Activo</label>
                            <input type="radio" id="InactivoA" name="txtEstatusA" value="I">
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
        </br>
    </div>
    <div>
        <table width='100%' border='0' cellpadding='0' id='customers'>
            <thead>
                <tr>
                    <th  width='1%' style='border: 0;' scope='col'>#Cliente</th>
                    <th  width='10%' style='border: 0;' scope='col'>Nombre</th>
                    <th  width='25%' style='border: 0;' scope='col'>Razón Social</th>
                    <th  width='10%' style='border: 0;' scope='col'>Limite Crédito</th>
                    <th  width='10%' style='border: 0;' scope='col'>Dirección</th>
                    <th  width='10%' style='border: 0;' scope='col'>Código Postal</th>
                    <th  width='10%' style='border: 0;' scope='col'>RFC</th>
                    <th  width='10%' style='border: 0;' scope='col'>Teléfono</th>
                    <th  width='10%' style='border: 0;' scope='col'>Email</th>
                    <th  width='10%' style='border: 0;' scope='col'>Genero</th>
                    <th  width='10%' style='border: 0;' scope='col'>Ciudad</th>
                    <th  width='10%' style='border: 0;' scope='col'>Estatus</th>
                    <th  width='10%' style='border: 0;' scope='col'>Acciones</th> 
                </tr>
            </thead>
            <tbody>
                <%
                    int idc;
                    //datos = dao.consultar();
                    for (Clientes cl : datos) {
                %>
                <tr>
                    <td><%= idc = cl.getIdCliente()%></td>
                    <td><%= cl.getNombre()%></td>
                    <td><%= cl.getRazonSocial()%></td>
                    <td><%= cl.getLimiteCredito()%></td>
                    <td><%= cl.getDireccion()%></td>
                    <td><%= cl.getCodigoPostal()%></td>
                    <td><%= cl.getRfc()%></td>
                    <td><%= cl.getTelefono()%></td>
                    <td><%= cl.getEmail()%></td>
                    <td><%= cl.getTipo()%></td>
                    <%
                        String Ciudad = city.OneCity(cl.getIdCiudad());
                    %>
                    <td><%=Ciudad%></td>
                    <%
                        if (cl.getEstado() == 'A') {
                    %>
                    <td>Activo</td> 
                    <td><button class="boton">Editar</button>
                        <form action="Controlador?accion=ClientesD&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc">Eliminar</button>
                        </form></td>
                    <%    } else {                    %>
                    <td>Inactivo</td>
                    <td><button class="boton">Editar</button>
                        <form action="Controlador?accion=ClientesR&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc">Reactivar</button>
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
    <script type="text/javascript">
            function ValidarA(formulario)
            {
                var formatoEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                var formatoNomAp = /^[^0-9.,\/\\:;_\-\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;
                var formatoRZ = /^[^0-9\/\\:;_\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;
                var formatoLC = /^[^a-zA-Z,\/\\:;_\-\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;
                var t = false;
                var formatoubicacion = /^[\w. ]+$/;
                var formatoNumero = /^[^a-zA-Z.,\/\\:;_\-\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;

                if (formulario.txtEmail.value.match(formatoEmail))
                {
                    if (formulario.txtNombre.value.length > 2)
                    {
                        if (formulario.txtNombre.value.length < 99)
                        {
                            if (formulario.txtNombre.value.match(formatoNomAp))
                            {
                                    if (formulario.txtRazonSocial.value.length > 2)
                                    {
                                        if (formulario.txtRazonSocial.value.length < 100)
                                        {
                                            if (formulario.txtRazonSocial.value.match(formatoRZ))
                                            {
                                                if (formulario.txtLimiteCredito.value.match(formatoLC))
                                                {
                                                    if (formulario.txtLimiteCredito.value >= 0)
                                                    {
                                                        if (formulario.txtUbicacion.value.match(formatoubicacion))
                                                        {
                                                            if (formulario.txtUbicacion.value.length < 75)
                                                            {

                                                                if (formulario.txtCodigoPostal.value.match(formatoNumero))
                                                                {
                                                                    if (formulario.txtCodigoPostal.value.length === 5)
                                                                    {
                                                                        if (formulario.txtRFC.value.length < 13)
                                                                        {
                                                                            if (formulario.txtTelefono.value.match(formatoNumero))
                                                                            {
                                                                                for (var i = 0; i < 3; i++)
                                                                                {
                                                                                    if (formulario.txtTipoA[i].checked === true)
                                                                                    {
                                                                                        t = true;
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                if (t === false) {
                                                                                    alert("Debes selecionar el genero");
                                                                                    formulario.txtTipoA.focus();
                                                                                    return false;
                                                                                } else {
                                                                                    t = false;
                                                                                    for (var i = 0; i < 2; i++)
                                                                                    {
                                                                                        if (formulario.txtEstatusA[i].checked === true)
                                                                                        {
                                                                                            t = true;
                                                                                            return true;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    if (t === false) {
                                                                                        alert("Debes selecionar el estatus");
                                                                                        formulario.txtEstatusA.focus();
                                                                                        return false;
                                                                                    } else {
                                                                                        return true;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                alert("El teléfono contiene algún caracter no permitido");
                                                                                formulario.txtTelefono.focus();
                                                                                return false;
                                                                            }
                                                                        } else {
                                                                            alert("El RFC no debe tener más de 13 digitos");
                                                                            formulario.txtRFC.focus();
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        alert("El codigo postal se compone de 5 digitos");
                                                                        formulario.txtCodigoPostal.focus();
                                                                        return false;
                                                                    }
                                                                } else {
                                                                    alert("El codigo postal contiene algún caracter no permitido o está vacío");
                                                                    formulario.txtCodigoPostal.focus();
                                                                    return false;
                                                                }
                                                            } else {
                                                                alert("El domicilio proporcionado es demasiado largo");
                                                                formulario.txtUbicacion.focus();
                                                                return false;
                                                            }
                                                        } else {
                                                            alert("La ubicación contiene algún caracter no permitido o está vacío");
                                                            formulario.txtUbicacion.focus();
                                                            return false;
                                                        }
                                                    } else {
                                                        alert("Puede no tener limite de credito pero no puede ser negativo");
                                                        formulario.txtLimiteCredito.focus();
                                                        return false;
                                                    }
                                                } else {
                                                    alert("El límite de crédito contiene algún caracter no permitido o está vacío");
                                                    formulario.txtLimiteCredito.focus();
                                                    return false;
                                                }
                                            } else {
                                                alert("La razón social contiene algún caracter no permitido o está vacío");
                                                formulario.txtRazonSocial.focus();
                                                return false;
                                            }
                                        } else {
                                            alert("La razón social es demasiado extensa");
                                            formulario.txtRazonSocial.focus();
                                            return false;
                                        }
                                    } else {
                                        alert("La razón social es demasiado corta");
                                        formulario.txtRazonSocial.focus();
                                        return false;
                                    }
                                } else {
                                    alert("El nombre contiene algún caracter no permitido o está vacío");
                                    formulario.txtNombre.focus();
                                    return false;
                                }
                            } else {
                                alert("nombre y/o apellido demasiado largos");
                                formulario.txtNombre.focus();
                                return false;
                            }

                        } else {
                            alert("El nombre es demasiado corto");
                            formulario.txtNombre.focus();
                            return false;
                        }
                    } else
                    {
                        alert("Ingresa una dirección de correo valida");
                        formulario.txtEmail.focus();
                        return false;
                    }
                }
    </script>
    <script type="text/javascript">
        function Validar(formulario)
        {
            var formatoEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            var formatoNomAp = /^[^0-9.,\/\\:;_\-\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;
            var formatoRZ = /^[^0-9,\/\\:;_\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;
            var formatoLC = /^[^a-zA-Z,\/\\:;_\-\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;
            var formatoCalle = /^[\w ]+$/;
            var formatoNumero = /^[^a-zA-Z.,\/\\:;_\-\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;
            var t = false;
            if (formulario.txtEmail.value.match(formatoEmail))
            {
                if (formulario.txtNombre.value.length > 2)
                {
                    if (formulario.txtApellido.value.length > 2)
                    {
                        if ((formulario.txtNombre.value.length +
                                formulario.txtApellido.value.length) < 99)
                        {
                            if (formulario.txtNombre.value.match(formatoNomAp))
                            {
                                if (formulario.txtApellido.value.match(formatoNomAp))
                                {
                                    if (formulario.txtRazonSocial.value.length > 2)
                                    {
                                        if (formulario.txtRazonSocial.value.length < 100)
                                        {
                                            if (formulario.txtRazonSocial.value.match(formatoRZ))
                                            {
                                                if (formulario.txtLimiteCredito.value.match(formatoLC))
                                                {
                                                    if (formulario.txtLimiteCredito.value >= 0)
                                                    {
                                                        if (formulario.txtCalle.value.match(formatoCalle))
                                                        {
                                                            if (formulario.txtNumero.value.match(formatoNumero))
                                                            {
                                                                if (formulario.txtNumero.value > 0)
                                                                {
                                                                    if (formulario.txtCalle.value.length + formulario.txtNumero.value.length < 75)
                                                                    {

                                                                        if (formulario.txtCodigoPostal.value.match(formatoNumero))
                                                                        {
                                                                            if (formulario.txtCodigoPostal.value.length === 5)
                                                                            {
                                                                                if (formulario.txtRFC.value.length < 13)
                                                                                {
                                                                                    if (formulario.txtTelefono.value.match(formatoNumero))
                                                                                    {
                                                                                        for (var i = 0; i < 3; i++)
                                                                                        {
                                                                                            if (formulario.txtTipo[i].checked === true)
                                                                                            {
                                                                                                t = true;
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        if (t === false) {
                                                                                            alert("Debes selecionar el genero");
                                                                                            formulario.txtTipo.focus();
                                                                                            return false;
                                                                                        } else {
                                                                                            t = false;
                                                                                            for (var i = 0; i < 2; i++)
                                                                                            {
                                                                                                if (formulario.txtEstatus[i].checked === true)
                                                                                                {
                                                                                                    t = true;
                                                                                                    return true;
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            if (t === false) {
                                                                                                alert("Debes selecionar el estatus");
                                                                                                formulario.txtEstatus.focus();
                                                                                                return false;
                                                                                            } else {
                                                                                                return true;
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        alert("El telefono Tiene algún carcater no permitido");
                                                                                        formulario.txtTelefono.focus();
                                                                                        return false;
                                                                                    }
                                                                                } else {
                                                                                    alert("El RFC no debe tener más de 13 digitos");
                                                                                    formulario.txtRFC.focus();
                                                                                    return false;
                                                                                }
                                                                            } else {
                                                                                alert("El codigo postal se compone de 5 digitos");
                                                                                formulario.txtCodigoPostal.focus();
                                                                                return false;
                                                                            }
                                                                        } else {
                                                                            alert("El codigo postal contiene algún caracter no permitido o está vacío");
                                                                            formulario.txtCodigoPostal.focus();
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        alert("El domicilio proporcionado es demasiado largo");
                                                                        formulario.txtCalle.focus();
                                                                        return false;
                                                                    }
                                                                } else {
                                                                    alert("El numero de domicilio no puede ser 0 ni menor");
                                                                    formulario.txtNumero.focus();
                                                                    return false;
                                                                }
                                                            } else {
                                                                alert("El numero de domicilio contiene algún caracter no permitido o está vacío");
                                                                formulario.txtNumero.focus();
                                                                return false;
                                                            }
                                                        } else {
                                                            alert("El nombre de la calle contiene algún caracter no permitido o está vacío");
                                                            formulario.txtCalle.focus();
                                                            return false;
                                                        }
                                                    } else {
                                                        alert("Puede no tener limite de credito pero no puede ser negativo");
                                                        formulario.txtLimiteCredito.focus();
                                                        return false;
                                                    }
                                                } else {
                                                    alert("El límite de crédito contiene algún caracter no permitido o está vacío");
                                                    formulario.txtLimiteCredito.focus();
                                                    return false;
                                                }
                                            } else {
                                                alert("La razón social contiene algún caracter no permitido o está vacío");
                                                formulario.txtRazonSocial.focus();
                                                return false;
                                            }
                                        } else {
                                            alert("La razón social es demasiado extensa");
                                            formulario.txtRazonSocial.focus();
                                            return false;
                                        }
                                    } else {
                                        alert("La razón social es demasiado corta");
                                        formulario.txtRazonSocial.focus();
                                        return false;
                                    }
                                } else {
                                    alert("El apellido contiene algún caracter no permitido o está vacío");
                                    formulario.txtApellido.focus();
                                    return false;
                                }
                            } else {
                                alert("El nombre contiene algún caracter no permitido o está vacío");
                                formulario.txtNombre.focus();
                                return false;
                            }
                        } else {
                            alert("nombre y/o apellido demasiado largos");
                            formulario.txtNombre.focus();
                            return false;
                        }
                    } else {
                        alert("El apellido es demasiado corto");
                        formulario.txtApellido.focus();
                        return false;
                    }
                } else {
                    alert("El nombre es demasiado corto");
                    formulario.txtNombre.focus();
                    return false;
                }
            } else
            {
                alert("Ingresa una dirección de correo valida");
                formulario.txtEmail.focus();
                return false;
            }
        }
    </script>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#divI').hide();
        $('#divA').hide();
        $('#btnMostrar').click(function () {
            if ($('#btnMostrar').text() === '-') {
                $('#divI').hide();
                $('#btnMostrar').text('+');
            } else {
                $('#divI').show();
                $('#btnMostrar').text('-');
            }
        });
        $('.boton').click(function () {

            //valores obtendra el dato del td por posciones [0]
            $('#btnMostrar').hide();
            $('#divI').hide();
            $('#divA').show();
            $('#nombre').val($(this).parents("tr").find("td")[1].innerHTML);
            $('#razonSocial').val($(this).parents("tr").find("td")[2].innerHTML);
            $('#limiteCredito').val($(this).parents("tr").find("td")[3].innerHTML);
            $('#ubicacion').val($(this).parents("tr").find("td")[4].innerHTML);
            $('#codigoPostal').val($(this).parents("tr").find("td")[5].innerHTML);
            $('#RFC').val($(this).parents("tr").find("td")[6].innerHTML);
            $('#telefono').val($(this).parents("tr").find("td")[7].innerHTML);
            $('#email').val($(this).parents("tr").find("td")[8].innerHTML);
            switch ($(this).parents("tr").find("td")[9].innerHTML) {
                case 'F':
                    $('#FemeninoA').prop("checked", true);
                    break;
                case 'M':
                    $('#MasculinoA').prop("checked", true);
                    break;
                case 'O':
                    $('#OtroA').prop("checked", true);
                    break;
            }
            var valor = $(this).parents("tr").find("td")[10].innerHTML;
            //console.log(valor);
            $('#CD').html("<label style='color: grey;font-weight: lighter;'>Ciudad:</label>" +
                    "<select name='txtCiudad' id='Ciudad'>" +
    <%
                                    for (Ciudades ci : datosCiu) {
                                        //String Ciudad = city.OneCity(cl.getIdCiudad());
%>
            "<option value='<%= ci.getIdCiudad()%>' id='<%= ci.getNombre()%>'><%= ci.getNombre()%></option>" +
    <%
                                    }
    %>
            "</select>");
            $('#' + valor).attr('selected', 'selected').change();
            
            if ($(this).parents("tr").find("td")[11].innerHTML === 'Activo') {
                $('#ActivoA').prop("checked", true);
            } else {
                $('#InactivoA').prop("checked", true);
            }
            console.log($(this).parents("tr").find("td")[0].innerHTML);
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
                    last: "Último"
                }
            }
        });
    });
</script>  
</html>