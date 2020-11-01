package models.views;

import models.Order;
import util.JsonCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Prepare data before write in Response and send to Front-end.
 * It looks like DTO but already in JSON String.
 */
public class ViewJsonMapper {

    /**
     * @deprecated
     * @param orders -
     * @return List of json objects: {
     * "id":int,
     * "desc":String,
     * "price":int,
     * "car": {
     *  	"brand":String,
     *  	"model":String,
     *  	"year":int,
     *      "doorCount":int,
     *      "doorCount":int,
     *      "engine":String,
     * 	    "body":String,
     * 	    "transmission":String
     * 	    "fuelType":String,
     * },
     * "area":String,
     * "seller":String,
     * "isSold":boolean
     * }
     */
    public static String ordersForIndexTable(List<Order> orders) {
        List<String> rsl = new ArrayList<>();
        orders.forEach(order -> rsl.add(OrderView.jsonMapFullAsUsual(order)));
        return JsonCollector.wrapList(rsl);
    }


}
