<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Страница регистрации</title>
</head>

<body>
<form method="post" action="/registration">
    <h1>Зарегистрируйтесь</h1>

    <c:if test="${usernameError != null}">
        <h3>${usernameError}</h3>
    </c:if>
    <div class="form-group row">
        <label>Введите логин</label>
        <div>
            <input type="text" name="login" />
        </div>
        <label>Введите пароль</label>
        <div>
            <input type="password" name="password" />
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Подтвердить</button>
    </div>
</form>
</body>
</html>
