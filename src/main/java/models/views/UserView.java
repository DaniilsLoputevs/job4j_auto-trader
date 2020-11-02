package models.views;

import models.User;

import static util.JsonCollector.collect;
import static util.JsonCollector.wrapObject;

public class UserView {

    /**
     * It need for avoid send user private data. Login, Password and etc.
     *
     * @param user model for prepare to front.
     * @return (String) json obj:
     * {
     * "name":Sting
     * }
     */
    public static String jsonMapNameAndEmail(User user) {
        return wrapObject(
                collect("name", user.getName()),
                collect("email", user.getEmail())
        );
    }
    /**
     * It need for avoid send user private data. Login, Password and etc.
     *
     * @param user model for prepare to front.
     * @return (String) json obj:
     * {
     * "name":Sting
     * }
     */
    public static String jsonMapOnlyName(User user) {
        return wrapObject(collect("name", user.getName()));
    }
}
