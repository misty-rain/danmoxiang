package com.hg.danmoxiang_rrmvp.mvp.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Passport implements Parcelable {
    private String userName;
    private String passWord;

    protected Passport(Parcel in) {
        userName = in.readString();
        passWord = in.readString();
    }

    public static final Creator<Passport> CREATOR = new Creator<Passport>() {
        @Override
        public Passport createFromParcel(Parcel in) {
            return new Passport(in);
        }

        @Override
        public Passport[] newArray(int size) {
            return new Passport[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeString(passWord);
    }
}
