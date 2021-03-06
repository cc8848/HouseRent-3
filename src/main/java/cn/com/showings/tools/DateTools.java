package cn.com.showings.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wu on 2016/10/17.
 */
public class DateTools {

    public static String formatToYMD(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static String formatToYMDHm(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(date);
    }

}
