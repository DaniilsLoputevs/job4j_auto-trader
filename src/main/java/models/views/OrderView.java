package models.views;

import models.Order;

import static util.JsonCollector.collect;
import static util.JsonCollector.wrapObject;

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
                collect("isSold", order.isSold())
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
                collect("isSold", order.isSold())
        );
    }
}
