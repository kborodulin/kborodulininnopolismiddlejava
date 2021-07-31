package ru.innopolis.dz_22.utils;

public class ServletUtils {
    // Подключение к БД
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/dz_22";
    public static final String DB_LOGIN = "postgres";
    public static final String DB_PASSWORD = "postgres";
    public static final String DB_DRIVER = "org.postgresql.Driver";
    // JSP страницы
    public static final String JSP_PATH_AUTHORIZED = "WEB-INF/jsp/authorization.jsp";
    public static final String JSP_PATH_UPDATE = "WEB-INF/jsp/update.jsp";
    public static final String JSP_PATH_INDEX = "WEB-INF/jsp/index.jsp";
    // Поля
    public static final String ID = "id";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PATRONYMIC = "patronymic";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
}
