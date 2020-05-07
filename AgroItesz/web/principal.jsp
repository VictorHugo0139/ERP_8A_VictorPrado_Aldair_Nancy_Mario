
<!DOCTYPE html>
<html>
    <head>
        <link href="css/LoginCss.css" rel="stylesheet" type="text/css"/> 
        <style>
            #menu > li >a{
                text-decoration: none;
            }
            .submenu{
                list-style: none;
                position: absolute;
                background-color: #121214;
                visibility:  hidden;
                opacity: 0;
                transition: opacity 1.5s;
            }
            .submenu > li >a{
                text-decoration: none;
                color: slategrey;
            }
            #menu li:hover .submenu{
                visibility:  visible;
                opacity: 1;
            }
            .submenu li a:hover{
                color: white;
            }
        </style>
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
                <a class="" href="principal.jsp"><img src="Images/pla1.png" height="50" width="80" /><b class="titleMain"> Agroitesz </b></a>

            </div>

            <ul class="nav navbar-nav navbar-right" id="menu">
                <li><a href="#"><span class="glyphicon"></span>
                        <script type="text/javascript">

                            var today = new Date();

                            var m = today.getMonth() + 1;

                            var mes = (m < 10) ? '0' + m : m;

                            document.write('Fecha: ' + today.getDate(), '/' + mes, '/' + today.getFullYear());

                        </script></a></li>
                <li><a href="#"><span class="glyphicon" id="reloj" ><script type="text/javascript">

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
                            </script></span></a></li>
                <li><a href="#"> Bienvenido(a): <span class="glyphicon glyphicon-user"></span>&nbsp ${nom}</a>
                    <ul class="submenu">
                        <li><a href="#" id="cambiarUsuario"><span class="glyphicon glyphicon-log-in"></span>&nbsp Cambiar de Usuario </a></li>
                        <li><a id="cerrarSesion" href="Controlador?accion=Salir"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp Cerrar Sesión</a></li>
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
    <div id="Opciones" class="container" style="height: 803px">


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


    <script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
    <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
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
