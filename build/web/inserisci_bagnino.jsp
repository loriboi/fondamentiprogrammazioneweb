<%-- 
    Document   : inserisci_bagnino
    Created on : Oct 22, 2021, 10:56:05 PM
    Author     : fpw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bagnini.js"></script>   
        <title>Aggiungi Bagnino</title>
    </head>
    <body>
        <c:if test = "${empty user}">
            <c:redirect url="loginA.jsp"/>
        </c:if>
        <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
        </c:if> 
        <jsp:include page="menuadm.jsp"/>
        <div class="add">
        <form action="AddBagnino" method="post" id="addBagnino" class="col-12">
            <h2>Aggiungi bagnino</h2>
            <label for="nome">Nome</label>
            </br>
            <input type="text" name="nome" id="nome"/>
            </br>
            </br>
            <label for="cognome">Cognome</label>
            </br>    
            <input type="text" name="cognome" id="cognome"/>
            </br>
            </br>
            <label for="email">Indirizzo Email</label>
            </br>
            <input type="text" name="email" id="email"/>
            </br>
            </br>
            <label for="cellulare">Cellulare</label>
            </br>
            <input type="text" name="cellulare" id="cellulare" class="">
            </br>
            </br>
            <label for="attestati">Attestati vari</label>
            </br>
            <textarea rows="4" cols="35" name="attestati" id="attestati">Inserisci attestati</textarea>
            <p id="caratteriRimanenti">Caratteri: 0/50</p>
            </br>
            </br>
            <input type="submit" value="Registra bagnino" id="registra"/>
            
        </form>
        </div> 
    </body>
</html>
