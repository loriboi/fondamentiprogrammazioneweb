<%-- 
    Document   : fatture_utente
    Created on : Dec 16, 2021, 10:01:24 AM
    Author     : fpw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>Fatture</title>
    </head>
    <body>
        <jsp:include page="menuusr.jsp"/> 
        <c:if test="${empty user}">
        <c:redirect url="login.jsp"/>
        </c:if>
        <c:set var="page" value="fatture_utente" scope="request"/>
        <c:if test ="${empty fatture}">
            <c:redirect url="FattureUtenteServlet"/>
        </c:if>
        
                <div id = "listPrenotazioni" class = "col-12 list">
                    <h2>Le fatture che hai richiesto</h2>
                <table>
                    <tr><th>Id</th><th>Data</th><th>Posti prenotati</th><th>Prezzo</th><th>Descrizione</th></tr>
                    <c:forEach items="${fatture}" var="fattura">
                        <tr><td>${fattura.getId()}</td><td>${fattura.getData()}</td><td>${fattura.getPosti()}</td><td>${fattura.getPrezzo()}€</td><td>${fattura.getDescrizione()}</td></tr>
                    </c:forEach>
                </table>
                    
                  
                </div>
    </body>
</html>
