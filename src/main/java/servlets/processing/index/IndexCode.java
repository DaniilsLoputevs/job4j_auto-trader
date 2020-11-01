package servlets.processing.index;

import models.Order;
import models.views.ViewJsonMapper;
import stores.OrderStore;
import util.CustomLog;
import util.ResponseWrite;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class IndexCode {

    public static void getTable(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        CustomLog.log("START getTable()");

        resp.setContentType("text/json");
        List<Order> ordersList = OrderStore.instOf().getAll();

        String ordersJson = ViewJsonMapper.ordersForIndexTable(ordersList);

        ResponseWrite.write(resp, ordersJson);
        CustomLog.log("FINISH getTable()");
    }

    /* template */
//    public static void doSomething(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println("Print something!");
//    }

}