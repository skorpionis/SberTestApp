<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Тестирование</title>
    <style>
        #mainPageTitle {
            text-align: center;
        }

        #testForm {
            text-align: center;
        }
    </style>
</head>
<body>
<form method="post" action="/game">
    <div id="testForm">
        <div id="mainPageTitle">
            <h1>Пройдите тестирование</h1>
        </div>
        <c:forEach items="${quests}" var="quest" >
            <div>
                <div>
                    <div><label>Вопрос: </label>${quest.key.question}<br></div>

                    <c:if test="${quest.key.questType}">

                        <c:forEach items="${quest.value}" var="map">
                            <div>
                                <label>Ответ: </label>${map.key}<br>
                                <div><input type="checkbox"/></div>
                            </div>
                        </c:forEach>

                    </c:if>
                    <c:if test="${!quest.key.questType}">
                        <label>
                            <input type="text" name="ans"/>
                        </label>
                    </c:if>
                    <br>
                </div>
            </div>
            <label>------------------------------------------</label><br>
        </c:forEach>
        <div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Сдать ответы</button>
        </div>
    </div>
</form>
</body>
</html>