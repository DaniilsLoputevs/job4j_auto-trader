package hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Shared code in one place. + Base for create any ModelStore.
 *
 * @author Daniils Loputevs(laiwiense@gmail.com)
 * @since 22.10.2020.
 */
public class HbmCoreStoreApi<T> {
    private static final Logger LOG = LoggerFactory.getLogger(HbmCoreStoreApi.class);


    private final String modelClassName;
    private final HbmProvider provider = HbmProvider.instOf();

    public HbmCoreStoreApi(String modelClassName) {
        this.modelClassName = modelClassName;
    }


    public void add(T item) {
        provider.saveModel(item);
    }

    public void addAll(List<T> items) {
        provider.saveAllModel(items);
    }

    public <V> List<T> getBy(String fieldName, V value) {
        LOG.info("HBM Core: getBy() - START");
        var hql = "from " + modelClassName + " as mt where mt." + fieldName + "="
                + '\'' + value + '\'';
        LOG.info("HQL: {}", hql);
        LOG.info("HBM Core: getBy() - FINISH");
        return provider.exeQueryList(hql);
    }

    public List<T> getAll() {
        String hql = "from " + modelClassName;
        return provider.exeQueryList(hql);
    }

    public void update(T model) {
        provider.updateModel(model);
    }

    public void delete(T item) {
        provider.deleteModel(item);
    }

    public void delete(int id) {
        String hql = "delete from " + modelClassName + "where id=" + id;
        HbmProvider.instOf().exeQueryVoid(hql);
    }


    /**
     * When you use query with return List<T> but expect || want || need only one result.
     *
     * @param list  -
     * @param empty -
     * @return -
     */
    public T getFirstOrEmpty(List<T> list, T empty) {
        return (list.isEmpty()) ? empty : list.get(0);
    }
}