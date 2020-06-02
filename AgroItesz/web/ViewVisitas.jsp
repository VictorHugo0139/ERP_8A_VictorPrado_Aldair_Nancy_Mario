<%@page import="Modelo.datos.ClienteCultivoDAO"%>
<%@page import="Modelo.ClienteCultivo"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Modelo.datos.TransporteDAO" %>
<%@page import="Modelo.datos.EmpleadosDAO" %>
<%@page import="Modelo.datos.VisitasDAO" %>
<%@page import="java.util.*" %>
<%@page import="Modelo.Transporte" %>
<%@page import="Modelo.Empleados" %>
<%@page import="Modelo.Visitas" %>

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

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicion de Visitas</title>
    </head>
    <%  TransporteDAO transport = TransporteDAO.getTransporteDAO();
        ClienteCultivoDAO cl=ClienteCultivoDAO.getClienteCultivoDAO();
        EmpleadosDAO em = EmpleadosDAO.getEmpleadosDAO();
        List<Visitas> datos = (List<Visitas>) request.getAttribute("datosCl");
        List<Transporte> datosTr = transport.consultar();
        List<ClienteCultivo> datosCli = cl.consultar();
        List<Empleados> datosEmp = em.consultar();
    %>

    <body style="background-color: #dfd7f5;">
        <header>
            <nav id="N">
                <ul id="U">
                    <li style="width: 50px;">
                        <a href="principal.jsp" style="width: 50px;"><img src="Images/arrow-left.png" height="70%" width="70%" alt="Regresar" /></a>

                    </li>
                    <li>
                        <a>Visitas</a>
                    </li>
                    <li>
                        <form action="Controlador?accion=EnviosS" method="POST" >
                            <input type="text" placeholder="busqueda" name="busqueda" style="color: black;">
                            <label>En base a:</label>
                            <select name="campo" style="color: black;">
                                <option value="idCliente">#Visita</option>
                                <option value="nombre">Nombre</option>
                                <option value="razonSocial">Razon Social</option>
                                <option value="limiteCredito">Limite Credito</option>
                                <option value="direccion">Direccion</option>
                                <option value="codigoPostal">Codigo Postal</option>
                                <option value="rfc">RFC</option>
                                <option value="telefono">Telefono</option>
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
            <form action="Controlador?accion=VisitasI" method="POST" name="formInsertar" onsubmit="return validar(formInsertar)">
                <table border="0" style="width: 100%">
                    <tbody> 
                        <tr>
                            <td style="width: 25%" colspan="2"><input type="Date" placeholder="Fecha Planeada" name="txtFechaP" id="txtFEP" style="width: 90%;" value="" required/></td>
                            <td style="width: 25%" colspan="2"><input type="Date" placeholder="fecha Real" name="txtFechaR" id="txtFER" style="width: 90%;" value="" required /></td>
                            <td style="width: 25%"><input type="text" step="0.01" placeholder="Comentario" name="txtComentario" style="width: 90%;" required/></td>              
                        </tr>
                        <td><label>Estatus</label>
                                <input type="radio" id="Activo" name="txtEstatus" value="A" required>
                                <label for="Activo">Activo</label>
                                <input type="radio" id="Inactivo" name="txtEstatus" value="I">
                                <label for="Inactivo">Inactivo</label>
                            </td>
                        <tr>
                            <td style="width: 25%"><input type="number" placeholder="Costo" name="txtCosto" style="width: 90%;"required/></td>
                        </tr>
                        <tr>
                            <td>
                                <label style="color: grey;font-weight: lighter;">Venta:</label>
                                <select name="txtClienteCultivo">
                                    <%
                                        for (ClienteCultivo clcu : datosCli) {
                                            //String Ciudad = city.OneCity(cl.getIdCiudad());

                                    %>
                                    <option value="<%= clcu.getIdClienteCultivo()%>"><%= clcu.getExtencion() %></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                            <td>
                                <label style="color: grey;font-weight: lighter;">Ciudad:</label>
                                <select name="txtEmpleado">
                                    <%
                                        for (Empleados emp : datosEmp) {
                                            //String Ciudad = city.OneCity(cl.getIdCiudad());

                                    %>
                                    <option value="<%= emp.getIdEmpleado()%>"><%= emp.getNombre()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                            <td>
                                <label style="color: grey;font-weight: lighter;">Transporte:</label>
                                <select name="txtTransporte">
                                    <%
                                        for (Transporte tr : datosTr) {
                                            //String Ciudad = city.OneCity(cl.getIdCiudad());
                                            //System.out.println(tr.getIdTransporte());
                                            //System.out.println(", " + tr.getModelo());
                                    %>
                                    <option value="<%= tr.getIdTransporte()%>"><%= tr.getModelo() +" "+ tr.getMarca() +" "+tr.getPlacas() %></option>
                                    <%
                                        }
                                    %>
                                </select>
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

    <div style="margin-left: 180px; margin-top: 10px" id="divA" >
            <form action="Controlador?accion=VisitasU" method="POST" name="formActualizar" onsubmit="return validar(formActualizar);">
                <table border="0" style="width: 100%">
                    <tbody> 
                        <tr>
                            <td style="width: 25%"><input type="Date" placeholder="Fecha de Entrega Planeada" name="txtFechaEntregaP" id="txtFechaEntP" style="width: 90%;" value="" required/></td>
                            <td colspan="2"><input type="Date" placeholder="Fecha de Entrega Real" name="txtFechaEntregaR" id="txtFechaEntR" style="width: 90%;" required/></td>
                            <td style="width: 25%"><input type="text" step="0.01" placeholder="Direccion" name="txtDireccion" id="Direccion" style="width: 90%;" required/></td>
                            <td style="width: 25%"><input type="numbre" placeholder="Codigo Postal" name="txtCP" id="txtCP" style="width: 90%;" value="" required/></td>
                        </tr>
                        <tr>
                            <td id="CD">

                            </td>
                            <td id="CD2">

                            </td>
                            <td id="CD3">

                            </td>
                            <td><label>Estatus</label>
                                <input type="radio" id="ActivoA" name="txtEstatus" value="A" required>
                                <label for="Activo">Activo</label>
                                <input type="radio" id="InactivoA" name="txtEstatus" value="I">
                                <label for="Inactivo">Inactivo</label> 
                            </td>
                             <td colspan="3">
                            <input type="number" name="idCl" id="idCl"/>
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
                        <th  width='1%' style='border: 0;' scope='col'>#Visita</th>
                        <th  width='10%' style='border: 0;' scope='col'>Fecha Planeada</th>
                        <th  width='25%' style='border: 0;' scope='col'>Fecha Real</th>
                        <th  width='10%' style='border: 0;' scope='col'>Comentario</th>
                        <th  width='10%' style='border: 0;' scope='col'>Estatus</th>
                        <th  width='10%' style='border: 0;' scope='col'>Costo</th>
                        <th  width='10%' style='border: 0;' scope='col'>Cliente Cultivo</th>
                        <th  width='10%' style='border: 0;' scope='col'>Empleado</th>
                        <th  width='10%' style='border: 0;' scope='col'>Transporte</th>
                        <th  width='10%' style='border: 0;' scope='col'>Acciones</th> 
                    </tr>
                </thead>
                <tbody>
                    <%
                        int ido;
                        int contador=-1;
                        //datos = dao.consultar();
                        for (Visitas vi : datos) {
                            contador++;
                    %>
                <tr>
                <td><%= ido = vi.getIdVisita()%></td>
                <td><%= vi.getFechaPlaneada()%></td>
                <td><%= vi.getFechaReal()%></td>
                <td><%= vi.getComentarios()%></td>
                <%
                    if (vi.getEstado() == 'A') {
                %>
                <td>Activo</td> 
                <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                    <form action="Controlador?accion=EnviosD&id=<%= ido%>" method="POST">
                        <button type="submit" value='<%= ido%>' name="idc" class="boton2">
                            <span  class='glyphicon glyphicon-ban-circle'></span></button>
                    </form></td>
                    <%    } else {%>
                <td>Inactivo</td>
                <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                    <form action="Controlador?accion=EnviosR&id=<%= ido%>" method="POST">
                        <button type="submit" value='<%= ido%>' name="idc" class="boton2">
                            <span  class='glyphicon glyphicon-ok-circle'></span></button>
                    </form></td>
                    <%    }%>     
                <td><%= vi.getCosto()%></td>
                <%
                    datosCli = cl.OneClient(vi.getIdClienteCultivo());
                String cc=datosCli.get(0).getIdClienteCultivo() +" : "+ cl.consultarId(datosCli.get(0).getIdCliente()).get(0).getNombre() +" "+datosVen.get(0).getFecha();
                %>
                <td><%= cc %></td>
                <%
                    datosTr = transport.OneTransport(en.getIdTransporte());
                    String tt=datosTr.get(0).getModelo() +" "+ datosTr.get(0).getMarca() +" "+datosTr.get(0).getPlacas();
                %>
                <td><%= tt %></td>
                <%
                    String Ciudad = city.OneCity(en.getIdCiudad());
                %>
                <td><%=Ciudad%></td>                   
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
                function validar(formulario) {
                    var hoy = new Date();
                    var dd = hoy.getDate();
                    var mm = hoy.getMonth() + 1;
                    var yyyy = hoy.getFullYear();
                    var ano = parseInt(formulario.txtFechaEntregaP.value.toString().substring(0, 4));
                    var mes = parseInt(formulario.txtFechaEntregaP.value.toString().substring(5, 7));
                    var dia = parseInt(formulario.txtFechaEntregaP.value.toString().substring(8, 10));
                    var ano2 = parseInt(formulario.txtFechaEntregaR.value.toString().substring(0, 4));
                    var mes2 = parseInt(formulario.txtFechaEntregaR.value.toString().substring(5, 7));
                    var dia2 = parseInt(formulario.txtFechaEntregaR.value.toString().substring(8, 10));
                    var formatoNumero = /^[^a-zA-Z.,\/\\:;_\-\^\{\[\"\!\|��#\$%&\(\)\=\?\'��\}\]��\*\+\~`@]+$/;
                    var formatoubicacion = /^[\w.# ]+$/;
                    var t = false;

                    if (ano >= ano2) {
                        if (ano === ano2) {
                            if (mes >= mes2) {
                                if (dia < dia2) {
                                    alert("El dia de entrega planeada debe ser mayor o igual a la fecha de entrega real");
                                    formulario.txtFechaEntregaP.focus();
                                    return false;
                                }
                            } else {
                                alert("El mes de entrega planeada debe ser mayor o igual a la fecha de entrega real");
                                formulario.txtFechaEntregaP.focus();
                                return false;
                            }
                        }
                        if (formulario.txtDireccion.value.match(formatoubicacion))
                        {
                            if (formulario.txtDireccion.value.length > 100)
                            {
                                alert("El domicilio proporcionado es demasiado largo");
                                formulario.txtDireccion.focus();
                                return false;
                            }
                        } else {
                            alert("La ubicaci�n contiene alg�n caracter no permitido o est� vac�o");
                            formulario.txtDireccion.focus();
                            return false;
                        }

                        if (formulario.txtCP.value.match(formatoNumero))
                        {
                            if (formulario.txtCP.value.length !== 5)
                            {
                                alert("El codigo postal se compone de 5 digitos");
                                formulario.txtCP.focus();
                                return false;
                            }
                        } else {
                            alert("El codigo postal contiene alg�n caracter no permitido o est� vac�o");
                            formulario.txtCP.focus();
                            return false;
                        }
                        for (var i = 0; i < 2; i++)
                        {
                            if (formulario.txtEstatus[i].checked === true)
                            {
                                t = true;
                                break;
                            }
                        }
                        for (var i = 0; i < 2; i++)
                        {
                            if (formulario.txtEstatus[i].value !== "A" & formulario.txtEstatus[i].value !== "I") {
                                alert("Un valor del estatus ha sido modificado por el usuario, No se enviar�n los datos.");
                                return false;
                            }
                        }

                        if (t === false) {
                            alert("Debes selecionar el estatus de la venta");
                            formulario.txtEstatus.focus();
                            return false;
                        } else {
                            if (isNaN(formulario.txtVenta.options[formulario.txtVenta.selectedIndex].value)) {
                                alert("El valor asignado a la venta ha sido modificado por el usuario. No se enviar�.");
                                return false;
                            } else {
                                if (isNaN(formulario.txtTransporte.options[formulario.txtTransporte.selectedIndex].value)) {
                                    alert("El valor asignado al transporte ha sido modificado por el usuario. No se enviar�.");
                                    return false;
                                } else {
                                    if (isNaN(formulario.txtCiudad.options[formulario.txtCiudad.selectedIndex].value)) {
                                        alert("El valor asignado a la ciudad ha sido modificado por el usuario. No se enviar�.");
                                        return false;
                                    } else {
                                        alert("Datos enviados con �xito");
                                        return true;
                                    }
                                }
                            }
                        }
                    } else {
                        alert("El a�o ingresado es menor que el de la fecha de entrega");
                        formulario.txtFechaEntregaP.focus();
                        return false;
                    }
                }
            </script>

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
                        $('#divI').hide();
                        $('.boton').show();
                        $('.boton2').show();
                        $('#btnMostrarf').text('+');
                        $('#btnMostrar').html("<span  class='glyphicon glyphicon-plus-sign'></span>");
                    } else {
                        $('#txtFEP').val(hoyFecha());
                        $('#txtFER').val(hoyFecha());
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
                    $('#txtFechaEntP').val($(this).parents("tr").find("td")[1].innerHTML);
                    $('#txtFechaEntR').val($(this).parents("tr").find("td")[2].innerHTML);
                    $('#Direccion').val($(this).parents("tr").find("td")[3].innerHTML);
                    $('#txtCP').val($(this).parents("tr").find("td")[4].innerHTML);
                    var valor = $(this).parents("tr").find("td")[5].innerHTML;

                    console.log(valor);
                    $('#CD').html("<label style='color: grey;font-weight: lighter;'>Venta:</label>" +
                            "<select name='txtVenta'>" +
            <%  
                datosVen = build.consultar();
                String a;
                for (Ventas ve : datosVen) {
                     a=ve.getIdVenta() +" : "+ cl.consultarId(ve.getIdCliente()).get(0).getNombre() +" "+ve.getFecha();
            %>
                    "<option value='<%= ve.getIdVenta()%>' id='<%= a.replaceAll(" ", "") %>'><%= a %></option>" +
            <%

                }
            %>
                    "</select>");
                    $('#' + valor.split(' ').join('')).attr('selected', 'selected').change();

                    var valor = $(this).parents("tr").find("td")[6].innerHTML;
                    $('#CD2').html("<label style='color: grey;font-weight: lighter;'>Transporte:</label>" +
                            "<select name='txtTransporte'>"+
            <%
                datosTr = transport.consultar();
                for (Transporte tr : datosTr) {
                    a= tr.getModelo() +" "+ tr.getMarca() +" "+tr.getPlacas();
            %>
                    "<option value='<%= tr.getIdTransporte()%>' id='<%= a.replaceAll(" ", "") %>'><%= a%></option>" +
            <%
                }
            %>
                    "</select>"
                    );
                    $('#' + valor.split(' ').join('')).attr('selected', 'selected').change();
                    var valor = $(this).parents("tr").find("td")[7].innerHTML;
                    $('#CD3').html("<label style='color: grey;font-weight: lighter;'>Ciudad:</label>" +
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

                    if ($(this).parents("tr").find("td")[8].innerHTML === 'Activo') {
                        $('#ActivoA').prop("checked", true);
                    } else {
                        $('#InactivoA').prop("checked", true);
                    }
                    $('#nombre').focus();
                    
                    $('#' + valor).attr('selected', 'selected').change();
                    var valor = $(this).parents("tr").find("td")[0].innerHTML;
                    $('#idCl').val(valor);
                    $('#idCl').hide();
                    //console.log($('#idCl').val());
                    $('#nombre').focus();
                });
                $('#txtFechaEntregaP').val(hoyFecha());
                $('#txtFechaEntregaR').val(hoyFecha());
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
                            last: "ultimo"
                        }
                    }
                });
            });
        </script>  
</html>
