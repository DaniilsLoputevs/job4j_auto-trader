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
     * @param orders -
     * @return List of json objects:
     * {
     * "id":int,
     * "img":MappedObj(ImgAlbumView), - first img encoded Base64
     * "desc":String,
     * "price":int,
     * "car": MappedObj(Car), - full mapped
     * "area":String,
     * "seller":MappedObj(User), - only name
     * "isSold":boolean
     * }
     */
    public static String ordersForIndexTable(List<Order> orders) {
        List<String> rsl = new ArrayList<>();
        orders.forEach(order -> rsl.add(OrderView.jsonMapFullAsUsual(order)));
        return JsonCollector.wrapList(rsl);
    }


}
