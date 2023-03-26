<%-- 
    Document   : messaggi_adm
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
        <title>Chat</title>
    </head>
    <body>
        <jsp:include page="menuadm.jsp"/> 
        <c:if test="${empty user}">
        <c:redirect url="login.jsp"/>
        </c:if>
        <c:set var="page" value="messaggi_user" scope="request"/>
        <c:set var="page" value="fattura" scope="request"/>
        <c:set var="page" value="utente" scope="request"/>
        <c:set var="page" value="id_user" scope="request"/>
        <c:set var="page" value="domani" scope="request"/>
        <c:if test="${empty messaggi}">
            <c:redirect url="ApriChat"/>
        </c:if>
        <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
        </c:if> 
        <div class="col-12" id="chatBox">
            
            <div id="chat" class="col-4">
                <h3>Chat</h3>
            <div id="messages">
                <c:forEach items="${messaggi}" var="messaggio">
                    <p class="${messaggio.getClasse()} ${messaggio.getLetto()} messaggi">${messaggio.getTesto()}</p>
                </c:forEach>
            </div>
                <div id="actions_adm" >
                    <form action="SendAdminMessage" method ="post">
                        <input type="hidden" name="id_user" value="${id_user}">
                        <input type="text" name="messaggio" id="messaggio">
                        <input type="submit" id="submit" value="Invia messaggio">
                    </form>
                    <form action="ReadMessages" method="post">
                        <input type="hidden" name="id_user" value="${id_user}">
                        <input type="submit" value="Segna come letti i nuovi messaggi">
                    </form> 
                    <c:if test="${domani==true}">    
                    <form action="SendReminder" method="post">
                        <input type="hidden" name="id_user" value="${id_user}">
                        <input type="submit" value="Invia reminder per la prenotazione di domani">
                    </form>
                    </c:if>    
                    <c:if test="${utente.getTotposti()>=20 && fattura==1}">    
                    <form action="SendDiscount" method="post">
                        <input type="hidden" name="id_user" value="${id_user}">
                        <input type="hidden" name="tot_posti" value="${utente.getTotposti()}">
                        <input type="submit" value="Invia sconto per la prossima stagione">
                    </form>
                    </c:if>   
                </div>
                      
        </div>
        </div>
    </body>
</html>
