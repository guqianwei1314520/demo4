package com.example.demo4.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DataUtil {

    public static String dateFormat(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  format.format(date.getTime());
    }

    public static Date string2date(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(date);
        } catch (ParseException e) {

        }
        return null;
    }
}
