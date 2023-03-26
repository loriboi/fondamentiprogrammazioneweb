<%-- 
    Document   : gestisci_prenotazioni
    Created on : Dec 6, 2021, 3:03:17 AM
    Author     : fpw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestisci prenotazioni</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/prenotazioniA.js"></script>  
    </head>
    <body>
        <c:if test = "${empty user}">
            <c:redirect url="loginA.jsp"/>
        </c:if>
        <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
    </c:if> 
        <jsp:include page="menuadm.jsp"/>
        <c:set var="page" value="prenotazioni" scope="request"/>
        
            <c:if test ="${empty prenotazioni}">
            <c:redirect url="ListPrenotazioni"/>
            </c:if>
        
                <div id = "listPrenotazioni" class = "col-12 list">
                <table>
                    <tr><th>Id Prenotazione</th><th>Id Utente</th><th>Posti prenotati</th><th>Id Postazione</th><th>Conferma prenotazione</th></tr>
                    <c:forEach items="${prenotazioni}" var="prenotazione">
                                <tr><td>${prenotazione.getId()}</td><td>${prenotazione.getId_utente()}</td><td>${prenotazione.getNumero_posti()}</td><td>${prenotazione.getId_prenotazione()}</td><td>
                            
                                        <form action="Processa" method="post">
                                            <input type="hidden" value="${prenotazione.getId()}" name="id_prenotazione"/>
                                            <input type="hidden" value="${prenotazione.getNumero_posti()}" name="posti"/>
                                            <input type="hidden" value="${prenotazione.getId_prenotazione()}" name="id_postazione"/>
                                            <input type="hidden" value="${prenotazione.getId_utente()}" name="id_utente"/>
                                            <input type="submit" value="conferma" id="conferma"/>
                                        </form>        
                            </td></tr>
                    </c:forEach>
                </table>
                    
                    
                </div>
            
            
        
    </body>
</html>
