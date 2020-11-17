package com.dtps.chadwickschoolmeals.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {
    @SerializedName("reviewIdx")
    @Expose
    private Integer reviewIdx;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    public Integer getReviewIdx() {
        return reviewIdx;
    }

    public void setReviewIdx(Integer reviewIdx) {
        this.reviewIdx = reviewIdx;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
