/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
var caricato = false;
function checkInput()
{
    if(!caricato)
    {
        $.ajax({
            url:"SuggerimentiServlet",
            data: {
                cmd:"listaUtenti"
            },
            dataType:"json",
            success: function(data,state){
                caricato = true;
                popolaAutoCompletamento(data);
            },
            error: function(data,state){
                alert(state);
            }
            
        });
    }
}       

$('#boxSuggerimenti').on('change input',checkInput);
function popolaAutoCompletamento(lista)
{
    $.each(lista,function(k,v){
        var elemento='<option value="'+v+'">';
        $('#listaDiUtenti').append(elemento);
    }
            );
}
        
});        
        
        
        



