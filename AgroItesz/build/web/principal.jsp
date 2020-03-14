
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Agroitesz.Soft</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
    <a href="css/fonts-googleappis.txt"></a>
</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="" href="#"><img src="Images/pla1.png" height="50" width="80" /><b class="titleMain"> Agroitesz </b></a>

            </div>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon"></span> Bienvenido(a): ${nom}</a></li>
                <li><a  href="Controlador?accion=Salir"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesión</a></li>
            </ul>
        </div>
    </nav>  
    <div class="container" style="height: 803px">


        <div class="row" id="admin" >               
            <div class="col-md-4 col-sm-6">
                <div class="box-for-img text-center">
                    <a href="Controlador?accion=Cultivos" class="boton_2 img1 img-responsive" style="height: 230px">
                        cultivos<a href="Images/cultivos.png"></a> 
                    </a>

                </div>
            </div>     

            <div class="col-md-4 col-sm-6">
                <div class="box-for-img text-center">
                    <a href="Controlador?accion=Clientes" class="boton_2 img2 img-responsive" style="height: 230px">
                        Clientes<a href="Images/clientes.png"></a>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="box-for-img text-center">
                    <a href="Controlador?accion=Transportes" class="boton_2 img3 img-responsive" style="height: 230px">
                        Unidades de trasporte<a href="Images/Trasporte.png"></a>
                    </a>
                </div>
            </div>
        </div>
        <div class="row"  id="admin1">               
            <div class="col-md-4 col-sm-6">
                <div class="box-for-img text-center">
                    <a href="Controlador?accion=Socios" class="boton_2 img4 img-responsive" style="height: 230px">
                        Asociaciones<a href="Images/socios.png"></a>
                    </a>
                </div>
            </div>

            <div class="col-md-4 col-sm-6">
                <div class="box-for-img text-center">
                    <a href="Controlador?accion=Ofertas" class="boton_2 img5 img-responsive" style="height: 230px">
                        Ofertas<a href="Images/Ofertas.png"></a>
                    </a>
                </div>
            </div>
            
            <div class="col-md-4 col-sm-6">
                <div class="box-for-img text-center">
                    <a href="Controlador?accion=Miembros" class="boton_2 img6 img-responsive" style="height: 230px">
                        Miembros<a href="Images/Miembros.png"></a>
                    </a>
                </div>
            </div>
            
        </div>

    </div>
                


</body>


<footer class="last-section">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 text-center">

                <p>© 2020 AGROITESZ</p>

            </div>
        </div>
    </div>
</footer>
</html>
