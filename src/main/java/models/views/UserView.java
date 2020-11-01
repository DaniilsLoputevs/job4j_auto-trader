package models.views;

import models.User;

import static util.JsonCollector.collect;
import static util.JsonCollector.wrapObject;

public class UserView {

    /**
     *
     * @param user model for prepare to front.
     * @return (String) json obj:
     * {
     *     "name":Sting
     * }
     */
    public static String jsonMapOnlyName(User user) {
        return wrapObject(collect("name", user.getName()));
    }
}
