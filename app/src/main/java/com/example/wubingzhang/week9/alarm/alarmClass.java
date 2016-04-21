package com.example.wubingzhang.week9.alarm;

import java.io.Serializable;

/**
 * Created by WBZ on 2016/4/21.
 */
public class alarmClass implements Serializable{
    private String label;
    private int hour,minute;
    private boolean alarmOn;

    public alarmClass(){}

    public alarmClass(boolean alarmOn,String label,int hour,int minute){
        this.minute = minute;
        this.hour = hour;
        this.alarmOn  = alarmOn;
        this.label = label;
    }

    public boolean isOn() {
        return alarmOn;
    }

    public void setOn(boolean mOn) {
        this.alarmOn = mOn;
    }
    public String getLable() {
        return label;
    }

    public void setLable(String mLable) {
        this.label = mLable;
    }

    public int getHour(){return hour;}

    public void setHour(int hour){this.hour = hour;}

    public int getMinute(){return minute;}

    public void setMinute(int minute){this.minute = minute;}
}
