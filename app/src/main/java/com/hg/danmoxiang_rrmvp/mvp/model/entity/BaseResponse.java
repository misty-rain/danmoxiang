package com.hg.danmoxiang_rrmvp.mvp.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseResponse<T> implements Parcelable {
    private T data;
    private String msg;
    private String result;

    protected BaseResponse(Parcel in) {
        msg = in.readString();
        result = in.readString();
    }

    public static final Creator<BaseResponse> CREATOR = new Creator<BaseResponse>() {
        @Override
        public BaseResponse createFromParcel(Parcel in) {
            return new BaseResponse(in);
        }

        @Override
        public BaseResponse[] newArray(int size) {
            return new BaseResponse[size];
        }
    };

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
        dest.writeString(this.msg);
        dest.writeString(this.result);
    }

    public BaseResponse() {
    }


}
