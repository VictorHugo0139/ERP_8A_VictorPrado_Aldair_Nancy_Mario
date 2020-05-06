<%@page import="Modelo.datos.CultivosDAO"%>
<%@page import="java.util.*" %>
<%@page import="Modelo.Cultivos" %>
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
    <img src="Images/pla1.png" height="10%" width="10%" id="logo" alt="AgroItesz" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edición de Cultivos</title>
</head>
<%
    CultivosDAO dao= new CultivosDAO();
    List<Cultivos> datos = (List<Cultivos>)request.getAttribute("datosCl");
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
                    <!--Aqui se comienza a usar los filtros -->
                    <form action="Controlador?accion=CultivosS" method="POST" >
                        <input type="text" placeholder="búsqueda" name="busqueda" style="color: black;">
                        <label>En base a:</label>
                        <select name="campo" style="color: black;">
                            <option value="idCultivo">#Cultivo</option>
                            <option value="nombre">Nombre</option>
                            <option value="costoAsesoria">costoAsesoria</option>
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
        <form action="Controlador?accion=CultivosI" method="POST" name="formInsertar" onsubmit="return Validar(formInsertar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtNombre" style="width: 90%;" required/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="costoAsesoria" name="txtcostoAsesoria" style="width: 90%;" required /></td>
                    </tr>
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
<!--Aqui se comienza a Actualizar -->
    
    <div style="margin-left: 180px; margin-top: 10px" id="divA">
        <form action="Controlador?accion=CultivosU" method="POST" name="formActualizar" onsubmit="return ValidarA(formActualizar);">
            <table border="0" style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="Nombre" name="txtNombre" id='nombre'  style="width: 90%;" required/></td>
                        <td style="width: 25%" colspan="2"><input type="text" placeholder="costoAsesoria" name="txtcostoAsesoria" id='costoAsesoria'  style="width: 90%;" required /></td>-
                    </tr>
                    <tr>
                        <td><label>Estatus:</label>
                            <input type="radio" id="ActivoA" name="txtEstatusA" value="A" required>
                            <label for="Activo">Activo</label>
                            <input type="radio" id="InactivoA" name="txtEstatusA" value="I">
                            <label for="Inactivo">Inactivo</label>
                        </td>
                        <td><input type="number" name="idCul" id="idCul"/> </td>
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
    <div>
        <table width='100%' border='0' cellpadding='0' id='customers' >
            <thead>
                <tr>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>idCultivo</th>
                     <th id='tde' width='25%' style='border: 0;' scope='col'>Nombre</th>
                     <th id='tde' width='20%' style='border: 0;' scope='col'>costoAseesoria</th>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>Estatus</th>
                     <th  width='10%' style='border: 0;' scope='col'>Acciones</th>
                </tr>
            </thead>
            <%
                int idCul;
               //datos =  dao.consultar();
               for(Cultivos cl : datos){
               
            %>
            <tbody>
                <tr>
                    <th><%= idCul = cl.getIdCultivo()%></th>
                    <th><%= cl.getNombre()%></th>
                    <th><%= cl.getCostoAsesoria()%></th>
                </tr>
                        <%
                            if (cl.getEstado() == 'A') {
                        %>
                        <td>Activo</td> 
                        <td><button class="boton"><span  class='glyphicon glyphicon-edit'></span></button>
                            <form action="Controlador?accion=CultivosD&id=<%= idCul%>" method="POST">
                                <button type="submit" value='<%= idCul%>' name="idc" class="boton2">
                                    <span  class='glyphicon glyphicon-ban-circle'></span></button>
                            </form></td>
                            <%    } else {%>
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
        
 

</body>

</html>