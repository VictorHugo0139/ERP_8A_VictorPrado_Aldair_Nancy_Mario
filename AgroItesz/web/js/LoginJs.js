/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validarfor(){
    console.log("user:");

var user = document.getElementById("login").value; 
var pass = document.getElementById("password").value;

var ren = /^([a-zA-Z0-9áéíóúÁÉÍÓÚÄÖßÜäößüñÑ \-,.; ]*)$/;
	console.log("user:"+user);
	if (!ren.exec(user)) {
		alert("Usuario, no se permiten caracteres especiales como ''!$^&*+=[]\|¿?");		
		return false;
	}
        if (!ren.exec(pass)) {
		alert("Contraseña, no se permiten caracteres especiales como ''!$^&*+=[]\|¿?");		
		return false;
	}
        
}