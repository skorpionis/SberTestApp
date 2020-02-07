<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Введите свой уже существующий логин</title>
</head>
<body>
<form method="post" action="/loging">
    <h1>Login</h1>
    <div class="form-group row">
        <label>Введите имя пользователя</label>
        <div>
            <input type="text" name="login" placeholder="login"/>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Подтвердить</button>
    </div>

</form>
</body>
</html>
