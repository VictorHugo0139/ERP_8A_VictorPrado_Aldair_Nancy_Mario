/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = Limpiar;
function  Limpiar() {

}

function validarfor() {
    var first_name = document.getElementById("first_name").value;
    var last_name = document.getElementById("last_name").value;
    var birthday = document.getElementById("birthday").value;
    var gender = document.getElementById("gender").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var user = document.getElementById("user").value;
    var password = document.getElementById("password").value;
    var subject = document.getElementById("subject").value;
    var Permisos = document.getElementById("Permisos").value;
    var confirpass = document.getElementById("confpassword").value;

    if (first_name === "" || last_name === "" || birthday === "" || gender === "" || email === ""
            || phone === "" || user === "" || password === "" || subject === "" || Permisos === "")
    {
        alert("Todos los campos son obligatorios.");
        return false;
    }

    var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;
    console.log("user:" + user);
    if (!ren.exec(user)) {
        alert("Usuario, no se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(password)) {
        alert("Contraseña, no se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (password !== confirpass) {
        alert('La contraseña no coincide con la confirmación.');
        return false;
    }
}
function validaNumericos(event) {
    if (event.charCode >= 48 && event.charCode <= 57) {
        return true;
    }
    return false;
}
function validarDelete() {

    var id = document.getElementById("id").value;
    var password = document.getElementById("pass").value;

    if (id === "" || password === "")
    {
        alert("Todos los campos son obligatorios.");
        return false;
    }
    var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;
    //console.log("id:" + id);
    if (!ren.exec(id)) {
        alert("ID usuario, no se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    var renum = /^([0-9]*)$/;
    if (!renum.exec(id)) {
        alert("ID usuario, solo se permiten números");
        return false;
    }
    if (!ren.exec(password)) {
        alert("Contraseña, no se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
}
function validarSectores() {

    var nombresector = document.getElementById("nombresector").value;
    var tipoplanta = document.getElementById("tipoplanta").value;
    var direcion = document.getElementById("direcion").value;
    var nombretierra = document.getElementById("nombretierra").value;
    var sector = document.getElementById("sector").value;
    var observaciones = document.getElementById("observaciones").value;

    if (nombresector === "" || tipoplanta === "" || direcion === "" || nombretierra === "" || sector === "" || observaciones === "")
    {
        alert("Todos los campos son obligatorios.");
        return false;
    }
    var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;
    //console.log("id:" + id);
    if (!ren.exec(nombresector)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    var renum = /^([0-9]*)$/;
    if (!renum.exec(sector)) {
        alert("Sectores, solo se permiten números");
        return false;
    }
    if (!ren.exec(tipoplanta)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(direcion)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(nombretierra)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(observaciones)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
}
function validarPlagas() {

    var subject = document.getElementById("subject").value;
    var Enfermedad = document.getElementById("Enfermedad").value;
    var tipoplaga = document.getElementById("tipo-plaga").value;
    var plaga = document.getElementsByName("plaga").value;
    var Defisiencias = document.getElementById("Defisiencias").value;
    var observaciones = document.getElementById("Observaciones").value;

    if (subject === "" || Enfermedad === "" || tipoplaga === "" || plaga === "" || Defisiencias === "" || observaciones === "")
    {
        alert("Todos los campos son obligatorios.");
        return false;
    }
    var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;

    if (!ren.exec(Defisiencias)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(Enfermedad)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(tipoplaga)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(plaga)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(observaciones)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
}
function validarTierras() {

    var nameTierra = document.getElementById("nameTierra").value;
    var locacion = document.getElementById("locacion").value;
    var ubicacion = document.getElementById("ubicacion").value;
    var superficie = document.getElementsByName("superficie").value;
    var fecha = document.getElementById("fecha").value;
    var Sectores = document.getElementById("Sectores").value;
    var observaciones = document.getElementById("Observaciones").value;
    if (nameTierra === "" || locacion === "" || ubicacion === "" || superficie === "" || fecha === "" || Sectores === "" || observaciones === "")
    {
        alert("Todos los campos son obligatorios.");
        return false;
    }
    var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;

    if (!ren.exec(nameTierra)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(locacion)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(ubicacion)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(superficie)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(observaciones)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    var renum = /^([0-9]*)$/;
    if (!renum.exec(Sectores)) {
        alert("Número de Sectores, solo se permiten números");
        return false;
    }
}
function validarFumigaciones() {

    var infoGeneral = document.getElementById("infoGeneral").value;
    var first_name = document.getElementById("first_name").value;
    var last_name = document.getElementById("last_name").value;
    var NombreTierra = document.getElementsByName("NombreTierra").value;
    var catidadPersonas = document.getElementById("catidadPersonas").value;
    var business = document.getElementById("business").value;
    var street = document.getElementById("street").value;
    var nombresectorfumigado = document.getElementById("nombresectorfumigado").value;
    var additional = document.getElementById("additional").value;
    var tipoMaquinaria = document.getElementById("tipoMaquinaria").value;
    var Tipoproducto = document.getElementById("Tipoproducto").value;
    var nombreProducto = document.getElementById("nombreProducto").value;
    var your_email = document.getElementById("your_email").value;


    if (infoGeneral === "" || first_name === "" || last_name === "" || NombreTierra === "" || catidadPersonas === "" || business === "" || street === ""
            || nombresectorfumigado === "" || additional === "" || tipoMaquinaria === "" || Tipoproducto === "" || nombreProducto === "" || your_email === "")
    {
        alert("Todos los campos son obligatorios.");
        return false;
    }
    var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;

    var renum = /^([0-9]*)$/;
    if (!renum.exec(catidadPersonas)) {
        alert("Cantidad de Personal Utilizado, solo se permiten números");
        return false;
    }
    if (!renum.exec(additional)) {
        alert("Cat de Sectores Fumigados, solo se permiten números");
        return false;
    }
    if (!ren.exec(first_name)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(last_name)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    /*
     var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;
     
     if (!ren.exec(nameTierra)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     if (!ren.exec(locacion)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     if (!ren.exec(ubicacion)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     if (!ren.exec(superficie)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     if (!ren.exec(observaciones)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     var renum = /^([0-9]*)$/;
     if (!renum.exec(Sectores)) {
     alert("Número de Sectores, solo se permiten números");
     return false;
     }*/
}
function validarMonitoreo() {

    var PuestoEmpleado = document.getElementById("PuestoEmpleado").value;
    var first_name = document.getElementById("first_name").value;
    var last_name = document.getElementById("last_name").value;
    var company = document.getElementsByName("company").value;
    var street = document.getElementById("street").value;
    var NombreSector = document.getElementById("NombreSector").value;
    var NombrePlaga = document.getElementById("NombrePlaga").value;
    var TipoPlaga = document.getElementById("TipoPlaga").value;
    var TipoEnfermedad = document.getElementById("TipoEnfermedad").value;
    var GravedadPropagacion = document.getElementById("GravedadPropagacion").value;
    var ObservacionesMonitoreo = document.getElementById("ObservacionesMonitoreo").value;


    if (PuestoEmpleado === "" || first_name === "" || last_name === "" || company === "" || NombreSector === "" || NombrePlaga === "" || street === ""
            || TipoPlaga === "" || TipoEnfermedad === "" || GravedadPropagacion === "" || ObservacionesMonitoreo === "")
    {
        alert("Todos los campos son obligatorios.");
        return false;
    }
    var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;

    var renum = /^([0-9]*)$/;
    if (!renum.exec(catidadPersonas)) {
        alert("Cantidad de Personal Utilizado, solo se permiten números");
        return false;
    }
    if (!renum.exec(additional)) {
        alert("Cat de Sectores Fumigados, solo se permiten números");
        return false;
    }
    if (!ren.exec(first_name)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    if (!ren.exec(last_name)) {
        alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
        return false;
    }
    /*
     var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;
     
     if (!ren.exec(nameTierra)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     if (!ren.exec(locacion)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     if (!ren.exec(ubicacion)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     if (!ren.exec(superficie)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     if (!ren.exec(observaciones)) {
     alert("No se permiten caracteres especiales como ''!$^&*+=[]\|¿?");
     return false;
     }
     var renum = /^([0-9]*)$/;
     if (!renum.exec(Sectores)) {
     alert("Número de Sectores, solo se permiten números");
     return false;
     }*/
}

$(document).ready(function () {
    $('#submitAlta').click(function (event) {
        validarfor();
        var first_name = $('#first_name').val();
        var last_name = $('#last_name').val();
        var birthday = $('#birthday').val();
        var gender = $('#gender').val();
        var email = $('#email').val();
        var phone = $('#phone').val();
        var user = $('#user').val();
        var password = $('#password').val();
        var subject = $('#subject').val();
        var Permisos = $('#Permisos').val();
        $.ajax({
            type: 'POST',
            data: {
                first_name: first_name,
                last_name: last_name,
                birthday: birthday,
                gender: gender,
                email: email,
                phone: phone,
                user: user,
                password: password,
                subject: subject,
                Permisos: Permisos
            },
            url: '../AltaUsuarioServlet',
            cache: false,
            dataType: "json",
            success: function (result)
            {
                // $('#IDTabla').html(result);
                console.log(result);
            },
            error: function (result) {
                console.log(result);
            }
        });


    });
    
     $('#DeleteUser').click(function (event) {
        validarDelete();
        var Usuario = $('#id').val();
        var pass = $('#pass').val();
        $.ajax({
            type: 'POST',
            data: {
                Usuario: Usuario,
                pass: pass
            },
            url: '../BajasUsuarioServlet',
            cache: false,
            dataType: "json",
            success: function (result)
            {
                // $('#IDTabla').html(result);
                console.log(result);
            },
            error: function (result) {
                console.log(result);
            }
        });


    });
    $('#RegistroTierras').click(function (event) {
        validarTierras();
        var nameTierra = $('#nameTierra').val();
        var locacion = $('#locacion').val();
        var ubicacion = $('#ubicacion').val();
        var superficie = $('#superficie').val();
        var fecha = $('#fecha').val();
        var Sectores = $('#Sectores').val();
        var Observaciones = $('#Observaciones').val();
        $.ajax({
            type: 'POST',
            data: {
                nameTierra: nameTierra,
                locacion: locacion,
                ubicacion: ubicacion,
                superficie: superficie,
                fecha: fecha,
                Sectores: Sectores,
                Observaciones: Observaciones
            },
            url: '../RegistroTierrasServlet',
            cache: false,
            dataType: "json",
            success: function (result)
            {
                // $('#IDTabla').html(result);
                console.log(result);
            },
            error: function (result) {
                console.log(result);
            }
        });


    });
    
});