<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>Тестирование</title>
</head>
<body>

<form method="get" action="/game">
    <h1>Пройдите тестирование</h1>
    <c:forEach items="${qSet}" var="quest">
        <div>
            <div>
                <div><label>Вопрос: </label>${quest.question}<br></div>

                <c:forEach items="${quest.answers}" var="map">

                    <div>
                        <label>Ответ: </label>${map.key}<br>
                        <label>Правильный: </label>${map.value}<br>
                    </div>

                </c:forEach>
                <%--<div><label>Тип: </label>
                        <c:if test="${quest.questType}">С выбором ответа</c:if>
                        <c:if test="${!quest.questType}">С Развернутым ответом</c:if>
                </div>--%>
                <br>
            </div>
        </div>
    </c:forEach>
</form>
</body>
</html>