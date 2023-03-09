package com.chatgpt.android;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("text")
    private String data;

    public Data(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
