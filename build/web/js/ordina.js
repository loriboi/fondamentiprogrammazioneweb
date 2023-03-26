/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    var param = false, tipo = false;
    $('#cognome').on('change input', function(){param = true;});
    $('#posti_prenotati').on('change input', function(){param = true;});
    $('#crescente').on('change input', function(){tipo = true;});
    $('#decrescente').on('change input', function(){tipo = true;});
    $('#ordina').click(function(e) {
    if(!(param && tipo)){
        alert("Impossibile ordinare, hai selezionato entrambi i parametri?");
        e.preventDefault();
   
    } 
    });
});