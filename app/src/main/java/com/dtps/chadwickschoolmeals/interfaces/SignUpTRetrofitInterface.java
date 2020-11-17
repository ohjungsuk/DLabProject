package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.SignUpBody;
import com.dtps.chadwickschoolmeals.models.SignUpResponse;
import com.dtps.chadwickschoolmeals.models.SignUpTBody;
import com.dtps.chadwickschoolmeals.models.SignUpTResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpTRetrofitInterface {
    @POST("/teacher")
    Call<SignUpTResponse> requestSignUpT(@Body SignUpTBody tbody);

}
