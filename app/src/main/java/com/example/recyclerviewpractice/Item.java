package com.example.recyclerviewpractice;

public class Item {

    private int mImageResource;
    private String mText;

    public Item(int imageResource, String text){
        mImageResource = imageResource;
        mText = text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
