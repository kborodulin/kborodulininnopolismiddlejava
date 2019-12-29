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
import java.nio.charset.StandardCharsets;

import static ru.innopolis.dz_22.utils.ServletUtils.*;

@WebServlet("/authorization")
public class UserServletAuthorization extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServletAuthorization.class);
    private UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("doGet: /authorization");
        req.getRequestDispatcher(JSP_PATH_AUTHORIZED).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOGGER.debug("doPost: /authorization");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        if (userDao.isAuthorized(req.getParameter(LOGIN), req.getParameter(PASSWORD))) {
            resp.sendRedirect("index");
        }
    }
}