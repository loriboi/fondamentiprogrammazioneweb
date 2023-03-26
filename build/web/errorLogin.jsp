<%-- 
    Document   : error
    Created on : Jul 24, 2021, 12:06:43 AM
    Author     : fpw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>Error</title>
    </head>
    <body>
        
        
        <h1>Errore: ${errorMessage} </h1>
        <jsp:include page="login.jsp"/>
        
        
        
    </body>
</html>
