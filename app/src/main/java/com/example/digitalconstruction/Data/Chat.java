package com.example.digitalconstruction.Data;

public class Chat {
    private String mName;
    private String mLastChat;
    private String mTime;
    private int mImage;
    private boolean online;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLastChat() {
        return mLastChat;
    }

    public void setmLastChat(String mLastChat) {
        this.mLastChat = mLastChat;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
