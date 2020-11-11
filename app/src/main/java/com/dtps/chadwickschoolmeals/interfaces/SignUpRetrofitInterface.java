package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.SignUpBody;
import com.dtps.chadwickschoolmeals.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SignUpRetrofitInterface {
//    @GET("/test")
//    Call<SignInResponse> getTest();
//
//    @GET("/test/{number}")
//    Call<SignInResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/user")
//    Call<SignInResponse>signInTest(@Body SignInBody params);

    @POST("/student")
    Call<SignUpResponse> requestSignUp(@Body SignUpBody body);

}