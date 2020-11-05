package stores;

import hibernate.HbmCoreStoreApi;
import models.User;

public class UserStore {
    private static class LazyHolder {
        static final UserStore INSTANCE = new UserStore();
    }

    public static UserStore instOf() {
        return LazyHolder.INSTANCE;
    }

    /* Class description */
    private final HbmCoreStoreApi<User> core = new HbmCoreStoreApi<>("User");


    public void add(User user) {
        core.add(user);
    }

    public User getByEmail(String email) {
        var temp = core.getBy("email", email);
        return core.getFirstOrEmpty(temp, new User());
    }

    public User getByName(String name) {
        var temp = core.getBy("name", name);
        return core.getFirstOrEmpty(temp, new User());
    }

    public void delete(int id) {
        core.delete(id);
    }
}
