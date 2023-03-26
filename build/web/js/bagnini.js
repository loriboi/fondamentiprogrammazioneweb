/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){

var nome = false,cognome = false,email = false,cellulare = false,attestati = false;

$('#registra').click(function(e) {
   if(nome && cognome && email && cellulare && attestati){
       alert("Bagnino registrato con successo");
       
   } 
   else{
       alert("Impossibile registrare il bagnino, ricontrolla i dati");
       e.preventDefault();
   }
});
$('#attestati').keydown(function(e) {
    var limchar = 100;
    var key = e.keyCode || e.charCode;
    if(this.value.length>limchar-1){
        if(!(key===46||key===8)){
            attestati = false;
            e.preventDefault();
        }
    }
    else{
        attestati = true;
    }
});
$('#attestati').keyup(function() {
    $('#caratteriRimanenti').text("Caratteri:" + $(this).val().length + "/100");
});
function controllaCellulare()
{
    if(!($('#cellulare').val().length === 10)){     
       $('#cellulare').css("color","red");
       cellulare = false;
    }
    else{
       $('#cellulare').css("color","green");
       cellulare = true;
    }
}
$('#cellulare').on('change input',controllaCellulare);

function controllaNome()
{
    if($('#nome').val().length < 2){
        $('#nome').css("color","red");
        nome = false;
    }
    else{
        $('#nome').css("color","green");
        nome = true;
    }
}
$('#nome').on('change input', controllaNome);

function controllaCognome()
{
    if($('#cognome').val().length < 2){
        $('#cognome').css("color","red");
        cognome = false;
    }
    else{
        $('#cognome').css("color","green");
        cognome = true;
    }
}
$('#cognome').on('change input', controllaCognome);

function controllaEmail()
{
    if($('#email').val().length < 6){
        $('#email').css("color","red");
        email = false;
    }
    else{
        $('#email').css("color","green");
        email = true;
    }
}
$('#email').on('change input', controllaEmail);
});
