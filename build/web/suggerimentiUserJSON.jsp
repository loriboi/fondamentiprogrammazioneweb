<%-- 
    Document   : suggerimentiUserJSON
    Created on : Dec 14, 2021, 11:32:45 PM
    Author     : fpw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<json:object>
    <c:forEach var="utente" items="${utenti}" varStatus="conteggio">
        <json:property name="${conteggio.count}" value="${utente}"/>
    </c:forEach>
</json:object>
