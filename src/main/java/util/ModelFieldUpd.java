package util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModelFieldUpd {
    /**
     * short-cut fort for upd field of object.
     *
     * @param getter - method reference. Example: obj::getName
     * @param newVal - value that set if not equal.
     * @param setter - method reference. Example: obj::setName
     */
    public static void updFieldIfNotEqual(Supplier<String> getter, String newVal, Consumer<String> setter) {
        String oldVal = getter.get();
        if (oldVal != null) {
            if (!oldVal.equals(newVal)) {
                setter.accept(newVal);
            }
        } else {
            setter.accept(newVal);
        }
    }
    /**
     * short-cut fort for upd field of object.
     *
     * @param getter - method reference. Example: obj::getName
     * @param newVal - value that set if not equal.
     * @param setter - method reference. Example: obj::setName
     */
    public static void updFieldIfNotEqual(Supplier<Integer> getter, int newVal, Consumer<Integer> setter) {
        int oldVal = getter.get();
        if (oldVal != newVal) {
            setter.accept(newVal);
        }
    }
}
