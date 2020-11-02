package servlets.processing.index;

import models.User;
import stores.UserStore;
import util.ResponseWrite;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static util.RequestUtil.getStr;

public class LoginCode {

    public static void registerUser(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        String desc = getStr(req,"desc");
        String email = getStr(req,"email");
        String password = getStr(req,"password");

        UserStore.instOf().add(new User(-1, desc, email, password));
    }

    public static void authUser(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        resp.setContentType("text/json");

        String email = getStr(req,"email");
        String password = getStr(req,"password");

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
