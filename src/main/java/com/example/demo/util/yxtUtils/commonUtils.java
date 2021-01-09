package com.example.demo.util.yxtUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class commonUtils {

    public static Timestamp StrTransSqlDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date(System.currentTimeMillis());
        String s = simpleDateFormat.format(nowDate).toString();
        Timestamp transdate = null;
        try {
            nowDate = simpleDateFormat.parse(s);


            transdate = new Timestamp(nowDate.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return transdate;
    }

    public static String getNowTime(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String s = formatter.format(date).toString();

        return s;

    }

    public static String getFormatTime(Date date){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(date).toString();

        return s;

    }
    public static String getFormatTimeHms(Date date){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(date).toString();

        return s;

    }

    public static String getFileNameSub(String s){

        return s.substring(32);
    }

}
