package com.example.barterapp;

import android.graphics.Bitmap;

public class ExampleItem {

    private String mImageResource;
    private String mTitle;
    private String mDesc;
    private String mLink;


    public ExampleItem(String mImageResource, String mTitle, String mDesc,String mLink) {
        this.mImageResource = mImageResource;
        this.mTitle = mTitle;
        this.mDesc = mDesc;
        this.mLink = mLink;
    }


    public String getmImageResource() {
        return mImageResource;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDesc() {
        return mDesc;
    }

    public String getmLink() {
        return mLink;
    }
}
