/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    var user = false, password = false;
    function controllaUser(){
        if($('#user').val().length > 3 || $('#user').val()==="Boi"){
            $('#user').css("color","green");
            user = true;
        }
        else{
            $('#user').css("color","red");
            user = false;
        }
    }
    $('#user').on('change input',controllaUser);
    function controllaPass(){
        if($('#password').val().length > 3){
            $('#password').css("color","green");
            password = true;
        }
        else{
            $('#password').css("color","red");
            password = false;
        }
    }
    $('#password').on('change input',controllaPass);
    
    $('#accedi').click(function(e) {
        if(!(password)&&!(user)){    
        alert("Inserisci username e password (devono essere più di 3 caratteri)");
        e.preventDefault();
    } 
    else if(!(password)){
        if($('#password').val().length <= 3 && $('#password').val().length !== 0){
            alert("La password deve essere più lunga di 3 caratteri");
        }
        else{
        alert("Inserisci password");
        }
        e.preventDefault();
    }
    else if(!(user)){
        if($('#user').val().length <= 3 && $('#user').val().length !== 0){
            alert("L'username deve essere più lungo di 3 caratteri");
        }
        else{
        alert("Inserisci username");
        }
        e.preventDefault();
    }
    });
});

