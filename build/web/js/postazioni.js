/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*data
 * posti_mattina
 * posti_sera
 * inserisci*/

$(document).ready(function(){
    var sera = false,mattina = false;
    
    $('#inserisci').click(function(e) {
       if(mattina && sera){
       alert("Postazione aggiunta con successo");
       
    } 
   else{
       alert("Impossibile aggiungere la postazione, ricontrolla i dati");
       e.preventDefault();
   }
   });
    
    
    function controllaPostiSera(){
        if($('#posti_sera').val() >0 ){
            sera = true;
            $('#posti_sera').css("color","green");
        }
        else{
            sera = false;
            $('#posti_sera').css("color","red");
        }
    }
    $('#posti_sera').on('change input', controllaPostiSera);
    function controllaPostiMattina(){
        if($('#posti_mattina').val() >0 ){
            mattina = true;
            $('#posti_mattina').css("color","green");
        }
        else{
            mattina = false;
            $('#posti_mattina').css("color","red");
        }
    }
    $('#posti_mattina').on('change input', controllaPostiMattina);
    
});