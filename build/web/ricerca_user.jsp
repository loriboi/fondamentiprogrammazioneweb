<%-- 
    Document   : ricerca_user
    Created on : Dec 14, 2021, 11:28:23 PM
    Author     : fpw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ricerca Utenti</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/ricercaUtenti.js"></script>
        
    </head>
    <body>
        <c:set var="page" value="utente" scope="request"/>
        <c:set var="page" value="fatture" scope="request"/>
        <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
        </c:if> 
        <form action="Ricerca" method="post">
        <input list="listaDiUtenti" type="text" id="boxSuggerimenti" name="boxSuggerimenti">
        <datalist id="listaDiUtenti">
        </datalist>
        <input type="submit" value="Ricerca" id="cerca"/>
        </form>    
        <c:if test="${not empty utente}">
        <p>Foto: ${utente.getFoto()}</p>
        <p>Nome: ${utente.getNome()}</p>
        <p>Cognome: ${utente.getCognome()}</p>
        <p>Password: ${utente.getPassword()}</p>
        <p>Data di nascita: ${utente.getDataNascita()}</p>
        <p>Codice fiscale: ${utente.getCf()}</p>
        <p>Sesso: ${utente.getSesso()}</p>
        <p>E-mail: ${utente.getE_mail()}</p>
        <p>Telefono: ${utente.getTelefono()}</p>
        <p>Fattura elettronica: ${utente.getFattura()}</p>    
        </c:if>
        <c:if test="${not empty fatture}">
        <table>
        <tr><th>Id</th><th>Data</th><th>Posti prenotati</th><th>Prezzo</th>
        <c:forEach items="${fatture}" var="fattura">
        
        <tr><td>${fattura.getId()}</td><td>${fattura.getData()}</td><td>${fattura.getPosti()}</td><td>${fattura.getPrezzo()}€</td></tr>
        </c:forEach>    
        </table>  
        </c:if>
            
        
    </body>
</html>
