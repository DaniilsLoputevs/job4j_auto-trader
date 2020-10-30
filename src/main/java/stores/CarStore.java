package stores;

import hibernate.HbmCoreStoreApi;
import models.Car;

import java.util.List;

public class CarStore {
    private static class LazyHolder {
        static final CarStore INSTANCE = new CarStore();
    }
    public static CarStore instOf() {
        return CarStore.LazyHolder.INSTANCE;
    }

    /* Class description */
    private final HbmCoreStoreApi<Car> core = new HbmCoreStoreApi<>("Car");


    public void add(Car car) {
        core.add(car);
    }

    public Car getById(int id) {
        var temp = core.getBy("id", id);
        return getCarOrEmptyUser(temp);
    }

    public Car getByName(String name) {
        var temp = core.getBy("name", name);
        return getCarOrEmptyUser(temp);
    }

    public void delete(int id) {
        var temp = new Car();
        temp.setId(id);
        core.delete(temp);
    }

    private Car getCarOrEmptyUser(List<Car> list) {
        return (list.isEmpty()) ? new Car() : list.get(0);
    }
}
