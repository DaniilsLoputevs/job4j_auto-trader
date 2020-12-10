package models.views;

import models.Order;
import util.DateStrFormat;

import static models.views.JsonStringCollector.collect;
import static models.views.JsonStringCollector.wrapObject;

public class OrderView {

    /**
     * @param order -
     * @return (String) json obj:
     * {
     * "id":int,
     * "img":MappedObj(ImgAlbumView), - first img encoded Base64
     * "desc":String,
     * "price":int,
     * "car": MappedObj(Car), - full mapped
     * "area":String,
     * "seller":MappedObj(User), - only name
     * "isSold":boolean
     * "created":String (Date to Sting by pattern)
     * }
     */
    public static String jsonMapFullAsUsual(Order order) {
        return wrapObject(
                collect("id", order.getId()),
                collect("img", ImgAlbumView.jsonMapFirstImg(order.getImgAlbum())),
                collect("desc", order.getDescription()),
                collect("price", order.getPrice()),
                collect("car", CarView.jsonMapFull(order.getCar())),
                collect("area", order.getArea()),
                collect("seller", UserView.jsonMapOnlyName(order.getSeller())),
                collect("isSold", order.isSold()),
                collect("created", DateStrFormat.toFront(order.getCreated()))
        );
    }
    /**
     * @param order -
     * @return (String) json obj:
     * {
     * "id":int,
     * "img":MappedObj(ImgAlbumView), - first img encoded Base64
     * "desc":String,
     * "price":int,
     * "car": MappedObj(Car), - full mapped
     * "area":String,
     * "seller":MappedObj(User), - name && email
     * "isSold":boolean
     * "created":String (Date to Sting by pattern)
     * }
     */
    public static String jsonMapFull(Order order) {
        return wrapObject(
                collect("id", order.getId()),
                collect("img", ImgAlbumView.jsonMapFirstImg(order.getImgAlbum())),
                collect("desc", order.getDescription()),
                collect("price", order.getPrice()),
                collect("car", CarView.jsonMapFull(order.getCar())),
                collect("area", order.getArea()),
                collect("seller", UserView.jsonMapNameAndEmail(order.getSeller())),
                collect("isSold", order.isSold()),
                collect("created", DateStrFormat.toFront(order.getCreated()))
        );
    }

}
