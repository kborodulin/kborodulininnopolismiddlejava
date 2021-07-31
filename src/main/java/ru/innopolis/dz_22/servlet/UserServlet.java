package ru.innopolis.dz_22.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.dz_22.dao.UserDao;
import ru.innopolis.dz_22.dao.UserDaoImpl;
import ru.innopolis.dz_22.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static ru.innopolis.dz_22.utils.ServletUtils.*;

@WebServlet("/index")
public class UserServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);
    private UserDao userDao = new UserDaoImpl();
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("doGet: /index");
        // Выведем на форму список всех пользователей
        req.setAttribute("users", userDao.getAllUsers());
        req.getRequestDispatcher(JSP_PATH_INDEX).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOGGER.debug("doPost: /index");
        // С клиентской формы создаем нового пользователя
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        user = new User.Builder(
                req.getParameter(LOGIN),
                req.getParameter(PASSWORD),
                req.getParameter(NAME),
                req.getParameter(SURNAME),
                req.getParameter(PATRONYMIC)
        ).setEmail(req.getParameter(EMAIL)).setPhone(req.getParameter(PHONE)).build();
        userDao.addUser(user);
        LOGGER.info("Добавлен пользователь: {}", user);
        resp.sendRedirect("index");
    }
}