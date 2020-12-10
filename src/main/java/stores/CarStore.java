package stores;

import hibernate.HbmCoreStoreApi;
import models.Car;

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
        return core.getFirstOrEmpty(temp, new Car());
    }

    public Car getByName(String name) {
        var temp = core.getBy("name", name);
        return core.getFirstOrEmpty(temp, new Car());
    }

    public void delete(int id) {
        core.delete(id);
    }

}
