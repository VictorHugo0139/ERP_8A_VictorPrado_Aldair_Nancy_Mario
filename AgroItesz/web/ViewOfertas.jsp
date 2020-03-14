<%@page import="Modelo.datos.OfertasDAO"%>
<%@page import="java.util.*" %>
<%@page import="Modelo.Ofertas" %>
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
    <title>Edición de Ofertas</title>
</head>
<%
    OfertasDAO dao= new OfertasDAO();
    List<Ofertas> datos = new ArrayList<>();
%>
<body style="background-color: #dfd7f5;">
    <header>
        <nav>
            <ul>
                <li>
                    <a>Ofertas</a>
                </li>
                <li class="busqueda">

                    <button style="width: 20%; background-color: #15b332; color: #fff; font-weight: bold;" class="busqueda">
                        <img src="Images/busqueda.jpg" alt="buscar" style="width: 10%; height: 10%;">
                        Buscar
                    </button>
                    <input type="text" name="busqueda" id="busqueda" class="busqueda" style="width: 30%;">
                </li>
            </ul>
        </nav>
    </header>
    <div style="margin-left: 180px; margin-top: 10px">
        <button style="width: 20%; background-color: #aa0bb0; color: #fff; font-weight: bold; border-radius: 0.33em;">
            Agregar
        </button>
    </div>
    <div style="margin-left: 180px; margin-top: 5px; border: 1px solid #aa0bb0; height: 400px; width: 1100px;">
        <table width='100%' border='0' cellpadding='0' id='customers' >
            <thead>
                <tr>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>idOferta</th>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>Nombres</th>
                     <th id='tde' width='15%' style='border: 0;' scope='col'>Descripcion</th>
                     <th id='tde' width='15%' style='border: 0;' scope='col'>PorDescuento</th>
                     <th id='tde' width='15%' style='border: 0;' scope='col'>FechaInicio</th>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>FechaFin</th>
                     <th id='tde' width='20%' style='border: 0;' scope='col'>CantMinProducto</th>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>Estatus</th>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>idProducto</th>
                     <th id='tde' width='15%' style='border: 0;' scope='col'>Consultar</th>
                     <th id='tde' width='10%' style='border: 0;' scope='col'>Editar </th>                                        
                     <th id='tde' width='15%' style='border: 0;' scope='col'>Eliminar</th>
                </tr>
            </thead>
            <%
              // datos =  dao.consultar();
               for(Ofertas ol : datos){
               
            %>
            <tbody>
                <tr>
                    <th><%= ol.getIdOfertas()%></th>
                    <th><%= ol.getDescripcion()%></th>
                    <th><%= ol.getPorDescuento()%></th>
                    <th><%= ol.getFechaInicio()%></th>
                    <th><%= ol.getFechaFin()%></th>
                    <th><%= ol.getCantMinProducto()%></th>
                    <th><%= ol.getEstatus()%></th>
                    <th><%= ol.getIdProducto()%></th>
                    
                    
                </tr>
                <%   
                    }
                %>
            </tbody>
        </table>
    </div>
</body>

</html>
