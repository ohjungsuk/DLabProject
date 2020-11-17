package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.RegisterMealBody;
import com.dtps.chadwickschoolmeals.models.RegisterMealResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegsiterMealRetrofitInterface {
    @POST("/menu")
    Call<RegisterMealResponse> requestRegisterMeal(@Body RegisterMealBody body);
}
