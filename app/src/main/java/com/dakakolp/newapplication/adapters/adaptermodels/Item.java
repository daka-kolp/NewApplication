package com.dakakolp.newapplication.adapters.adaptermodels;

import android.net.Uri;

import java.util.Objects;

public class Item {

    private String mTitle;
    private String mItem;
    private String mDescription;
    private Uri mImage;

    public Item(String str) {
        String[] arrArray = parseString(str);
        mTitle = arrArray[0];
        mItem = arrArray[1];
        mDescription = arrArray[2];
        mImage = Uri.parse(arrArray[3]);
    }

    public String getTitle() {
        return mTitle;
    }

    public String getItem() {
        return mItem;
    }

    public String getDescription() {
        return mDescription;
    }

    public Uri getImage() {
        return mImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return mTitle.equals(item.mTitle) &&
                mItem.equals(item.mItem) &&
                mDescription.equals(item.mDescription) &&
                mImage.equals(item.mImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mTitle, mItem, mDescription, mImage);
    }

    private String[] parseString(String str) {
        String[] strArray = str.split(";");
        return strArray;
    }
}

