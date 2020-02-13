<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление вопроса</title>
</head>
<body>
<form method="post" action="/questions">
    <h1>Новый вопрос и ответ</h1>
    <c:if test="${successPutting != null}">
        <h3>${successPutting}</h3>
    </c:if>
    <div class="form-group row">
        <label>Вопрос</label>
        <div>
            <input type="text" name="question" />
        </div>
        <label>Ответ</label>
        <div>
            <input type="text" name="answer" />
        </div>
        <label>Тип вопроса</label>
        <div>
            <input type="checkbox" name="typeOfAnswers" />
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Подтвердить</button>
    </div>
</form>
</body>
</html>
