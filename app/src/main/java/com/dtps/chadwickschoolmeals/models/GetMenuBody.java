package com.dtps.chadwickschoolmeals.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMenuBody {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("foodIdx")
    @Expose
    private Integer foodIdx;

    public GetMenuBody(String date, Integer foodIdx) {
        this.date = date;
        this.foodIdx = foodIdx;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getFoodIdx() {
        return foodIdx;
    }

    public void setFoodIdx(Integer foodIdx) {
        this.foodIdx = foodIdx;
    }

}