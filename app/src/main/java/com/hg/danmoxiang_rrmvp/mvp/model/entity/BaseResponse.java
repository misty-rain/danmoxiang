package com.hg.danmoxiang_rrmvp.mvp.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseResponse implements Parcelable {
    private String data;
    private String msg;
    private String result;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.data);
        dest.writeString(this.msg);
        dest.writeString(this.result);
    }

    public BaseResponse() {
    }

    protected BaseResponse(Parcel in) {
        this.data = in.readString();
        this.msg = in.readString();
        this.result = in.readString();
    }

    public static final Parcelable.Creator<BaseResponse> CREATOR = new Parcelable.Creator<BaseResponse>() {
        @Override
        public BaseResponse createFromParcel(Parcel source) {
            return new BaseResponse(source);
        }

        @Override
        public BaseResponse[] newArray(int size) {
            return new BaseResponse[size];
        }
    };
}
