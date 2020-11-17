package com.dtps.chadwickschoolmeals.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RegisterMealBody {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("foodIdx")
    @Expose
    private Integer foodIdx;
    @SerializedName("menuList")
    @Expose
    private ArrayList menuList;

    public RegisterMealBody(String date, Integer foodIdx, ArrayList menuList) {
        this.date = date;
        this.foodIdx = foodIdx;
        this.menuList = menuList;
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

    public ArrayList getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList menuList) {
        this.menuList = menuList;
    }
}
