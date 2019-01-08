package com.example.vietvan.lapitchat.model;

/**
 * Created by HoangHiep on 16/12/2018.
 */

public class Chat {
    public String seen;
    public long time, timestamp;

    public Chat() {
    }

    public Chat(String seen, long time) {
        this.seen = seen;
        this.time = time;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
