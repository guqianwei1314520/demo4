package com.example.demo4.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DataUtil {

    public static String dateFormat(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  format.format(date.getTime());
    }
}
