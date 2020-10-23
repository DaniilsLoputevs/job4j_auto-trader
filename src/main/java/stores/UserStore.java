package stores;

import hibernate.HbmCoreStoreApi;
import models.User;

import java.util.List;

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
        return getUserOrEmptyUser(temp);
    }

    public User getByName(String name) {
        var temp = core.getBy("name", name);
        return getUserOrEmptyUser(temp);
    }

    public void delete(int id) {
        var temp = new User();
        temp.setId(id);
        core.delete(temp);
    }

    private User getUserOrEmptyUser(List<User> list) {
        return (list.isEmpty()) ? new User() : list.get(0);
    }
}
