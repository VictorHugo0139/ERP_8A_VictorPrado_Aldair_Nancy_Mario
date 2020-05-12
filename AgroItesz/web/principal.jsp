
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/LoginCss.css" rel="stylesheet" type="text/css"/> 
        <style>
            html {
                min-height: 100%;
                position: relative;
            }
            body {
                margin: 0;
                margin-bottom: 40px;
            }
            footer {
                position: absolute;
                bottom: 0;
                width: 100%;
                color: white;
            }
            .Fecha, .AT{
                font-size: medium;
                margin-top: 0%;
                color: #1f8f27;
                transition: font-size .7s;
            }
            .Fecha:hover,.AT:hover{
                font-size: large;
                color: #22f530;
            }
            #menu > li >a{
                text-decoration: none;
                color: #1f8f27;
                font-size: medium;
                transition: font-size .8s;
            }
            #menu > li >a:hover{
                text-decoration: none;
                color: #22f530;
                font-size: 13.4pt;                
            }
            .submenu{
                list-style: none;
                position: absolute;
                background-color: #121214;
                visibility:  hidden;
                opacity: 0;
                transition: opacity 1.5s;
            }
            .submenu li{
                margin-left: 0%;
                transition: margin-left 1.5s;
            }
            .submenu > li >a{
                text-decoration: none;
                color: slategrey;
            }
            #menu li:hover .submenu{
                visibility:  visible;
                opacity: 1;
            }
            
            .submenu li:hover{
                width: 100%;
                margin-left: -15%;
                background-color:  #1f8f27;
            }
            .submenu li a:hover{
                color: white;
            }
        </style>
        <link rel="icon" type="image/x-icon" href="Images/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Agroitesz.Soft</title>
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
    <a href="css/fonts-googleappis.txt"></a>
</head>
<body style="background: no-repeat;">
    <nav class="navbar navbar-inverse" style="background: #121214;">
        <div class="container-fluid">
            <div class="navbar-header">
                <a style="text-decoration: none;" href="principal.jsp"><img src="Images/pla1.png" height="50" width="80" /></a>
                <a style="text-decoration: none;" href="principal.jsp" class="AT"  ><b > Agroitesz </b></a>
            </div>
            
            <div style="margin-left: 0px;" class="Fecha">
                <script type="text/javascript">

                            var today = new Date();

                            var m = today.getMonth() + 1;

                            var mes = (m < 10) ? '0' + m : m;

                            document.write('Fecha: ' + today.getDate(), '/' + mes, '/' + today.getFullYear() + '&nbsp - &nbsp');

                        </script>
             <script type="text/javascript">

                    function startTime() {

                        today = new Date();
                        h = today.getHours();
                        m = today.getMinutes();
                        s = today.getSeconds();
                        m = checkTime(m);
                        s = checkTime(s);
                        document.getElementById('reloj').innerHTML = h + ":" + m + ":" + s;
                        t = setTimeout('startTime()', 500);
                    }

                    function checkTime(i)

                    {
                        if (i < 10) {
                            i = "0" + i;
                        }
                        return i;
                    }

                    window.onload = function () {
                        startTime();
                    };
                            </script>
            
                <a><span class="glyphicon" id="reloj" ></span></a>
            </div>
            <ul class="nav navbar-right" id="menu">
                <li class="nav-item"><a href="#">&nbsp &nbsp Bienvenido(a): <span class="glyphicon glyphicon-user"></span>&nbsp ${nom}</a>
                    <ul class="submenu">
                        <li style="margin-top: 20px;"><a href="#" id="cambiarUsuario"><span class="glyphicon glyphicon-log-in"></span>&nbsp Cambiar de Usuario </a></li>
                        <li style="margin-top: 10px"><a id="cerrarSesion" href="Controlador?accion=Salir"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp Cerrar Sesión</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>  

    <div id="Cambio" style="height: 803px">
        <form id="form1" method="POST" action="Controlador"> 

            <div class="wrapper fadeInDown">
                <div id="formContent">
                    <!-- Img <div > -->

                    <a id="Regresa" href="#" style="margin-left: -90%;"><img src="Images/arrow-left.png" height="5%" width="5%" /></a>

                    <div class="fadeIn first">
                        <img src="Images/pla1.png" height="20%" width="40%" id="icon" alt="Inicio de sesión" />

                    </div>

                    <input type="text" id="login" class="fadeIn second" required name="Usuario" placeholder="Usuario" >
                    <input type="Password" id="password" class="fadeIn third" required name="Password" placeholder="Contraseña">
                    <input type="submit" class="fadeIn fourth"   value="Cambio" name="accion">  

                    <br/>     
                    <footer>
                        <hr>

                    </footer>
                </div>
            </div>           
        </form>
    </div>        

    <div class="container" style="margin-left: 20px">
        <div class="row align-items-start">
            <a href="Controlador?accion=Cultivos" style="text-decoration: none; color: #191c19;">
                <div class="col">
                    <div class="card" style="width: 10rem; height: 13rem;">
                        <img class="card-img-top" style="width: 9rem; height: 9rem; margin-left: 5px;margin-bottom: 0;margin-top: 5px;" src="Images/Cultivos2.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title"  style="margin-top: 10px;">CULTIVOS</h5>
                        </div>
                    </div>
                </div>
            </a> 
            <a href="Controlador?accion=Clientes" style="text-decoration: none; color: #191c19;">
                <div class="col" >
                    <div class="card" style="width: 10rem; height: 13rem;">
                        <img class="card-img-top" src="Images/clientes2.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title" >CLIENTES</h5>
                        </div>
                    </div>
                </div>
            </a>  
            <a href="Controlador?accion=Transportes" style="text-decoration: none; color: #191c19;">
                <div class="col" >
                    <div class="card" style="width: 10rem; height: 13rem;">
                        <img class="card-img-top" src="Images/Trasporte.png" style="width: 10.2rem; height: 10rem; margin-left: -3px;" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title" style="margin-right: -20px; margin-left: -17px; margin-top: 0px;margin-bottom: 5px;">
                                TRANSPORTES</h5>
                        </div>
                    </div>
                </div>
                <br/>
            </a>
            <a href="Controlador?accion=Socios" style="text-decoration: none; color: #191c19;">
                <div class="col" >
                    <div class="card" style="width: 10rem; height: 13rem;">
                        <img class="card-img-top" src="Images/Socios2.png" style="width: 9rem; height: 9rem;margin-left: 5px;margin-bottom: 0;margin-top: 5px;" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title" style="margin-right: -10px; margin-left: -10px;margin-top: 10px;">ASOCIACION</h5>
                        </div>
                    </div>
                </div>
            </a> 
            <a href="Controlador?accion=Ofertas" style="text-decoration: none; color: #191c19;">
                <div class="col" >
                    <div class="card" style="width: 10rem; height: 13rem;">
                        <img class="card-img-top" src="Images/Ofertas3.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title" >OFERTAS</h5>
                        </div>
                    </div>
                </div>
            </a> 
            <a href="Controlador?accion=Miembros" style="text-decoration: none; color: #191c19;">
                <div class="col" >
                    <div class="card" style="width: 10rem; height: 13rem;">
                        <img class="card-img-top" src="Images/MiembrosA.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title" >MIEMBROS</h5>
                        </div>
                    </div>
                </div>
            </a> 
        </div>
        <div class="row align-items-center">
            <a href="Controlador?accion=Ventas" style="text-decoration: none; color: #191c19;">
                <div class="col" >
                    <div class="card" style="width: 10rem; height: 13rem;">
                        <img class="card-img-top" src="Images/IconoVentas3.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title" >VENTAS</h5>
                        </div>
                    </div>
                </div>
            </a>
            <a href="Controlador?accion=Envios" style="text-decoration: none; color: #191c19;">
                <div class="col" >
                    <div class="card" style="width: 10rem; height: 13rem;">
                        <img class="card-img-top" src="Images/Envio.png" style="width: 90%; height: 65%; margin-left: 9px;margin-bottom: 0;margin-top: 10px;" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title" style="margin-top: 10%;">ENVÍOS</h5>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <div class="row align-items-end">
            
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
                    $(document).ready(function () {
                        $('#Cambio').hide();
                        $('#cambiarUsuario').click(function () {
                            $('#Cambio').show();
                            $('#Opciones').hide();
                        });
                        $('#Regresa').click(function () {
                            $('#Cambio').hide();
                            $('#Opciones').show();
                        });


                    });
</script>  

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
