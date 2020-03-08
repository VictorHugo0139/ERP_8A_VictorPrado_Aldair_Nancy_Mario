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
    <title>Edición de Cultivos</title>
</head>

<body style="background-color: #dfd7f5;">
    <header>
        <nav>
            <ul>
                <li>
                    <a>Cultivos</a>
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
    <div style="margin-left: 180px; margin-top: 5px; border: 1px solid #aa0bb0; height: 400px; width: 1000px;">

    </div>
</body>

</html>