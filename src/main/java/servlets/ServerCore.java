package servlets;

import util.CustomLog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Main class what processing request.
 *
 * @since 22.10.2020.
 * @author Daniils Loputevs(laiwiense@gmail.com)
 */
public class ServerCore {

    private static final Map<String, BiConsumer<HttpServletRequest, HttpServletResponse>>
            serverAvailableCommands = initServerCommands();

    private static Map<String, BiConsumer<HttpServletRequest, HttpServletResponse>> initServerCommands() {
        Map<String, BiConsumer<HttpServletRequest, HttpServletResponse>> serverCommands = new HashMap<>();
//        serverCommands.put("something", IndexCode::doSomething);
        serverCommands.put("REG_USER", LoginCode::registerUser);
        serverCommands.put("AUTH_USER", LoginCode::authUser);

        return serverCommands;
    }

    public static void processing(HttpServletRequest req, HttpServletResponse resp, String serverAction) {
        var action = serverAvailableCommands.get(serverAction);
        if (action != null) {
            action.accept(req, resp);
        } else {
            CustomLog.log("WARNING! unknown server action: " + serverAction);
            CustomLog.log("Please check this parameter in AJAX or in initServerCommands() method.");
        }
    }

}
