package servlets.controller;

import util.CustomLog;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("server_action");

        CustomLog.log("BackEndServlet: server_action", action);

        ServerCore.processing(req, resp, this, action);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("server_action");

        CustomLog.log("BackEndServlet: server_action", action);

        ServerCore.processing(req, resp, this, action);
    }
}
