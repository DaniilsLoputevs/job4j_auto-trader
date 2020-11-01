package models.views;

import models.Order;

import static util.JsonCollector.collect;
import static util.JsonCollector.wrapObject;

public class OrderView {

    /**
     * @deprecated
     * It need for avoid send user private data. Login, Password and etc.
     *
     * @param order -
     * @return (String) json obj:
     * {
     * "id":int,
     * "img":String
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
}
