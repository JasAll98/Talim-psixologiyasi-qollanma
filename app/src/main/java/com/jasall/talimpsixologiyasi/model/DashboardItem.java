package com.jasall.talimpsixologiyasi.model;

import android.graphics.drawable.Drawable;

import androidx.databinding.BindingAdapter;

public class DashboardItem {
    private Drawable image;
    private String title;
    private String desc;
    private String time;

    public DashboardItem(Drawable image, String title, String desc, String time) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.time = time;
    }

    public Drawable getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getTime() {
        return time;
    }
}
