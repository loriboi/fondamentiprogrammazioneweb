<%-- 
    Document   : login
    Created on : Jul 25, 2021, 1:29:37 AM
    Author     : fpw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Waves</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Lorenzo Boi">
        <meta name="description" content="Progetto B">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
    </head>
    <body>
        
        <div id=loginBox>
        
        <a href="index.jsp">
        <img title="Logo" alt="Logo di Waves" src="img/logo.png" width="368" height="150">
        </a>
           
     
        
        <form action="LoginServletA" method="post">
            <p>Pagina riservata al login per gli amministratori</p>
            <label for="user">Username</label>
            </br>
            <input type="text" name="user" id="user"/>
            </br>
            <label for="pass">Password</label>
            </br>    
            <input type="password" name="pass" id="password"/>
            </br>
            <input type="submit" value="Accedi" id="accedi"/>
        </form>
        </div>
        
    </body>
</html>
