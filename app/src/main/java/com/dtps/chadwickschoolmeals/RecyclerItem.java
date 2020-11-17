package com.dtps.chadwickschoolmeals;

public class RecyclerItem {
    private String user;
    private String comment;
    private Double rating;

    public void setUser(String user) {
        this.user = user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return this.user;
    }

    public String getComment() {
        return this.comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
