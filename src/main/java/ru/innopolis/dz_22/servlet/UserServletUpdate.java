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

@WebServlet("/update")
public class UserServletUpdate extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServletUpdate.class);
    private UserDao userDao = new UserDaoImpl();
    private User user = new User();
    private Integer id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("doGet: /update");
        id = Integer.valueOf(req.getParameter(ID));
        req.getRequestDispatcher(JSP_PATH_UPDATE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOGGER.debug("doPost: /update");
        // Обновляем пользователя
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        user.setId(id);
        user.setLogin(req.getParameter(LOGIN));
        user.setPassword(req.getParameter(PASSWORD));
        user.setName(req.getParameter(NAME));
        user.setSurname(req.getParameter(SURNAME));
        user.setPatronymic(req.getParameter(PATRONYMIC));
        user.setEmail(req.getParameter(EMAIL));
        user.setPhone(req.getParameter(PHONE));
        userDao.updateUser(user);
        LOGGER.info("Пользователь обновлен: {}", user);
        resp.sendRedirect("index");
    }
}