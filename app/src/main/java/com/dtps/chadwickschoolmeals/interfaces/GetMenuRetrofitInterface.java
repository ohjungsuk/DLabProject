package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.GetMenuBody;
import com.dtps.chadwickschoolmeals.models.GetMenuResponse;
import com.dtps.chadwickschoolmeals.models.SignInBody;
import com.dtps.chadwickschoolmeals.models.SignInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetMenuRetrofitInterface {
    @GET("/menu")
    Call<GetMenuResponse> requestStudentSignIn(@Query("foodIdx") int idx, @Query("date") String date);
}
