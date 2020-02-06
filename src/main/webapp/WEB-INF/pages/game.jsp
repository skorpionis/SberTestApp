<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>Добро пожаловать, JSP!</title>
</head>
<body>

<form method="get" action="/game">
    <h1>Добро пожаловать!</h1>
    <c:forEach items="${qList}" var="quest">
        <div>
            <div>
                    ${quest.question}<br><br>
                <c:forEach items="${quest.answers}" var="map">
                    ${map.key}<br>
                </c:forEach>
                <br>
                    ${quest.questType}
            </div>
        </div>
    </c:forEach>
</form>
</body>
</html>