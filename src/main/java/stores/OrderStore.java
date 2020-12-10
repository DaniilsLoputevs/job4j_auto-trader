package stores;

import hibernate.HbmCoreStoreApi;
import hibernate.HbmProvider;
import models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderStore {
    private static final Logger LOG = LoggerFactory.getLogger(OrderStore.class);


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
        LOG.info("HBM OrderStore: getAll() - START");
        String hql = "select distinct mt from Order as mt "
                + "join mt.car "
                + "join mt.seller "
                + "join mt.imgAlbum.imgList";
        LOG.info("HQL: {}", hql);
        LOG.info("HBM OrderStore: getAll() - FINISH");
        return HbmProvider.instOf().exeQueryList(hql);
    }

    public Order getById(int id) {
        LOG.info("HBM OrderStore: getAll() - START");
        String hql = "select distinct mt from Order as mt "
                + "join mt.car "
                + "join mt.seller "
                + "join mt.imgAlbum.imgList "
                + "where mt.id=" + id;
        List<Order> temp = HbmProvider.instOf().exeQueryList(hql);
        LOG.info("HQL: {}", hql);
        LOG.info("HBM OrderStore: getById() - FINISH");
        return core.getFirstOrEmpty(temp, new Order());
    }

    public void delete(int id) {
        core.delete(id);
    }

    public void update(Order order) {
        core.update(order);
    }
}
