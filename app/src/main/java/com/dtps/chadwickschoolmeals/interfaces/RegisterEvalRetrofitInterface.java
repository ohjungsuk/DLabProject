package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.RegisterEvalBody;
import com.dtps.chadwickschoolmeals.models.RegisterEvalResponse;
import com.dtps.chadwickschoolmeals.models.SignUpBody;
import com.dtps.chadwickschoolmeals.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterEvalRetrofitInterface {
    @POST("/review")
    Call<RegisterEvalResponse> requestRegisterEval(@Body RegisterEvalBody body);
}
