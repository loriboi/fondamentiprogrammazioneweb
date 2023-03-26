/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    var param = false, posti = false, sera = false, mattina = false;
    $('#sera').on('change input', function(){param = true; sera = true;});
    $('#mattina').on('change input', function(){param = true; mattina = true;});
    function controllaPosti(){
        if($('#prenotaposti').val().length === 0 || $('#prenotaposti').val()<=0){
            $('#prenotaposti').css("color","red");
            posti = false;
        }
        else{
            $('#prenotaposti').css("color","green");
            posti = true;
        }
    }
    
    $('#prenotaposti').on('change input',controllaPosti);
    $('#prenota').click(function(e) { 
    if(!(param && posti)){
        alert("Impossibile prenotare, hai selezionato la fascia oraria e specificato il numero di posti?");
        e.preventDefault();
    } 
    else{
        alert("Prenotazione di "+$('#prenotaposti').val()+" posti avvenuta con successo");
    }
    
    });
});

