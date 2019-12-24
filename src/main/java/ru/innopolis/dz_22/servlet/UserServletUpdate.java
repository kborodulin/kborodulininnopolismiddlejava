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

@WebServlet("/update")
public class UserServletUpdate extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServletUpdate.class);
    private UserDao userDao = new UserDaoImpl();
    private User user = new User();
    private Integer id = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.valueOf(req.getParameter("id"));
        req.getRequestDispatcher("WEB-INF/jsp/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Обновляем пользователя
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        user.setId(id);
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setPatronymic(req.getParameter("patronymic"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));
        userDao.updateUser(user);
        LOGGER.info("Пользователь обновлен: {}", user);
        resp.sendRedirect("index");
    }
}