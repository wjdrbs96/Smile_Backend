package com.smile.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * created by Gyunny 2021/11/04
 */
public class LocalDateTimeToStringUtil {

    public static String localDateTimeToStringConverter(LocalDateTime localDateTime) {
        return localDateTime.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME);
    }

}
