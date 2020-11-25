package com.dtps.chadwickschoolmeals.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterEvalBody {
    @SerializedName("foodIdx")
    @Expose
    private int menuIdx;
    @SerializedName("score")
    @Expose
    private float score;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("date")
    @Expose
    private String date;


    public RegisterEvalBody(int menuIdx, float score, String content, String date) {
        this.menuIdx = menuIdx;
        this.score = score;
        this.content = content;
        this.date = date;
    }

    public int getMenuIdx() {
        return menuIdx;
    }

    public void setMenuIdx(int menuIdx) {
        this.menuIdx = menuIdx;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
