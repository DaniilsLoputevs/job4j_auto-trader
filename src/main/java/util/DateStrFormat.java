package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStrFormat {
    public static final String PATTERN_TABLE_TIMESTAMP = "yyyy-MM-dd";

    private static final SimpleDateFormat SDF = new SimpleDateFormat(PATTERN_TABLE_TIMESTAMP);

    public static String toFront(Date date) {
        return (date != null) ? SDF.format(date) : "date is null";
    }

}
