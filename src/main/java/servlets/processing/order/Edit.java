package servlets.processing.order;

import models.Car;
import models.ImgAlbum;
import models.Order;
import models.User;
import models.views.OrderView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stores.OrderStore;
import stores.UserStore;
import util.ResponseWrite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.ModelFieldUpd.updFieldIfNotEqual;
import static util.RequestUtil.*;

public class Edit {
    private static final Logger LOG = LoggerFactory.getLogger(Edit.class);

    /**
     * add new OR upd exists order.
     *
     * @param req     -
     * @param resp    -
     * @param servlet -
     */
    public static void saveOrder(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        LOG.info("saveOrder() - START");

        int orderId = getInt(req, "orderId");
        Order order;
        LOG.info("orderId: {}", orderId);

        if (orderId == 0) {
            order = createOrderByRequestParams(req);
            OrderStore.instOf().add(order);
        } else {
            order = OrderStore.instOf().getById(orderId);
            updateOrderByRequestParams(order, req);
            OrderStore.instOf().update(order);
        }
        LOG.info("saveOrder() - FINISH");
    }


    public static void getOrder(HttpServletRequest req, HttpServletResponse resp, HttpServlet servlet) {
        LOG.info("getOrder() - START");
        int orderId = getInt(req, "orderId");
        Order order = OrderStore.instOf().getById(orderId);
        String jsonStringDto = OrderView.jsonMapFullAsUsual(order);
        ResponseWrite.write(resp, jsonStringDto);
        LOG.info("getOrder() - FINISH");
    }

    private static Order createOrderByRequestParams(HttpServletRequest req) {
        Car car = new Car(
                getInt(req, "orderId"),
                getStr(req, "carBrand"),
                getStr(req, "carModel"),
                getInt(req, "carYear"),
                getInt(req, "carDoorCount"),
                getInt(req, "carMileage"),
                getStr(req, "carEngine"),
                getStr(req, "carBody"),
                getStr(req, "carTransmission"),
                getStr(req, "carFuelType")
        );

        ImgAlbum album = new ImgAlbum(0, extractImgFromRequest(req));
        User seller = UserStore.instOf().getByName(getStr(req, "orderSeller"));

        return new Order(0,
                album,
                getStr(req, "orderDesc"),
                getInt(req, "orderPrice"),
                car,
                getStr(req, "orderArea"),
                seller,
                getBool(req, "orderSold")
        );
    }

    /**
     * set new value fot Order fields if it isn't equals with new.
     * Fields that miss upd check because don't need it: id, seller, isSold.
     *
     * @param ord -
     * @param req -
     */
    private static void updateOrderByRequestParams(Order ord, HttpServletRequest req) {
        Car car = ord.getCar();

        updOrderImgAlbumIfNotNull(req, ord);

        updFieldIfNotEqual(ord::getDescription, getStr(req, "orderDesc"), ord::setDescription);
        updFieldIfNotEqual(ord::getPrice, getInt(req, "orderPrice"), ord::setPrice);
        updFieldIfNotEqual(ord::getArea, getStr(req, "orderArea"), ord::setArea);

        updFieldIfNotEqual(car::getBrand, getStr(req, "carBrand"), car::setBrand);
        updFieldIfNotEqual(car::getModel, getStr(req, "carModel"), car::setModel);
        updFieldIfNotEqual(car::getYear, getInt(req, "carYear"), car::setYear);
        updFieldIfNotEqual(car::getDoorCount, getInt(req, "carDoorCount"), car::setDoorCount);
        updFieldIfNotEqual(car::getMileage, getInt(req, "carMileage"), car::setMileage);
        updFieldIfNotEqual(car::getEngine, getStr(req, "carEngine"), car::setEngine);
        updFieldIfNotEqual(car::getBody, getStr(req, "carBody"), car::setBody);
        updFieldIfNotEqual(car::getTransmission, getStr(req, "carTransmission"), car::setTransmission);
        updFieldIfNotEqual(car::getFuelType, getStr(req, "carFuelType"), car::setFuelType);
    }

    private static void updOrderImgAlbumIfNotNull(HttpServletRequest req, Order order) {
        try {
            Part filePart = req.getPart("orderImg");
            if (filePart != null) {
                order.setImgAlbum(new ImgAlbum(0, extractImgFromRequest(req)));
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }


    private static List<byte[]> extractImgFromRequest(HttpServletRequest req) {
        List<byte[]> rsl = new ArrayList<>();
        try {
            Part filePart = req.getPart("orderImg");

            try (InputStream fileContent = filePart.getInputStream()) {
                rsl.add(fileContent.readAllBytes());
                System.out.println("bytes: " + Arrays.toString(fileContent.readAllBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        return rsl;
    }

}
