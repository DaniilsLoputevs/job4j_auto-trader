package models.webmapping;

import models.Car;
import models.Order;
import util.JsonCollector;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

import static util.JsonCollector.collect;
import static util.JsonCollector.wrapObject;

/**
 * Prepare data before write in Response and send to Front-end.
 */
public class JsonMapper {

    /**
     * It need for avoid send user private data. Login, Password and etc.
     *
     * @param orders -
     * @return List of objects: {
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
        for (var each : orders) {
            // prepare data
            String imgBase64 = "";
            var tempList = each.getImgAlbum().getImgList();
            if (!tempList.isEmpty()) {
                imgBase64 = DatatypeConverter.printBase64Binary(tempList.get(0));
            }
            Car eachCar = each.getCar();

            rsl.add(wrapObject(
                    collect("id", each.getId()),
                    collect("imgBase64", imgBase64),
                    collect("desc", each.getDescription()),
                    collect("price", each.getPrice()),
                    collect("car",  wrapObject(
                            collect("brand", eachCar.getBrand()),
                            collect("model", eachCar.getModel()),
                            collect("year", eachCar.getYear()),
                            collect("doorCount", eachCar.getDoorCount()),
                            collect("mileage", eachCar.getMileage()),
                            collect("engine", eachCar.getEngine()),
                            collect("body", eachCar.getBody()),
                            collect("transmission", eachCar.getTransmission()),
                            collect("fuelType", eachCar.getFuelType())
                    )),
                    collect("area", each.getArea()),
                    collect("seller", each.getSeller().getName()),
                    collect("isSold", each.isSold()))
            );
        }
        return JsonCollector.wrapList(rsl);
    }
}
