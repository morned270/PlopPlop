package com.cookandroid.fordiver;

import android.graphics.drawable.Drawable;

public class Logbook2ListViewItem {
    private Drawable iconDrawable ;
    private String titleStr ;
    private String dateStr ;
    private  String locationStr;

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setdate(String date) {
        dateStr = date ;
    }
    public void setlocation(String location) {
        locationStr = location ;
    }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getdate() {
        return this.dateStr ;
    }
    public String getlocation() {
        return this.locationStr ;
    }
}
