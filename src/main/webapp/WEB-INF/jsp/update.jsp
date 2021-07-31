<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>

<head>
    <title>Обновить</title>
</head>

<body>
<h2 align="center">Обновить пользователя</h2>

<form method="post" action="update" modelAttribute="user">
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
            <td style="font-weight: bold"><label>Фамилия</label></td>
            <td><input name="surname" type="text"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold"><label>Имя</label></td>
            <td><input name="name" type="text"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold"><label>Отчество</label></td>
            <td><input name="patronymic" type="text"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold"><label>Email</label></td>
            <td><input name="email" type="text"/></td>
        </tr>
        <tr>
            <td style="font-weight: bold"><label>Телефон</label></td>
            <td><input name="phone" type="text"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Обновить"></td>
        </tr>
    </table>
</form>

</body>
</html>