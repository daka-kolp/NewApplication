package com.dakakolp.newapplication.ui.adapters.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Parcelable {

    private String mTitle;
    private String mSubtitle;
    private String mDescription;
    private Uri mImage;

    public Item(String str) {
        String[] arrArray = parseString(str);
        mTitle = arrArray[0];
        mSubtitle = arrArray[1];
        mDescription = arrArray[2];
        mImage = Uri.parse(arrArray[3]);
    }

    public Item(Uri image, String title, String subtitle, String description) {
        mTitle = title;
        mSubtitle = subtitle;
        mDescription = description;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public Uri getImage() {
        return mImage;
    }

    private String[] parseString(String str) {
        String[] strArray = str.split(";");
        return strArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return mTitle.equals(item.mTitle) &&
                mSubtitle.equals(item.mSubtitle) &&
                mDescription.equals(item.mDescription) &&
                mImage.equals(item.mImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mTitle, mSubtitle, mDescription, mImage);
    }


    protected Item(Parcel in) {
        mTitle = in.readString();
        mSubtitle = in.readString();
        mDescription = in.readString();
        mImage = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mSubtitle);
        dest.writeString(mDescription);
        dest.writeParcelable(mImage, flags);
    }
}

