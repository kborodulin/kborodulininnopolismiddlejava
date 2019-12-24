package ru.innopolis.dz_22.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.dz_22.dao.UserDao;
import ru.innopolis.dz_22.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class UserServletDelete extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServletDelete.class);
    private UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDao.deleteUser(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("index");
    }
}
