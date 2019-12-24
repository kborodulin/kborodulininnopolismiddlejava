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

@WebServlet("/authorization")
public class UserServletAuthorization extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServletAuthorization.class);
    private UserDao userDao = new UserDaoImpl();
    private User user = new User();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (userDao.authorization(req.getParameter("login"), req.getParameter("password"))) {
            resp.sendRedirect("index");
        }
    }
}