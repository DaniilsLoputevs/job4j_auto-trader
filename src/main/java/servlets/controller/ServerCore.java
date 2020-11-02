package servlets.controller;

import servlets.processing.index.IndexCode;
import servlets.processing.index.LoginCode;
import servlets.processing.order.Edit;
import util.CustomLog;
import util.TriConsumer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class what processing request.
 *
 * @author Daniils Loputevs(laiwiense@gmail.com)
 * @since 29.10.2020.
 */
public class ServerCore {

    private static final Map<
            String,
            TriConsumer<HttpServletRequest, HttpServletResponse, HttpServlet>
            > SERVER_COMMANDS = initServerCommands();

    private static Map<String,
            TriConsumer<HttpServletRequest, HttpServletResponse, HttpServlet>> initServerCommands() {
        Map<String, TriConsumer<HttpServletRequest, HttpServletResponse, HttpServlet>> serverCommands = new HashMap<>();

        serverCommands.put("REG_USER", LoginCode::registerUser);
        serverCommands.put("AUTH_USER", LoginCode::authUser);

        serverCommands.put("INDEX:GET_TABLE", IndexCode::getTable);

        /* Multi-Part-Form requests */

        serverCommands.put("ORDER_EDIT:SAVE_ORDER", Edit::saveOrder);
        serverCommands.put("ORDER_EDIT:GET_ORDER", Edit::getOrder);

        return serverCommands;
    }

    /**
     * @param req          -
     * @param resp         -
     * @param servlet      - servlet. - It need for more flexible processing.
     *                     example: get access to the servlet config or context.
     * @param serverAction - parameter that choose the processing method.
     */
    public static void processing(HttpServletRequest req, HttpServletResponse resp,
                                  HttpServlet servlet, String serverAction) {
        var action = SERVER_COMMANDS.get(serverAction);
        if (action != null) {
            action.accept(req, resp, servlet);
        } else {
            CustomLog.log("WARNING! unknown server action: " + serverAction);
            CustomLog.log("Please check this parameter in AJAX or in initServerCommands() method.");
        }
    }

}
