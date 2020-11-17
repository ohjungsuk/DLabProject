

package com.dtps.chadwickschoolmeals.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTotalReviewResponse {

    @SerializedName("reviewTotal")
    @Expose
    ReviewTotal reviewTotal;
    @SerializedName("isSuccess")
    @Expose
    Boolean isSuccess;
    @SerializedName("code")
    @Expose
    Integer code;
    @SerializedName("message")
    @Expose
    String message;

    public Double getTotalScore() {
        return reviewTotal.totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.reviewTotal.totalScore = totalScore;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    class ReviewTotal{
        @SerializedName("totalScore")
        @Expose
        Double totalScore;
    }

}