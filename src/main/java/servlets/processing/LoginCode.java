package servlets.processing;

import models.User;
import stores.UserStore;
import util.CustomLog;
import util.ResponseWrite;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCode {

    public static void registerUser(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        String desc = req.getParameter("desc");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        CustomLog.log("desc", desc);
        CustomLog.log("email", email);
        CustomLog.log("password", password);

        UserStore.instOf().add(new User(-1, desc, email, password));
    }

    public static void authUser(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        resp.setContentType("text/json");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = UserStore.instOf().getByEmail(email);
        String answer;

        if (user.getName() != null) {
            answer = (user.getPassword().equals(password))
                    ? user.getName() : "incorrect Password.";
        } else {
            answer = "user Not Founded.";
        }
        ResponseWrite.writeJacksonObjectMapper(resp, answer);
    }
}
