<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script type="text/javascript" src="js/prenota.js"></script>
    </head>
    <body>
        
        <c:if test="${empty user}">
        <jsp:include page="menu.jsp"/>
        </c:if>
        <c:if test="${not empty user}">
        <jsp:include page="menuusr.jsp"/>
        </c:if>
        
        <c:set var="page" value="prenota" scope="request"/>
        <c:if test="${empty prenotazioni}">
            <c:redirect url="ListPostazioni"/>
        </c:if>
        <c:if test="${not empty prenotazioni}">
            <c:forEach items="${prenotazioni}" var="prenotazione">
                <div class="col-3" id="postazione">
                    <article>
                    <h3>${prenotazione.getData()}</h3>
                    <p>Posti mattina:${prenotazione.getPosti_mattina()}</p>
                    <br/>
                    <p>Posti sera:${prenotazione.getPosti_sera()}</p>
                    </article>
                    <br/>
                    <c:if test = "${empty user}">
                        <p>Per prenotarti devi essere loggato</p>
                    </c:if>
                    <c:if test = "${not empty user}">
                        <form action="Prenota" method="post">
                            <input type="hidden" name = "posti_sera" value="${prenotazione.getPosti_sera()}"/>
                            <input type="hidden" name = "posti_mattina" value="${prenotazione.getPosti_mattina()}"/>
                            <input type="hidden" name ="id_u" value="${id}"/>
                            <input type="hidden" name ="id_p" value="${prenotazione.getId_prenotazione()}"/>
                            <label for="prenotaposti">Posti da prenotare:</label>
                            <input type="text" name="prenotaposti" id="prenotaposti"/><br/><br/>
                            <label for="sera">Sera</label>
                            <input type="radio" name="fascia" id="sera" value="sera">
                            <label for="mattina">Mattina</label>
                            <input type="radio" name="fascia" id="mattina" value="mattina"><br/><br/>
                            <input type="submit" value="Prenota" id="prenota"/>
                        </form>
                    </c:if>
                </div>
            </c:forEach>
            
        </c:if>
    <jsp:include page="footer.jsp"/>
    </body> 
</html>
