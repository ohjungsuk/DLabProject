package com.dtps.chadwickschoolmeals.services;

import android.util.Log;

import com.dtps.chadwickschoolmeals.ApplicationClass;
import com.dtps.chadwickschoolmeals.interfaces.ReviewRetrofitInterface;
import com.dtps.chadwickschoolmeals.interfaces.ReviewView;
import com.dtps.chadwickschoolmeals.models.GetReviewResponse;
import com.dtps.chadwickschoolmeals.models.GetTotalReviewResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewService {
    final ReviewView reviewView;
    public ReviewService(final ReviewView reviewView) {
        this.reviewView = reviewView;
    }

    public void getReview(int menuIdx, String date){
        final ReviewRetrofitInterface reviewRetrofitInterface = ApplicationClass.getRetrofit().create(ReviewRetrofitInterface.class);
        reviewRetrofitInterface.getReview(menuIdx, date).enqueue(new Callback<GetReviewResponse>() {
            @Override
            public void onResponse(Call<GetReviewResponse> call, Response<GetReviewResponse> response) {
                reviewView.validateRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<GetReviewResponse> call, Throwable t) {
                reviewView.validateFailure();
            }
        });
    }

    public void getTotalReview(int menuIdx, String date){
        final ReviewRetrofitInterface reviewRetrofitInterface = ApplicationClass.getRetrofit().create(ReviewRetrofitInterface.class);
        reviewRetrofitInterface.getTotalReview(menuIdx, date).enqueue(new Callback<GetTotalReviewResponse>() {
            @Override
            public void onResponse(Call<GetTotalReviewResponse> call, Response<GetTotalReviewResponse> response) {
                reviewView.validateRatingBar(response.body());
            }

            @Override
            public void onFailure(Call<GetTotalReviewResponse> call, Throwable t) {
                Log.d("failure", "failure");
                reviewView.validateSuccess();
            }
        });
    }
}
