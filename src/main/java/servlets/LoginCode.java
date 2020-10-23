package servlets;

import models.User;
import stores.UserStore;
import util.CustomLog;
import util.ResponseWrite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCode {

    public static void registerUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        CustomLog.log("name", name);
        CustomLog.log("email", email);
        CustomLog.log("password", password);

        UserStore.instOf().add(new User(-1, name, email, password));
    }

    public static void authUser(HttpServletRequest req, HttpServletResponse resp) {
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
