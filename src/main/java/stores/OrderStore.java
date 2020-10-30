package stores;

import hibernate.HbmCoreStoreApi;
import hibernate.HbmProvider;
import models.Order;

import java.util.List;

public class OrderStore {
    private static class LazyHolder {
        static final OrderStore INSTANCE = new OrderStore();
    }
    public static OrderStore instOf() {
        return OrderStore.LazyHolder.INSTANCE;
    }

    /* Class description */
    private final HbmCoreStoreApi<Order> core = new HbmCoreStoreApi<>("Order");


    public void add(Order car) {
        core.add(car);
    }

    public List<Order> getAll() {
        String temp = "select distinct mt from Order as mt "
                + "join fetch mt.car "
                + "join fetch mt.seller "
                + "join fetch mt.imgAlbum.imgList";
        return HbmProvider.instOf().exeQueryList(temp);
    }

    public Order getById(int id) {
        var temp = core.getBy("id", id);
        return getOrderOrEmptyUser(temp);
    }

    public Order getByName(String name) {
        var temp = core.getBy("name", name);
        return getOrderOrEmptyUser(temp);
    }

    public void delete(int id) {
        var temp = new Order();
        temp.setId(id);
        core.delete(temp);
    }

    private Order getOrderOrEmptyUser(List<Order> list) {
        return (list.isEmpty()) ? new Order() : list.get(0);
    }
}
