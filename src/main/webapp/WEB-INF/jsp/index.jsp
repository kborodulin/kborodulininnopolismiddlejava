<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>

<head>
    <title>Users</title>
</head>

<body>
<h2 align="center">Список пользователей с контактными данными </h2>

<table border="1" align="center">
    <tr>
        <th>ИД</th>
        <th>Логин</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Почта</th>
        <th>Телефон</th>
        <th>Изменить</th>
        <th>Удалить</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <th>${user.id} </th>
            <th>${user.login}</th>
            <th>${user.surname}</th>
            <th>${user.patronymic}</th>
            <th>${user.name}</th>
            <th>${user.email}</th>
            <th>${user.phone}</th>
            <th><a href="update?id=${user.id}">Изменить</a></th>
            <th><a href="delete?id=${user.id}">Удалить</a></th>
        </tr>
    </c:forEach>
</table>

<h3 align="center">Добавить нового пользователя</h3>

<form method="post" action="index" modelAttribute="user">
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
            <td colspan="2" align="center"><input type="submit" value="Сохранить"></td>
        </tr>
    </table>
</form>

</body>
</html>