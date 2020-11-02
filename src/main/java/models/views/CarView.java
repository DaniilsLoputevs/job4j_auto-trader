package models.views;

import models.Car;

import static util.JsonCollector.collect;
import static util.JsonCollector.wrapObject;

public class CarView {



    /**
     *
     * @param car model for prepare to front.
     * @return (String) json obj:
     * {
     *  	"brand":String,
     *  	"model":String,
     *  	"year":int,
     *      "doorCount":int,
     *      "mileage":int,
     *      "engine":String,
     * 	    "body":String,
     * 	    "transmission":String
     * 	    "fuelType":String,
     * },
     */
    public static String jsonMapFull(Car car) {
        return  wrapObject(
                collect("brand", car.getBrand()),
                collect("model", car.getModel()),
                collect("year", car.getYear()),
                collect("doorCount", car.getDoorCount()),
                collect("mileage", car.getMileage()),
                collect("engine", car.getEngine()),
                collect("body", car.getBody()),
                collect("transmission", car.getTransmission()),
                collect("fuelType", car.getFuelType())
        );
    }
}
