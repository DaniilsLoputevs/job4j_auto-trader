package servlets;

import servlets.processing.OtherCode;
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

        serverCommands.put("OTHER:GET_IMG_ALBUM_BY_ID", OtherCode::getImgAlbumById);
        serverCommands.put("OTHER:SAVE_IMG_ALBUM", OtherCode::saveImgAlbum);

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

//    /**
//     * Specially for request with param: enctype: 'multipart/form-data'.
//     *
//     * @param req     -
//     * @param resp    -
//     * @param servlet - servlet. - It need for more flexible processing.
//     *                example: get access to the servlet config or context.
//     */
//    public static void processingMultiPartForm(HttpServletRequest req,
//                                               HttpServletResponse resp,
//                                               HttpServlet servlet) {
////        var action = serverAvailableCommands.get(serverAction);
////        if (action != null) {
////            action.accept(req, resp, servlet);
////        } else {
////            CustomLog.log("WARNING! unknown server action: " + serverAction);
////            CustomLog.log("Please check this parameter in AJAX or in initServerCommands() method.");
////        }
//
//
//
//        try {
//            System.out.println("getPart(): ");
//            System.out.println("server_action: " +  req.getPart("server_action"));
//            System.out.println("data: " + req.getPart("data"));
//            System.out.println("img: " + req.getPart("img"));
//
//            System.out.println("getParameter(): ");
//            System.out.println("server_action: " +  req.getParameter("server_action"));
//            System.out.println("data: " + req.getParameter("data"));
//            System.out.println("img: " + req.getParameter("img"));
//
//
//        } catch (IOException | ServletException e) {
//            e.printStackTrace();
//        }
//
//
//
////        for (FileItem item : formItems) {
////            if (item.isFormField()) {
////                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
////                String fieldname = item.getFieldName();
////                String fieldvalue = item.getString();
////                // ... (do your job here)
////            } else {
////                // Process form file field (input type="file").
////                String fieldname = item.getFieldName();
////                String filename = FilenameUtils.getName(item.getName());
////                InputStream filecontent = item.getInputStream();
////                // ... (do your job here)
////            }
////        }
//    }
}
