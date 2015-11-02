package com.lpiem.mylittelbook.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by iem2 on 02/11/15.
 */
public class Criticism {
    private int user;
    private String book;
    private float rate;
    private String comment;

    public Criticism(int user, String book, float rate, String comment) {
        this.user = user;
        this.book = book;
        this.rate = rate;
        this.comment = comment;
    }

    public Criticism(JSONObject jsonObject){
        try {
            user=jsonObject.getInt("IdUser");
            book=jsonObject.getString("IdBook");
            rate=(float)jsonObject.getDouble("Rate");
            comment=jsonObject.getString("Comment");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
