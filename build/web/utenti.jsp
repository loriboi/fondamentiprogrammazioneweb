<%-- 
    Document   : utenti
    Created on : Dec 12, 2021, 10:53:38 AM
    Author     : fpw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Utenti</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/ordina.js"></script>  
    </head>
    <body>
        <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
        </c:if> 
        <c:if test = "${empty user}">
            <c:redirect url="loginA.jsp"/>
        </c:if>
        <jsp:include page="menuadm.jsp"/>
        
        <div class="add col-6">
            <h2>Ricerca Utente</h2>
        <jsp:include page="ricerca_user.jsp"/> 
        
        </div>
        <div class="add col-4">
              
        <form action="ListUsers" method="post" id="modalitavista" class="col-12">
            <h2>Visualizza gli utenti</h2>
            <label for="ord_param">Ordina per:</label></br>
            <input type="radio" id="cognome" name="ord_param" value="cognome"><label for="cognome">Cognome</label></br>
            <input type="radio" id="posti_prenotati" name="ord_param" value="tot_prenotazioni"><label for="posti_prenotati">Prenotazioni</label></br><br/>
            <label for="ord_param">Tipo ordinamento:</label></br>
            <input type="radio" id="crescente" name="ordine" value="ASC"><label for="crescente">Crescente</label></br>
            <input type="radio" id="decrescente" name="ordine" value="DESC"><label for="decrescente">Decrescente</label></br><br/>
            <input type="submit" value="Ordina" id="ordina">
        </form>
        </div>
    </body>
</html>
