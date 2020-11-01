package servlets.controller;

import util.CustomLog;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MPF - Multi-Part-Form
 * Use this servlet for ACCEPT Multi-Part-Form requests from Front-end.
 * Then process it as in usual ServerCore.
 */
@MultipartConfig
@WebServlet(name = "BackEndServletMPF", value = "/back-end-mpf")
public class BackEndServletMPF extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("server_action");

        CustomLog.log("BackEndServletMPF: server_action", action);

        ServerCore.processing(req, resp, this, action);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("server_action");

        CustomLog.log("BackEndServletMPF: server_action", action);

        ServerCore.processing(req, resp, this, action);
    }

}