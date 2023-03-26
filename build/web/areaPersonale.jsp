<%-- 
    Document   : areaPersonaleUser
    Created on : Jul 24, 2021, 12:14:38 AM
    Author     : fpw
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>AreaPersonale</title>
        <meta name="viewport" content="width=device-width,inital-scale=1.0">
        
    </head>
    <body>
        <jsp:include page="menuusr.jsp"/> 
        <c:set var="page" value="utente" scope="request"/>
        <c:if test = "${empty user}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <c:if test = "${not empty user}">
            <h2>Ciao ${user}!</h2>            
            <p>Utimo accesso: ${lastLogin}</p>
        </c:if>   
            
              
    </body>
</html>
