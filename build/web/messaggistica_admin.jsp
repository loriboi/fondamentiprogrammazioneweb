<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>messagistica</title>
    </head>
    <body>
        <c:set var="page" value="utenti" scope="request"/>
        <c:set var="page" value="notReaded" scope="request"/>
        <c:if test= "${empty admin}">
            <c:redirect url="loginA.jsp"/>
        </c:if> 
        <c:if test = "${empty user}">
            <c:redirect url="loginA.jsp"/>
        </c:if>
        <jsp:include page="menuadm.jsp"/>
        
        <c:if test ="${empty utenti}">
            <c:redirect url="HubMessaggiAdmin"/>
        </c:if>    
        <div id="chat1" class="chat">
        <div id="sceltachat" class="col-4">
            <form action="ApriChat" method="post">
            <h2>Apri una chat</h2>
            <select id="users" name="users">
                <c:forEach items="${utenti}" var="utente">
                <option value="${utente.getId()}">${utente.getNome()} ${utente.getCognome()}</option>
                </c:forEach>
            </select>
            <input type="submit" value="messaggia">
            </form>
        </div>
        <div id="newMessages" class="col-6">
            <c:if test="${not empty notReaded}">
            <h2>Hai nuovi messaggi da leggere da:</h2>
            <ul>
                <c:forEach items="${notReaded}" var="notRead">
                <li>${notRead.getNome()} ${notRead.getCognome()}</li>
                </c:forEach>
            </ul>
            </c:if>
            <c:if test="${empty notReaded}">
            <h2>Non hai nuovi messaggi</h2>
            </c:if>
        </div>
        </div>    
    </body>
</html>
