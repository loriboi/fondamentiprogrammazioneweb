<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Waves</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Lorenzo Boi">
        <meta name="description" content="Progetto B">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/registrazione.js"></script>
    </head>
    <body>
        
        <div id=registrationBox>
        <a href="index.jsp">
        <img title="Logo" alt="Logo di Waves" src="img/logo.png" width="368" height="150">
        </a>
            </br>    
        <form action="SigninServlet" method="post">
            </br>
            <label for="foto">Carica foto</label></br>
            <input type="file" name="foto"/>
            </br></br>
            <label for="user">Username</label>
            </br>
            <input type="text" name="user" id="user"/>
            </br>
            <label for="pass">Password</label>
            </br>    
            <input type="password" name="pass" id="pass"/>
            </br>
            <label for="name">Nome</label>
            </br>
            <input type="text" name="nome" id="nome"/>
            </br>
            <label for="cognome">Cognome</label>
            </br>
            <input type="text" name="cognome" id="cognome"/>
            </br>
            <label for="email"> Email</label>
            </br>
            <input type="text" name="email" id="email"/>
            </br>
            <label for="datanasc">Data di nascita</label>
            </br>
            <input type="date" name="datanasc"/>
            </br>
            <label for="CF">Codice fiscale</label>
            </br>
            <input type="text" name="CF" id="CF"/>
            </br>
            <label for="telefono">Telefono</label>
            </br>
            <input type="text" name="telefono" id="telefono">
            </br>
            <p>Sesso</p>
            <label for="uomo">Uomo</label>
            <input type="radio" name="sesso" id="uomo" value="uomo">
            <label for="donna">Donna</label>
            <input type="radio" name="sesso" id="donna" value="donna"></br>
            <p>Desideri ricevere la fattura elettronica?</p>
            <label for="si">Si</label>
            <input type="radio" name="sceltaf" id="si" value="si">
            <label for="no">No</label>
            <input type="radio" name="sceltaf" id="no" value="no">
            </br>
            </br>
            
            </br>
            <input type="submit" value="Registrati" id="registrati"/>   
        </form>
          
        </div>    
    </body> 
</html>
