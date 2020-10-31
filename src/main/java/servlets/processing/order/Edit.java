package servlets.processing.order;

import models.Car;
import models.ImgAlbum;
import models.Order;
import models.User;
import stores.OrderStore;
import stores.UserStore;
import util.CustomLog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Edit {
    public static void saveOrder(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        CustomLog.log("START saveOrder()");

        int orderId = Integer.parseInt(req.getParameter("orderId"));
//        int carId = Integer.parseInt(req.getParameter("orderId"));
        Order order;

        if (orderId == 0) {
            Car car = new Car(
                    Integer.parseInt(req.getParameter("orderId")),
                    req.getParameter("carBrand"),
                    req.getParameter("carModel"),
                    Integer.parseInt(req.getParameter("carYear")),
                    Integer.parseInt(req.getParameter("carDoorCount")),
                    Integer.parseInt(req.getParameter("carMileage")),
                    req.getParameter("carEngine"),
                    req.getParameter("carBody"),
                    req.getParameter("carTransmission"),
                    req.getParameter("carFuelType")
            );
            User seller = UserStore.instOf().getByName(req.getParameter("orderSeller"));

            ImgAlbum album = new ImgAlbum(0, extractImgFromRequest(req));

            order = new Order(0,
                    album,
                    req.getParameter("orderDesc"),
                    Integer.parseInt(req.getParameter("orderPrice")),
                    car,
                    req.getParameter("orderArea"),
                    seller,
                    Boolean.parseBoolean(req.getParameter("orderSold"))
                    );

            CustomLog.log("order", order);

            OrderStore.instOf().add(order);
        } else {
            order = OrderStore.instOf().getById(orderId);

//            OrderStore.instOf().update(order);
        }

        CustomLog.log("FINISH saveOrder()");
    }

    private static List<byte[]> extractImgFromRequest(HttpServletRequest req) {
        List<byte[]> rsl = new ArrayList<>();
        try {
            Part filePart = req.getPart("orderImg");

            try (InputStream fileContent = filePart.getInputStream()) {
                rsl.add(fileContent.readAllBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        return rsl;
    }

}
