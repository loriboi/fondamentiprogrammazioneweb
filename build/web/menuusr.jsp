<%-- 
    Document   : menuusr
    Created on : Nov 8, 2021, 12:44:08 AM
    Author     : fpw
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/menu.js"></script>   
    </head>
    <body>
    <c:if test="${empty user}">
    <c:redirect url="login.jsp"/>
    </c:if>
        <div id = menu class="col-12">
        <header>
            <a href="areaPersonale.jsp">
            <img src="img/logo.png" title="Logo" alt="Logo di Waves" width=50% height=20%>
            </a>
              
        </header>
            <hr>
        <nav>
            <ul>
                
                <li><a href="pagina_pers.jsp">Informazioni personali</a></li>
                <li><a href="prenota.jsp">Prenota</a></li> 
                <li><a href="messaggi_user.jsp">Contatta l'amministratore</a></li>
                <li><a href="fatture_utente.jsp">Fatture</a></li> 
                <li><form action="LogoutServlet" method="post"><input type = submit value="Esci" id="esci"></form></li>    
            </ul>
        </nav>
            <hr>
        </div>
       
    </body>
</html>
