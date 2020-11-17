package com.dtps.chadwickschoolmeals.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterEvalBody {
    @SerializedName("menuIdx")
    @Expose
    private int menuIdx;
    @SerializedName("score")
    @Expose
    private float score;
    @SerializedName("content")
    @Expose
    private String content;


    public RegisterEvalBody(int menuIdx, float score, String content) {
        this.menuIdx = menuIdx;
        this.score = score;
        this.content = content;
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
