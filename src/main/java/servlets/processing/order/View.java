package servlets.processing.order;

import models.Order;
import models.views.OrderView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stores.OrderStore;
import util.ResponseWrite;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static util.RequestUtil.getInt;

public class View {
    private static final Logger LOG = LoggerFactory.getLogger(Edit.class);

    public static void getOrder(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        LOG.info("getOrder() - START");
        int orderId = getInt(req, "orderId");
        Order order = OrderStore.instOf().getById(orderId);
        String jsonStringDto = OrderView.jsonMapFull(order);
        ResponseWrite.write(resp, jsonStringDto);
        LOG.info("getOrder() - FINISH");
    }

}
