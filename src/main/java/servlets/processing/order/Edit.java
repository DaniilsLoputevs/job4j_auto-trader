package servlets.processing.order;

import util.CustomLog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Edit {
    public static void saveOrder(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        CustomLog.log("START saveOrder()");

//        resp.setContentType("text/json");
//        List<Order> ordersList = OrderStore.instOf().getAll();
//
//        String ordersJson = JsonMapper.ordersForIndexTable(ordersList);
//
//        ResponseWrite.write(resp, ordersJson);
        CustomLog.log("FINISH saveOrder()");
    }

}
