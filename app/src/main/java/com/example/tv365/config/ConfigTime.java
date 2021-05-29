package com.example.tv365.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Windows 10 Now on 3/6/2018.
 */

public class ConfigTime {
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    public static String getTimeAgo(long time) {
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000;
        }

        long now = System.currentTimeMillis();
        ;
        if (time > now || time <= 0) {
            return null;
        }

        // TODO: localize
        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "bây giờ";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "một phút trước";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " phút trước";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "một giờ trước";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " giờ trước";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "ngày hôm qua";
        } else if (diff > 15 * DAY_MILLIS) {
            if (diff < 30 * DAY_MILLIS) {
                return diff / DAY_MILLIS + " ngày trước";
            } else {
                int div = (int) (diff / DAY_MILLIS) / 30;
                return div + " tháng trước";
            }
        } else {
            return diff / DAY_MILLIS + " ngày trước";
        }
    }

    public static String convertTimeFromApi(String sTime) {
        if (sTime!= null && !sTime.isEmpty()) {
            long creatTime = Long.parseLong(sTime) * 1000;
            Date Date = new Date(creatTime);
            SimpleDateFormat formatDateToString = new SimpleDateFormat("dd/MM/yyyy");
            String sDate = formatDateToString.format(Date);
            return sDate;
        }
        return "Chưa cập nhật";
    }
}
