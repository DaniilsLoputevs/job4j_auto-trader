package hibernate;

import models.Car;
import models.ImgAlbum;
import models.Order;
import models.User;
import stores.CarStore;
import stores.OrderStore;
import stores.UserStore;
import util.SerializeFile;

import java.io.File;
import java.util.List;

public class HbmManualTableWork {
    public static void main(String[] args) {
//        ServerCore.apply(null, null, "something");
//        var temp = new User(0, "testName", "tEmail", "tPassword");
//        UserStore.instOf().add(temp);


        Car car = new Car(0, "carBrand1", "carModel1", 1234, 5, 4444,
                "carEngine1", "carBody1", "carTransmission1", "carFuel1");


        CarStore.instOf().add(car);
//        HbmProvider.instOf().updateModel(car);

//        Car car = CarStore.instOf().getByName("name");
        User seller = UserStore.instOf().getByName("root");
//        User seller = new User(0, "root", "root", "root");
//        UserStore.instOf().add(seller);

        ImgAlbum album = new ImgAlbum(
                0, List.of(
//                SerializeFile.bytes(new File("https://pbs.twimg.com/media/ESS-l23XsAM4f0o.jpg"))
                SerializeFile.bytes(new File("C:/Users/Admin/Desktop/anime_devushki_bosye_6_18092134.png"))
        ));
        HbmProvider.instOf().saveModel(album);

        Order order = new Order(0, album, "orderDesc1",
                100, car, "OrderArea1", seller, true);
        OrderStore.instOf().add(order);
//        HbmProvider.instOf().updateModel(order);

//        var rsl = OrderStore.instOf().getById(1);
//        System.out.println(rsl);

//        System.out.println(OrderStore.instOf().getAll());


//        var list = OrderStore.instOf().getAll();
//        var list = List.of(order);
//        var temp = DataConvertToJson.ordersForIndexTable(list);
//        CustomLog.log("test", temp);
    }

}
