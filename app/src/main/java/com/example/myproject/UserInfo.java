package com.example.myproject;

import android.content.Context;

import java.net.URI;

public class UserInfo {
    public String id, answer, count, imgUri;

    public UserInfo() {
    }
    public UserInfo(String id, String answer, String count) {
        this.id = id;
        this.answer = answer;
        this.count = count;
    }
    public UserInfo(String imgUri, String id) {
        this.imgUri = imgUri;
        this.id = id;
    }

    public String Image(){
        return imgUri;
    }
}
