package servlets.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlets.processing.index.IndexCode;
import servlets.processing.index.LoginCode;
import servlets.processing.order.Edit;
import servlets.processing.order.View;
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
    private static final Logger LOG = LoggerFactory.getLogger(ServerCore.class);


    private static final Map<
            String,
            TriConsumer<HttpServletRequest, HttpServletResponse, HttpServlet>
            > SERVER_COMMANDS = initServerCommands();

    private static Map<String,
            TriConsumer<HttpServletRequest, HttpServletResponse, HttpServlet>> initServerCommands() {
        Map<String, TriConsumer<HttpServletRequest, HttpServletResponse, HttpServlet>> serverCommands = new HashMap<>();

        serverCommands.put("INDEX:REG_USER", LoginCode::registerUser);
        serverCommands.put("INDEX:AUTH_USER", LoginCode::authUser);
        serverCommands.put("INDEX:GET_TABLE", IndexCode::getTable);

        /* Multi-Part-Form requests */

        serverCommands.put("ORDER_EDIT:SAVE_ORDER", Edit::saveOrder);
        serverCommands.put("ORDER_EDIT:GET_ORDER", Edit::getOrder);

        serverCommands.put("ORDER_VIEW:GET_ORDER", View::getOrder);

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
            LOG.error("Unknown server action: {}", serverAction);
            LOG.error("Please check this parameter in AJAX or in initServerCommands() method");
        }
    }

}
