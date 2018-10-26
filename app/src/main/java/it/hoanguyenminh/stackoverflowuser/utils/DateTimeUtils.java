package it.hoanguyenminh.stackoverflowuser.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());

    public static String formatDate(long time) {
        return sdf.format(new Date(time));
    }
}

