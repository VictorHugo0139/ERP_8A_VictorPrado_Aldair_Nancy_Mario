<%@page import="Conexion.Conexion"%>
<%@page import="Modelo.datos.VentasDetallesDAO"%>
<%@page import="Modelo.VentasDetalles"%>
<%@page import="Modelo.Empleados"%>
<%@page import="Modelo.datos.EmpleadosDAO"%>
<%@page import="Modelo.Sucursal"%>
<%@page import="Modelo.datos.SucursalDAO"%>
<%@page import="Modelo.datos.ClientesDAO"%>
<%@page import="Modelo.datos.ProductosDAO"%>
<%@page import="Modelo.datos.PresentacionDAO"%>
<%@page import="Modelo.Clientes"%>
<%@page import="Modelo.Ventas"%>
<%@page import="Modelo.Productos"%>
<%@page import="Modelo.Presentacion"%>
<%@page import="java.util.*" %>
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
            #U .seccion a:hover{
                background-color: #15b332;
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
        <link rel="icon" type="image/x-icon" href="Images/favicon.ico">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <a href="principal.jsp" id="retorno"><img src="Images/pla1.png" height="10%" width="10%" id="logo" alt="AgroItesz" /></a>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edición de Ventas</title>
</head>
<%
    Conexion sesion = Conexion.getInsConexion();
    ClientesDAO cdao;
    SucursalDAO sdao;
    EmpleadosDAO edao;
    ProductosDAO pdao;
    PresentacionDAO prdao;
    VentasDetallesDAO vddao;
    List<Ventas> datos;
    List<Clientes> c;
    List<Sucursal> s;
    List<Empleados> e;
    List<Productos> p;
    List<Presentacion> pr;
    List<VentasDetalles> datosvd;
    cdao = ClientesDAO.getClientesDAO();
    sdao = SucursalDAO.getSucursalDAO();
    edao = EmpleadosDAO.getEmpleadosDAO();
    pdao = ProductosDAO.getProducosDAO();
    prdao = PresentacionDAO.getPresentacionDAO();
    vddao = VentasDetallesDAO.getVentasDetallesDAO();
    datos = (List<Ventas>) request.getAttribute("datosCl");
    c = cdao.consultar();
    s = sdao.consultar();
    e = edao.consultar();
    p = pdao.consultar();
    pr = prdao.consultar();
    datosvd = (List<VentasDetalles>) request.getAttribute("datosClU");

%>
<body style="background-color: #dfd7f5;"><!-- Cuerpo del Documento -->
    <!-- Encabezado -->
    <header>
        <nav id="N"><!-- Barra de navegación -->
            <ul id="U">
                <li style="width: 50px;"><!-- Primer Item (Flecha de retorno) -->
                    <a href="principal.jsp" style="width: 50px;" id="retorno2"><img src="Images/arrow-left.png" height="70%" width="70%" alt="Regresar" /></a>

                </li>
                <li class="seccion"><!-- Segundo Item (Link Ventas) -->
                    <a href="Controlador?accion=Ventas">Ventas</a>
                </li>
                <li class="seccion"><!-- Tercer Item (Link Cobros) -->
                    <a href="Controlador?accion=Cobros">Cobros</a>
                </li>
                <li class="seccion"><!-- Cuarto Item (Link Facturas) -->
                    <a href="Controlador?accion=Facturas">Facturas</a>
                </li>
                <li><!-- Quinto Item (Sección de Busqueda) -->
                    <form action="Controlador?accion=VentasS" method="POST" ><!-- Formulario para el envío de datos de búsqueda -->
                        <input type="text" placeholder="búsqueda" name="busqueda" style="color: black;"/><!-- Ingreso de palabra buscada -->
                        <label>En base a:</label>
                        <select name="campo" style="color: black;"><!-- Lista con nombre de columnas, escoger la columna en que se desea buscar -->
                            <option value="idVenta">#Venta</option>
                            <option value="fecha">Fecha</option>
                            <option value="totalPagar">Total a Pagar</option>
                            <option value="cantidad">Cantidad Pagada</option>
                            <option value="comentarios">Comentarios</option>
                            <option value="codigoPostal">Estatus</option>
                            <option value="tipo">Tipo</option>
                            <option value="idCliente">Cliente</option>
                            <option value="idSucursal">Sucursal</option>
                            <option value="idEmpleado">Empleado</option>
                        </select>
                        <!-- Botón que realiza el envío de la información -->
                        <button style="width: 20%; background-color: #15b332; color: #fff; font-weight: bold;"  type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                            Buscar
                        </button>
                    </form><!-- Hasta aqui llega el formulario de búsqueda -->
                </li>
            </ul>
        </nav><!-- Hasta aquí llega el menú de navegación -->
    </header>
    <!-- Fin de encabezado -->

    <!-- Sección Insertar -->
    <button id="btnMostrarf">+</button><!-- No eliminar. Este botón controla el cambio de signo de #btnMostrar -->

    <button id="btnMostrar" hidden=""><span  class="glyphicon glyphicon-plus-sign"></span></button><!-- Este botón contrae o expande #divI -->
    <div style="margin-left: 180px; padding-top: 0px;"  id="divI"><!-- Contiene todo el proceso de insertar Nueva Venta, incluye detalles de Venta -->
        <table border="0" style="width: 100%; padding-top: 0px;"><!-- Tabla que organiza la ubicación en pantalla del contenido -->
            <tbody><!-- Cuerpo de la tabla-No hay encabezado ya que sólo es para organizar la información -->
                <!-- Primera Fila de Datos --> 
                <tr>
                    <td style="width: 20%" ></td><!-- Separacion por un 20% del espacio total -->
                    <td style="width: 20%"></td><!-- Separacion por un 20% del espacio total -->
                    <td style="width: 20%"></td><!-- Separacion por un 20% del espacio total -->
                    <td style="width: 15%"><label style="color: grey;font-weight: lighter;">Cliente</label>
                        <!-- Lista de clientes para selección -->
                        <select name="txtCliente">
                            <%                                    for (Clientes cl : c) {
                            %>
                            <option value="<%= cl.getIdCliente()%>"><%= cl.getNombre()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <!-- Si el cliente no se encuentra en la lista éste botón muestra el formulario para agregar un nuevo cliente -->
                    <td style="width: 25%;padding-top: 20px;"><button type="button">Agregar Cliente Nvo.</button></td>
                    <!-- Aqui falta un TD donde colocarás el formulario para nuevo cliente, debes poner id a los 2 TD anteriores para ocultarlos cuando muestres este-->
                    <!-- Una vez agregado el nuevo cliente por el formulario se oculta este TD y se muestran los 2 TD anteriores (seleccionado el recien agregado) -->
                </tr>
                <!-- Segunda Fila de Datos -->
                <tr><!-- Solamente la división de sección con Titulo -->
                    <td style=" border-bottom: solid red;" colspan="5"><h4 style="color: black;font-weight: lighter;">Detalles de la venta</h4></td>
                </tr>
                <!-- Tercera Fila de Datos -->
                <tr>
                    <!-- Este TD es realmente especial por el momento. 
                    Incluye Un elemento Modal(Cuadro que se sobrepone) que permite seleccionar los elementos que incluirá la venta.
                    -->
                    <td style="width: 20%; padding-top: 5px;">

                        <!-- Éste botón activa el modal -->
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                            Agregar Productos
                        </button>
                        <!-- Probablemente sea buena idea agregar un check con estilo que se active automaticamente cuando ya se agregue uno o mas productos -->

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                                <div class="modal-content">
                                    <!-- Encabezado del Modal -->
                                    <div class="modal-header">
                                        <!-- Titulo y botón de cierre-->
                                        <h5 class="modal-title" id="exampleModalLongTitle">Agregar Productos</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Cancelar">
                                        </button>
                                    </div>
                                    <!-- Cuerpo del Modal -->
                                    <div class="modal-body">
                                        <table><!-- Esta tabla organiza el contenido que agrega un nuevo producto-->
                                            <tbody><!-- Cuerpo de la tabla, No tiene encabezado, que sólo es para organizar datos -->
                                                <tr>
                                                    <td style="width: 20%; padding-top: 5px;">
                                                        <label style="color: grey;font-weight: lighter;" >Productos</label>
                                                        <!-- Lista de productos(Menciona el producto, la presentación, y precio) -->
                                                        <select name="txtPresentacion" id="esta3" style="margin-bottom: 20px;">
                                                            <option selected="true">Selecciona un producto</option><!-- opcion seleccionada por defecto -->
                                                            <%
                                                                    for (Presentacion pre : pr) {//For que extrae los datos de presentacion para mostrar los datos
%>

                                                            <option value="<%=  pre.idPresentacion%>" class="<%=  pre.precioVenta%>">
                                                                <%= pdao.OneProduct(pre.idProducto) + " "
                                                                        +//Nombre del producto
                                                                        prdao.OneEmpaque(pre.idEmpaque) + " "
                                                                        +//Nombre del empaque
                                                                        prdao.OneUnidad(pre.idEmpaque)
                                                                        +//Tamaño del empaque
                                                                        " $" + pre.precioVenta /*Precio de venta*/%>
                                                            </option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </td>
                                                    <!-- Cantidad deseada del producto seleccionado -->
                                                    <td style="width: 20%; padding-top: 5px;"><input type="number" name="cantidad" id="cantidad" placeholder="Cantidad" required=""/></td>
                                                    <!-- Se muestra el subtotal de acuerdo a la cantidad y producto seleccionados-->
                                                    <td style="width: 20%;"><input type="text" name="Subtotal" id="Subtotal" placeholder="Subtotal" readonly="true" style="background-color: #b3ecff"/></td>
                                                    <!-- Se muestran los datos del producto seleccionado -->
                                                    <td style="width: 20%;"><input type="text" name="Presentacion" id="Presentacion" placeholder="Presentación" readonly="true" style="background-color: #b3ecff"/></td>
<!-- Cuando el usuario esté de acuerdo presionará este botón para agregar los datos a la tabla del carrito -->
                                                    <td style="width: 20%; padding-top: 5px;">
                                                        <button type="submit" id="Enviar"><span class="glyphicon glyphicon-ok"></span></button>
                                                    </td>   
                                                </tr>
                                            </tbody>
                                        </table><!-- Aqui termina la tabla para agregar productos -->
<br/>
                                        <!-- Tabla Carrito, Aqui se muestran los productos que va agregando el usuario -->
                                        <table id="productoslist">
                                            <thead><!-- Encabezado, muestra los titulos de la tabla -->
                                                <tr>
                                                    <th>Producto</th>
                                                    <th>Cantidad</th>
                                                    <th>Presentación</th>
                                                    <th>Subtotal</th>
                                                    <th>Acciones</th>
                                                </tr>
                                            </thead>
                                            <!-- Cuerpo de la tabla. 
                                            El id permite ir agregando filas a través de la función append mediante ajax-->
                                            <tbody id="detallesVenta">
                                                <!-- Al principio muestra que no hay productos agregados -->
                                                <!-- Posteriormente se llena mediante ajax-->
                                                <tr>
                                                    <td style="width: 20%"> No</td>
                                                    <td style="width: 20%"> Hay </td>
                                                    <td style="width: 20%">Productos</td>
                                                    <td style="width: 20%">Agregados</td>
                                                    <td style="width: 20%">
                                                        <!-- <button type="button">
                                                            <span  class='glyphicon glyphicon-ban-circle'></span>
                                                        </button> -->
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table><!-- Termina la tabla Carrito-->
                                    </div><!-- Termina el cuerpo del Modal -->
                                    <!-- Parte inferior del Modal-->
                                    <div class="modal-footer">
                                        <!-- Botones para salir y guardar cambios-->
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                        <button type="button" class="btn btn-primary">Siguiente</button>
                                    </div>
                                </div>
                            </div>
                        </div><!-- Fin del Modal-->
                    </td>
                </tr>
                <!-- Cuarta Fila de datos-->
                <tr style="border-top: solid red;">
                    <!-- Comentarios-->
                    <td colspan="3"><textarea type="text" placeholder="Comentarios" name="txtComentarios"  style="width: 91.8%; margin-top: 5px;" required></textarea></td>
                    <!-- Datos Finales-->
                    <td colspan="2" ALIGN="right">
                        <!-- Total a pagar calculado automáticamente con los datos agregados -->
                        <label style="color: grey;font-weight: lighter;width: 37%;padding-top: 5px;">Total a Pagar:</label>
                        <input name="Total" id="Total" placeholder="Total"  readonly="true" style="width: 60%; background-color: #b3ecff;margin-top: 5px;"/>
                        <br/>
                        <!-- Total recibido -->
                        <label style="color: grey;font-weight: lighter;width: 37%;">Recibí:</label>
                        <input name="Cantidad Pagada" id="CantidadP" placeholder="Cantidad Pagada"  style="width: 60%"/>
                        <br/>
                        <!-- Modo de pago realizado -->
                        <label style="color: grey;font-weight: lighter;width: 40%;">Modo de pago:</label>
                        <!-- Deberían cargarse de la base de datos pero por ahora sólo son pruebas -->
                        <select name="txtModoPago">
                            <option value="1">Efectivo</option>
                            <option value="2">Credito</option>
                        </select>
                    </td>
                </tr>
                <!-- Quinta Fila de datos -->
                <tr ALIGN="right">      
                    <!-- Botón que envía los datos del formulario -->
                    <!-- Aquí se encuentran los valores hidden que serán enviados por el formulario
                    (conservan el valor para posteriormente ser enviados y recibidos en controlador)
                    -->
                    <td colspan="5">
                        <div id="esta2"></div>
                        <form action="Controlador?accion=VentasI" method="POST" name="formInsertar" id="formInsertar" ><!-- Formulario con datos que serán enviados -->
                            <%
                                int emp = edao.OneEmpleado(sesion.getUserName());
                                System.out.println(emp + " " + edao.OneSucursal(emp));//reemplazar esto por input hidden para enviar los dos valores
                            %><input type="hidden" id="valores" name="valores" value="400/213/124/121/" style="background-color: #b3ecff" readonly="true"/> 
                            <!-- Este input Almacena el id de la sucursal que corresponde al empleado que se ha logeado -->
                            <input type="hidden" id="suc" name="suc" value="<%= edao.OneSucursal(emp)%>"  readonly="true"/> 
                            <!-- Este input Almacena el id del empleado que se ha logeado -->
                            <input type="hidden" id="empl" name="empl" value="<%= emp%>"  readonly="true"/> 
                            <!-- Este input Almacena el precio de venta del producto seleccionado en el modal -->
                            <input type="hidden" id="estas" name="estas" style="background-color: #b3ecff" readonly="true"/> 

                            <button type="submit" style="background-color: #aa0bb0; color: #fff; font-weight: bold; border-radius: 0.33em;">
                                Procesar venta
                            </button>
                        </form>
                    </td>
                </tr>
        </table><!-- Termina la tabla que organiza el contenido -->

        <br/>
    </div><!-- Termina #divI -->


    <div style="margin-left: 180px; margin-top: 10px" id="divA">

        <form action="Controlador?accion=VentasU" method="POST" name="formActualizar" onsubmit="return validar(formActualizar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 4.5%" ><label>Fecha:</label></td>
                        <td style="width: 25%"><input type="date" name="txtFecha" id="Fecha" style="width: 90%;" required/></td>
                        <td style="width: 25%"><input type="number" placeholder="Total a Pagar" name="txtTotalPagar" id="TotalPagar" step="0.01" style="width: 90%;" required /></td>
                        <td style="width: 25%"><input type="number" placeholder="Cantidad Pagada" name="txtCantPagada" id="CantPagada" style="width: 90%;" step="0.01" required/></td>

                    </tr>
                    <tr>
                        <td colspan="2"><textarea type="text" placeholder="Comentarios" name="txtComentarios" id="Comentarios" style="width: 91.8%; margin-top: 5px;" required></textarea></td>
                        <td>
                            <div>
                                <label>&nbsp &nbsp &nbsp &nbsp Estatus</label> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp  
                                <label>&nbsp &nbsp &nbsp &nbsp Tipo</label><br/>
                                <input type="radio" id="ActivoA" name="txtEstatus" value="A" required>
                                <label for="Activo">Activo</label>
                                <input type="radio" id="InactivoA" name="txtEstatus" value="I">
                                <label for="Inactivo">Inactivo</label>
                                &nbsp &nbsp &nbsp &nbsp
                                <input type="radio" id="ProductoA" name="txtTipo" value="E" required>
                                <label for="Activo">Efectivo</label>
                                <input type="radio" id="OpcionA" name="txtTipo" value="C">
                                <label for="Inactivo">Crédito</label> </div>

                        </td>
                        <td id="CD">

                        </td>
                    </tr>
                    <tr>

                        <td colspan="3">
                            <input type="hidden" name="idCl" id="idCl"/>
                        </td>
                        <td id="CD2" colspan="2">

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
                    <th  width='1%' style='border: 0;' scope='col'>#Venta</th>
                    <th  width='10%' style='border: 0;' scope='col'>Fecha</th>
                    <th  width='10%' style='border: 0;' scope='col'>Total a Pagar</th>
                    <th  width='10%' style='border: 0;' scope='col'>Cantidad Pagada</th>
                    <th  width='25%' style='border: 0;' scope='col'>Comentarios</th>
                    <th  width='10%' style='border: 0;' scope='col'>Estatus</th>
                    <th  width='10%' style='border: 0;' scope='col'>Tipo</th>
                    <th  width='10%' style='border: 0;' scope='col'>Cliente</th>
                    <th  width='10%' style='border: 0;' scope='col'>Sucursal</th>
                    <th  width='10%' style='border: 0;' scope='col'>Empleado</th>
                    <th  width='10%' style='border: 0;' scope='col'>Acciones</th> 
                </tr>
            </thead>
            <tbody>
                <%
                    int idc;
                    //datos = dao.consultar();
                    for (Ventas v : datos) {
                %>
                <tr>
                    <td><%= idc = v.getIdVenta()%></td>
                    <td><%= v.getFecha()%></td>
                    <td><%= v.getTotalPagar()%></td>
                    <td><%= v.getCantPagada()%></td>
                    <td><%= v.getComentarios()%></td>
                    <%if (v.getEstatus() == 'A') { %>
                    <td>Activo</td>
                    <%    } else {                    %>
                    <td>Inactivo</td>
                    <%    }
                        if (v.getTipo() == 'E') { %>
                    <td>Efectivo</td>
                    <%    } else {                    %>
                    <td>Crédito</td>
                    <%    }
                        c = cdao.consultarId(v.getIdCliente());
                        s = sdao.consultarId(v.getIdSucursal());
                        e = edao.consultarId(v.getIdEmpleado());%>
                    <td><%= c.get(0).getNombre()%></td>
                    <td><%= s.get(0).getNombre()%></td>
                    <td><%= e.get(0).getNombre()%></td>
                    <%if (v.getEstatus() == 'A') {%>

                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                        <form action="Controlador?accion=VentasD&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc" class="boton2">
                                <span  class='glyphicon glyphicon-ban-circle'></span></button>
                        </form></td>
                        <%    } else {%>
                    <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                        <form action="Controlador?accion=VentasR&id=<%= idc%>" method="POST">
                            <button type="submit" value='<%= idc%>' name="idc" class="boton2">
                                <span  class='glyphicon glyphicon-ok-circle'></span></button>
                        </form></td>
                        <% }%>   
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>   
    <script type="text/javascript" charset="utf8" 
    src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>   
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


    <!-- Optional theme <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script type="text/javascript">
            function validar(formulario) {
                var hoy = new Date();
                var dd = hoy.getDate();
                var mm = hoy.getMonth() + 1;
                var yyyy = hoy.getFullYear();
                var ano = parseInt(formulario.txtFecha.value.toString().substring(0, 4));
                var mes = parseInt(formulario.txtFecha.value.toString().substring(5, 7));
                var dia = parseInt(formulario.txtFecha.value.toString().substring(8, 10));
                var formatoNumero = /^[^a-zA-Z,\/\\:;_\-\^\{\[\"\!\|°¬#\$%&\(\)\=\?\'¡¿\}\]´¨\*\+\~`@]+$/;
                var t = false;

                if (ano <= yyyy) {
                    if (ano === yyyy) {
                        if (mes <= mm) {
                            if (dia > dd) {
                                alert("El dia ingresado se encuentra en una fecha posterior a la actual");
                                formulario.txtFecha.focus();
                                return false;
                            }
                        } else {
                            alert("El mes ingresado se encuentra en una fecha posterior a la actual");
                            formulario.txtFecha.focus();
                            return false;
                        }
                    }
                    if (formulario.txtTotalPagar.value.match(formatoNumero)) {
                        if (formulario.txtCantPagada.value.match(formatoNumero)) {
                            if (formulario.txtTotalPagar.value <= 0) {
                                alert("El total a pagar no puede ser menor ni igual a 0");
                                formulario.txtTotalPagar.focus();
                                return false;
                            }
                            if (formulario.txtCantPagada.value <= 0) {
                                alert("La cantidad pagada no puede ser menor ni igual a 0. Es necesario que se reciba un pago");
                                formulario.txtCantPagada.focus();
                                return false;
                            }
                            if (formulario.txtTotalPagar.value < formulario.txtCantPagada.value) {
                                alert("La cantidad pagada no puede ser mayor a la cantidad total a pagar.\n\
        *Revisa los decimales");
                                formulario.txtCantPagada.focus();
                                return false;
                            }
                            if (formulario.txtComentarios.value !== "") {
                                t = false;
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
                                        alert("Un valor del estatus ha sido modificado por el usuario, No se enviarán los datos.");
                                        return false;
                                    }
                                }

                                if (t === false) {
                                    alert("Debes selecionar el estatus de la venta");
                                    formulario.txtEstatus.focus();
                                    return false;
                                } else {
                                    t = false;
                                    tt = false;
                                    for (var i = 0; i < 2; i++)
                                    {
                                        if (formulario.txtTipo[i].checked === true)
                                        {
                                            t = true;
                                            break;
                                        }
                                    }
                                    for (var i = 0; i < 2; i++)
                                    {
                                        if (formulario.txtTipo[i].value !== "E" & formulario.txtTipo[i].value !== "C") {
                                            alert("Un valor del Tipo ha sido modificado por el usuario, No se enviarán los datos.");
                                            return false;
                                        }
                                    }
                                    if (t === false) {
                                        alert("Debes selecionar el tipo de venta");
                                        formulario.txtTipo.focus();
                                        return false;
                                    } else {
                                        if (isNaN(formulario.txtCliente.options[formulario.txtCliente.selectedIndex].value)) {
                                            alert("El valor asignado al cliente ha sido modificado por el usuario. No se enviará.");
                                            return false;
                                        } else {
                                            if (isNaN(formulario.txtSucursal.options[formulario.txtSucursal.selectedIndex].value)) {
                                                alert("El valor asignado a la sucursal ha sido modificado por el usuario. No se enviará.");
                                                return false;
                                            } else {
                                                if (isNaN(formulario.txtEmpleado.options[formulario.txtEmpleado.selectedIndex].value)) {
                                                    alert("El valor asignado al empleado ha sido modificado por el usuario. No se enviará.");
                                                    return false;
                                                } else {
                                                    alert("Datos enviados con éxito");
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                alert("Comenta algo que pueda ayudar a comprender la situación de la venta");
                                formulario.txtComentarios.focus();
                                return false;
                            }
                        } else {
                            alert("El valor total a pagar debe ser numérico.");
                            formulario.txtCantPagada.focus();
                            return false;
                        }
                    } else {
                        alert("El valor total a pagar debe ser numérico.");
                        formulario.txtTotalPagar.focus();
                        return false;
                    }
                } else {
                    alert("El año ingresado es posterior al año actual");
                    formulario.txtFecha.focus();
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
        $('#esta').hide();
        $('#esta2').hide();
        //$('#divI').hide();
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
                $('#txtF').val(hoyFecha());
                $('#divI').show();
                $('.boton').hide();
                $('.boton2').hide();
                $('#btnMostrarf').text('-');
                $('#btnMostrar').html("<span  class='glyphicon glyphicon-minus-sign'></span>");
            }
        });
        $('#formInsertar').submit(function () {
            $('#productoslist').html(

                    );
        });
        $('#cantidad').keyup(function () {
            if (isNaN($('#cantidad').val())) {
                $('#Subtotal').val(0);
            } else {

                $('#Subtotal').val($('#cantidad').val() * $('#estas').val());
            }
        });

        $('.boton').click(function () {

            //valores obtendra el dato del td por posciones [0]
            $('#btnMostrar').hide();
            $('.boton2').hide();
            $('#divI').hide();
            $('#divA').show();
            $('#Fecha').val($(this).parents("tr").find("td")[1].innerHTML);
            $('#TotalPagar').val($(this).parents("tr").find("td")[2].innerHTML);
            $('#CantPagada').val($(this).parents("tr").find("td")[3].innerHTML);
            $('#Comentarios').val($(this).parents("tr").find("td")[4].innerHTML);
            if ($(this).parents("tr").find("td")[5].innerHTML === 'Activo') {
                $('#ActivoA').prop("checked", true);
            } else {
                $('#InactivoA').prop("checked", true);
            }
            if ($(this).parents("tr").find("td")[6].innerHTML === 'Efectivo') {
                $('#ProductoA').prop("checked", true);
            } else {
                $('#OpcionA').prop("checked", true);
            }

            var valor = $(this).parents("tr").find("td")[7].innerHTML;
            //console.log(valor);
            $('#CD').html("<label style='color: grey;font-weight: lighter;'>Cliente</label>" +
                    "<select name='txtCliente'>" +
    <%
        for (Clientes cl : c) {
            //String Ciudad = city.OneCity(cl.getIdCiudad());
%>
            "<option value='<%= cl.getIdCliente()%>'><%= cl.getNombre()%></option>" +
    <%
        }
    %>
            "</select>");
            $('#' + valor).attr('selected', 'selected').change();

            var valor = $(this).parents("tr").find("td")[8].innerHTML;
            //console.log(valor);
            $('#CD2').html("<label style='color: grey;font-weight: lighter;'>Sucursal</label>" +
                    "<select name='txtSucursal'>" +
    <%
        for (Sucursal su : s) {
            //String Ciudad = city.OneCity(cl.getIdCiudad());

    %>
            "<option value='<%= su.getIdSucursal()%>'><%= su.getNombre()%></option>" +
    <%
        }
    %>
            "</select>");
            $('#CD2').append("<label style='color: grey;font-weight: lighter;'>Empleado</label>" +
                    "<select name='txtEmpleado'>" +
    <%
        for (Empleados em : e) {
            //String Ciudad = city.OneCity(cl.getIdCiudad());

    %>
            "<option value='<%= em.getIdEmpleado()%>'><%= em.getNombre()%></option>" +
    <%
        }
    %>
            "</select>");

            $('#' + valor).attr('selected', 'selected').change();
            var valor = $(this).parents("tr").find("td")[0].innerHTML;
            $('#idCl').val(valor);
            $('#idCl').hide();
            //console.log($('#idCl').val());
            $('#nombre').focus();
        });

        $('#Cancel').click(function () {
            $('#divA').hide();
            $('#divI').hide();
            $('.boton2').show();
            $('#btnMostrar').show();
        });
        $('#sel').click(function () {
            $('#esta').show();
            $('#esta2').show();
            $('#sel').hide();
        });

        $("#esta2").change(function () {
            //alert($('#esta3').val());
            alert($("#esta3 option:selected").attr('label'));
            //alert($('#esta3').val());
            //alert(select_text = $("#esta3 option:selected").text());
            select_text = $("#esta3 option:selected").text();
            $('#Presentacion').val(select_text);
            $('#estas').val($("#esta3 option:selected").attr('class'));
        });

        $('#customers').DataTable({
            "iDisplayLength": 2,
            "aLengthMenu": [[2, 5, 10, -1], [2, 5, 10, "All"]],
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
        $('#productoslist').DataTable({
            "iDisplayLength": 2,
            "aLengthMenu": [[2, 5, 10, -1], [2, 5, 10, "All"]],
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