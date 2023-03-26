<%-- 
    Document   : messaggi_user
    Created on : Dec 16, 2021, 3:50:40 PM
    Author     : fpw
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contatta l'amministratore</title>
    </head>
    <body>
        <jsp:include page="menuusr.jsp"/> 
        <c:if test="${empty user}">
        <c:redirect url="login.jsp"/>
        </c:if>
        <c:set var="page" value="messaggi_user" scope="request"/>
        <c:if test="${empty messaggi}">
            <c:redirect url="ListMessaggiByUser"/>
        </c:if>
        <div class="col-12" id="chatBox">
            
            <div id="chat" class="col-4">
                <h3>Contatta l'amministratore inviando un messaggio</h3>
            <div id="messages">
                <c:forEach items="${messaggi}" var="messaggio">
                    <p class="${messaggio.getClasse()} ${messaggio.getLetto()} messaggi">${messaggio.getTesto()}</p>
                </c:forEach>
            </div>
                <div id="actions" class="col-4">
                    <form action="SendUserMessage" method ="post">
                        <input type="hidden" name="id_user" value="${id}">
                        <input type="text" name="messaggio" id="messaggio">
                        <input type="submit" id="submit" value="Invia">
                    </form>
                    <form action="ReadMessagesUser" method="post">
                        <input type="hidden" name="id_user" value="${id}">
                        <input type="submit" value="Leggi">
                    </form>    
                </div>
                      
        </div>
        </div>
    </body>
</html>
