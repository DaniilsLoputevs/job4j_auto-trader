package servlets;

import util.CustomLog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * url-pattern: /query-global
 */
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("server_action");

        CustomLog.log("QueryServlet: server_action", action);
        ServerCore.processing(req, resp, action);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("server_action");

        CustomLog.log("QueryServlet: server_action", action);
        ServerCore.processing(req, resp, action);
    }
}
