<%-- 
    Document   : areaPersonaleA
    Created on : Sep 22, 2021, 1:16:30 AM
    Author     : fpw
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>Amministrazione</title>
        <meta name="viewport" content="width=device-width,inital-scale=1.0">
        
    </head>
    <body>
    <c:if test = "${empty user}">
            <c:redirect url="loginA.jsp"/>
    </c:if>
    <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
    </c:if>    
        
    <jsp:include page="menuadm.jsp"/>
        
    <p>Benvenuto nell'area personale dell'amministratore:</p>
    <ul>
        <li>Cliccando su <b>"Messaggi"</b> hai accesso alle funzioni di messaggistica</li>
        <li>Cliccando su <b>"Postazioni"</b> puoi inserire dei nuovi slot di prenotazioni per gli utenti</li>
        <li>Cliccando su <b>"Bagnini"</b> puoi inserire nuovi bagnini nel sistema</li>
        <li>Cliccando su <b>"Utenti"</b> hai accesso alla lista degli utenti</li>
    </ul>
    </body>
</html>
