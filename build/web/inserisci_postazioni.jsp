<%-- 
    Document   : inserisci_postazioni
    Created on : Oct 25, 2021, 9:40:35 AM
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
        <script type="text/javascript" src="js/postazioni.js"></script> 
        <title>Inserisci postazioni</title>
    </head>
    
    <body>
        <c:if test = "${empty user}">
            <c:redirect url="loginA.jsp"/>
        </c:if>
        <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
        </c:if> 
        <jsp:include page="menuadm.jsp"/>
        
        <c:set var="page" value="inserisci_postazioni" scope="request"/>
        <c:if test="${empty bagnini}">
            <c:redirect url="ListBagnini"/>
        </c:if>
        <div class="add">
        <form action ="AddSlot" method="post" id = "addSlot" class="col-12">
            
            
           <h2>Aggiungi postazioni</h2>
            
            <label for="data">Data:</label><br>
            <input type="date" name="data" id="data"><br></br>
            <label for="posti_mattina">Inserisci il numero di posti per la mattina</label><br>
            <input type="text" name="posti_mattina" id="posti_mattina"><br></br>
            <label for="posti_sera">Inserisci il numero di posti per la sera</label><br>
            <input type="text" name="posti_sera" id="posti_sera"><br><br>
            <label for="id_bagnino">Seleziona il bagnino:</label><br>
            </br>
                
                <select name="bagn">
                <c:forEach items="${bagnini}" var="bagnino">
                    <option value="${bagnino.getId()}">${bagnino.getNome()} ${bagnino.getCognome()}</option>
                    
                </c:forEach>
                </select>
                <br>
                <br>
            <input type="submit" value="Inserisci postazioni" id="inserisci">
            
        </form>
            
        
        </div>
    </body>
</html>
