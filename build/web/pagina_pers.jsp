<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : pagina_pers
    Created on : Nov 5, 2021, 3:25:37 AM
    Author     : fpw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informazioni Personali</title>
    </head>
    <body>
        <jsp:include page="menuusr.jsp"/> 
        <c:if test="${empty user}">
        <c:redirect url="login.jsp"/>
        </c:if>
        <c:set var="page" value="pagina_pers" scope="request"/>
        <c:if test="${empty utente}">
            <c:redirect url="InformazioniPersonali"/>
        </c:if>
        <c:if test="${not empty utente}">
        <div id ="content_usr" class="col-4">    
        <h2>Informazioni personali</h2>
        <p>Foto: ${utente.getFoto()}</p>
        <p>Nome: ${utente.getNome()}</p>
        <p>Cognome: ${utente.getCognome()}</p>
        <p>Password: ${utente.getPassword()}</p>
        <p>Data di nascita: ${utente.getDataNascita()}</p>
        <p>Codice fiscale: ${utente.getCf()}</p>
        <p>Sesso: ${utente.getSesso()}</p>
        <p>E-mail: ${utente.getE_mail()}</p>
        <p>Telefono: ${utente.getTelefono()}</p>
        <p>Fattura elettronica: ${utente.getFattura()}</p>
        </div>
        <div id="content" class="col-5">
            <h2>Modifica Informazioni</h2>
        <form action="ModificaInformazioniUser" method="post">
            <input type="hidden" name="id" value="${utente.getId()}">
            <input type="hidden" name="fotoOld" value="${utente.getFoto()}">
            <label for="fotoNew">Carica foto:</label>
            <input type="file" name="fotoNew"/>
            <br><br>
            
            
            <input type="hidden" name="nomeOld" value="${utente.getNome()}">
            <label for="nomeNew">Nome: </label><input type="text" name="nomeNew"/></br><br>
            
            <input type="hidden" name="cognomeOld" value="${utente.getCognome()}">
            <label for="cognomeNew">Cognome: </label><input type="text" name="cognomeNew" value=""/></br><br>
            
            <input type="hidden" name="passwordOld" value="${utente.getPassword()}">
            <label for="passwordNew">Password: </label><input type="text" name="passwordNew" value=""/></br><br>
            
            <input type="hidden" name="dataOld" value="${utente.getDataNascita()}">
            <label for="dataNew">Data di Nascita: </label><input type="date" name="dataNew"/></br><br>
            
            <input type="hidden" name="cfOld" value="${utente.getCf()}">
            <label for="cfNew">Codice fiscale: </label><input type="text" name="cfNew" value=""/></br><br>
            
            <input type="hidden" name="sessoOld" value="${utente.getSesso()}">  
            <p>Sesso:</p>
            <label for="uomo">Uomo</label>
            <input type="radio" name="sessoNew" id="uomo" value="uomo">
            <label for="donna">Donna</label>
            <input type="radio" name="sessoNew" id="donna" value="donna"></br>
            
            <input type="hidden" name="emailOld" value="${utente.getE_mail()}">
            <label for="emailNew">Email: </label><input type="text" name="emailNew" value=""/></br><br>
            
            <input type="hidden" name="telefonoOld" value="${utente.getTelefono()}">
            <label for="telefonoNew">Telefono: </label><input type="text" name="telefonoNew" value=""/></br><br>
            
            <input type="hidden" name="fatturaOld" value="${utente.getFattura()}">
            <p>Fattura elettronica: </p><label for="si">Si</label><input type="radio" name="fatturaNew" id="si" value="si">
            <label for="no">No</label>
            <input type="radio" name="fatturaNew" id="no" value="no">
            <br>
            <br>
            <input type="submit" value="modifica"/>
            <br>
        </form>
        </div>   
        </c:if>
    
    
    </body>
    
</html>
