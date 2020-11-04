package servlets.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * url-pattern: /query-global
 */
@WebServlet(name = "BackEndServlet", value = "/back-end")
public class BackEndServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(BackEndServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("server_action");

        LOG.info("server_action: {}", action);

        ServerCore.processing(req, resp, this, action);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("server_action");

        LOG.info("server_action: {}", action);

        ServerCore.processing(req, resp, this, action);
    }
}
