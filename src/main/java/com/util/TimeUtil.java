package com.util;

import java.sql.Timestamp;

/**
 * @author xtaod
 */
public class TimeUtil {
    public static Timestamp formDataToTimestamp(String data) {
        return Timestamp.valueOf(data.replace("T", " ") + ":00");
    }
}
