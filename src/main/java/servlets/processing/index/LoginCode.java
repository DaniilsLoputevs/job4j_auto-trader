package servlets.processing.index;

import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stores.UserStore;
import util.ResponseWrite;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static util.RequestUtil.getStr;

public class LoginCode {
    private static final Logger LOG = LoggerFactory.getLogger(LoginCode.class);

    public static void registerUser(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        LOG.info("registerUser() - START");
        String desc = getStr(req, "desc");
        String email = getStr(req, "email");
        String password = getStr(req, "password");

        UserStore.instOf().add(new User(-1, desc, email, password));
        LOG.info("registerUser() - FINISH");
    }

    public static void authUser(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        LOG.info("authUser() - START");
        resp.setContentType("text/json");

        String email = getStr(req, "email");
        String password = getStr(req, "password");

        User user = UserStore.instOf().getByEmail(email);
        String answer;

        if (user.getName() != null) {
            answer = (user.getPassword().equals(password))
                    ? user.getName() : "incorrect Password.";
        } else {
            answer = "user Not Founded.";
        }
        ResponseWrite.writeJacksonObjectMapper(resp, answer);
        LOG.info("authUser() - FINISH");
    }
}
