package servlets.processing.index;

import models.Order;
import models.views.ViewJsonMapper;
import stores.OrderStore;
import util.ResponseWrite;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class IndexCode {

    public static void getTable(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        resp.setContentType("text/json");
        List<Order> ordersList = OrderStore.instOf().getAll();

        String ordersJson = ViewJsonMapper.ordersForIndexTable(ordersList);

        ResponseWrite.write(resp, ordersJson);
    }

}