<%-- 
    Document   : index
    Created on : 16-feb-2020, 14:56:56
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
        <title>Agroitesz - Inicio de sesión</title>
        <link href="css/LoginCss.css" rel="stylesheet" type="text/css"/>  
    </head>
    <body>
         <form id="form1" method="POST" action="LoginServlet"> 
        
            <div class="wrapper fadeInDown">
                <div id="formContent">
                    <!-- Img  -->
                    <div class="fadeIn first">
                        <img src="Images/pla1.png" height="200px" width="40px" id="icon" alt="Inicio de sesión" />
                        <br>
                    </div>

                    <input type="text" id="login" class="fadeIn second" required name="Usuario" placeholder="Usuario" >
                    <input type="Password" id="password" class="fadeIn third" required name="Password" placeholder="Contraseña">
                    <input type="submit" class="fadeIn fourth"  onClick="return validarfor();" value="Iniciar sesión">  
                    
                        <br/>                        
                        <!-- <strong class="ErrorCSS" href="#">Error<strong> -->
                    <!-- Remind Password -->
                    <div id="formFooter">
                        <a class="underlineHover" href="#">Olvide mi contraseña</a>
                    </div>
                    <footer>
                        <hr>
                       
                    </footer>
                </div>
            </div>           
        </form>
    </body>
</html>
