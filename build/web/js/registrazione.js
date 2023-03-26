/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    var user = false, password = false, nome = false,email = false, cognome = false, cf = false, telefono = false, fattura = false;
    var max = 20,min = 3;
    function checkUser(){
        if($('#user').val().length<=min || $('#user').val().length>max){
            $('#user').css("color","red");
            user = false;
        }
        else{
            $('#user').css("color","green");
            user = true;
        }
    }
    $('#user').on('change input',checkUser);
    function controllaPass(){
        if($('#password').val().length<=min || $('#password').val().length>max){
            $('#password').css("color","red");
            
            password = false;
        }
        else{
            $('#password').css("color","green");
            password = true;
        }
    }
    $('#password').on('change input',controllaPass);
    function controllaNome(){
        if($('#nome').val().length > min && $('#nome').val().length <= max){
            $('#nome').css("color","green");
            nome = true;
        }
        else{
            $('#nome').css("color","red");
            nome = false;
        }
    }
    $('#nome').on('change input',controllaNome);
    function controllaCognome(){
        if($('#cognome').val().length > min && $('#cognome').val().length <= max){
            $('#cognome').css("color","green");
            cognome = true;
        }
        else{
            $('#cognome').css("color","red");
            cognome = false;
        }
    }
    $('#cognome').on('change input',controllaCognome);
    function controllaEmail(){
        if($('#email').val().length > min && $('#email').val().length <= max){
            $('#email').css("color","green");
            email = true;
        }
        else{
            $('#email').css("color","red");
            email = false;
        }
    }
    $('#email').on('change input',controllaEmail);
    function controllaCF(){
        if($('#CF').val().length === 16){
            $('#CF').css("color","green");
            cf = true;
        }
        else{
            $('#CF').css("color","red");
            cf = false;
        }
    }
    $('#CF').on('change input',controllaCF);
    function controllaTelefono(){
        if($('#telefono').val().length === 10){
            $('#telefono').css("color","green");
            telefono = true;
        }
        else{
            $('#telefono').css("color","red");
            telefono = false;
        }
    }
    $('#telefono').on('change input',controllaTelefono);
    
    $('#si').on('change input', function(){
        fattura = true;
    });
    $('#no').on('change input', function(){
        fattura = true;
    });
    $('#registrati').click(function(e) {
    if(!(user || password || nome || email || cognome ))
    {
        alert("Impossibile registrarti, assicurati che i dati abbiano lunghezza maggiore di 3 e minore di 20");
        e.preventDefault();
    }
    else if(!(telefono)){
        alert("Il telefono deve essere di 10 cifre");
        e.preventDefault();
    }
    else if(!(cf)){
        alert("Il codice fiscale deve avere 16 caratteri");
        e.preventDefault();
    }
    else if(!(fattura)){
        alert("Devi selezionare se ricevere la fattura elettronica o no");
        e.preventDefault();
    }
    else{
        alert("Registrato con successo");
    }
    
    });
});
