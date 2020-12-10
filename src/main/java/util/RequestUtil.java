package util;

import javax.servlet.http.HttpServletRequest;

/**
 * short-cut for get param from front-end.
 * It's using in much places and short-cut make it more readable.
 */
public class RequestUtil {

    public static String getStr(HttpServletRequest req, String key) {
        return req.getParameter(key);
    }

    public static int getInt(HttpServletRequest req, String key) {
        return Integer.parseInt(req.getParameter(key));
    }

    public static boolean getBool(HttpServletRequest req, String key) {
        return Boolean.parseBoolean(req.getParameter(key));
    }

}
