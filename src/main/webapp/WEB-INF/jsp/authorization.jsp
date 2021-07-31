<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>

<head>
    <title>Авторизация</title>
</head>

<body>
<h2 align="center">Авторизация пользователя</h2>

<form method="post" action="authorization" modelAttribute="user">
    <table align="center">
        <tr>
            <td style="font-weight: bold"><label>Логин</label></td>
            <td><input name="login" type="text"/></td>
        </tr>
        <tr>
            <td style=" font-weight: bold"><label>Пароль</label></td>
            <td><input name="password" type="text"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Авторизация"></td>
        </tr>
    </table>
</form>

</body>
</html>