<%-- 
    Document   : menuadm
    Created on : Oct 30, 2021, 12:20:59 AM
    Author     : fpw
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/menu.js"></script> 
        <title>Admin menu</title>
    </head>
    <body>
        <c:if test = "${empty user}">
            <c:redirect url="loginA.jsp"/>
        </c:if>
        <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
        </c:if> 
        <header class="col-12">
            <a href="menuadm.jsp">
            <img src="img/logo.png" title="Logo" alt="Logo di Waves" width=50% height=20%>
            </a>
        </header>
        
            
        <nav id = "admin" class="col-12">
            <ul>
                <li><a href="messaggistica_admin.jsp">Messaggi</a></li>
                <li><a href="inserisci_postazioni.jsp">Postazioni</a></li>
                <li><a href="gestisci_prenotazioni.jsp">Prenotazioni</a></li>
                <li><a href="inserisci_bagnino.jsp">Bagnini</a></li>
                <li><a href="utenti.jsp">Utenti</a></li>
                <li><form action="LogoutServlet" method="post"><input type = submit value="Esci" id="esci"></form></li>
            </ul>
        </nav>  
    </body>
</html>
