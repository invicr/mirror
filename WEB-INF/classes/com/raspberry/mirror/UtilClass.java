// 
// Decompiled by Procyon v0.5.36
// 

package com.raspberry.mirror;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UtilClass
{
    public String getToday() {
        final Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (this.calcDay()) {
            calendar.add(5, -1);
            date = calendar.getTime();
            System.out.println("date : " + date);
        }
        System.out.println("getToday() : " + sdf.format(date));
        return sdf.format(date);
    }
    
    public boolean getTimeCalc() {
        boolean result = false;
        final Calendar calendar = Calendar.getInstance();
        final Date date = calendar.getTime();
        final SimpleDateFormat sdf = new SimpleDateFormat("mm");
        System.out.println("---- : " + sdf.format(date));
        if (Integer.parseInt(sdf.format(date)) < 40) {
            result = true;
        }
        return result;
    }
    
    public boolean calcDay() {
        boolean result = false;
        final Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        final SimpleDateFormat sdf = new SimpleDateFormat("HH");
        if (this.getTimeCalc()) {
            calendar.add(10, -1);
            date = calendar.getTime();
            if ("23".equals(sdf.format(date))) {
                result = true;
            }
        }
        return result;
    }
    
    public String getHour() {
        final Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        final SimpleDateFormat sdf = new SimpleDateFormat("HH");
        if (this.getTimeCalc()) {
            calendar.add(10, -1);
            if ("23".equals(sdf.format(date))) {
                calendar.add(5, -1);
            }
            date = calendar.getTime();
        }
        System.out.println("getHour() : " + sdf.format(date));
        return sdf.format(date);
    }
}