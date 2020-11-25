package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.GetMenuResponse;
import com.dtps.chadwickschoolmeals.models.GetReviewResponse;
import com.dtps.chadwickschoolmeals.models.GetTotalReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ReviewRetrofitInterface {
    @GET("review")
    Call<GetReviewResponse> getReview(@Query("foodIdx")int idx, @Query("date") String date);

    @GET("review/total")
    Call<GetTotalReviewResponse> getTotalReview(@Query("foodIdx")int idx, @Query("date") String date);
}
