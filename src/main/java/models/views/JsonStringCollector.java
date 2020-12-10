package models.views;

import java.util.List;

/**
 * JsonStringCollector - manual JSON writer.
 * Use thi API for collect PART of object OR warp pair of key-value into json string.
 *
 * @author Daniils Loputevs
 * @since 16.10.2020.
 */
public class JsonStringCollector {

    public static String wrapList(List<String> pairsList) {
        return wrapCore('[', ']', pairsList);
    }

    public static String wrapList(String... pairsList) {
        return wrapCore('[', ']', pairsList);
    }

    public static String wrapObject(List<String> pairs) {
        return wrapCore('{', '}', pairs);
    }

    public static String wrapObject(String... pairs) {
        return wrapCore('{', '}', pairs);
    }

    private static String wrapCore(char firstWrap, char secondWrap, String... pairs) {
        if (pairs.length != 0) {
            var rsl = new StringBuilder();

            for (int i = 0; i < pairs.length; i++) {
                rsl.append(pairs[i]);
                if (i <= pairs.length - 2) {
                    rsl.append(", ");
                }
            }
            return firstWrap + rsl.toString() + secondWrap;
        } else {
            return String.valueOf(firstWrap + ' ' + firstWrap);
        }
    }

    private static String wrapCore(char firstWrap, char secondWrap, List<String> pairs) {
        if (!pairs.isEmpty()) {
            var rsl = new StringBuilder();

            for (int i = 0; i < pairs.size(); i++) {
                rsl.append(pairs.get(i));
                if (i <= pairs.size() - 2) {
                    rsl.append(", ");
                }
            }
            return firstWrap + rsl.toString() + secondWrap;
        } else {
            return String.valueOf(firstWrap + ' ' + firstWrap);
        }
    }


    public static String collect(String name, String object) {
        String firstPart = "\"" + name + "\":";
        if (object == null || object.startsWith("[") || object.startsWith("{")) {
            return firstPart + object;
        } else {
            return firstPart + "\"" + object + "\"";
        }

    }

    public static String collect(String name, int num) {
        return "\"" + name + "\":" + num;
    }

    public static String collect(String name, boolean bool) {
        return "\"" + name + "\":" + bool;
    }

}
