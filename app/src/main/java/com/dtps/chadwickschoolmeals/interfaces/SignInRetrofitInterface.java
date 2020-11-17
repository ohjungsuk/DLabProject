package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.SignInBody;
import com.dtps.chadwickschoolmeals.models.SignInResponse;
import com.dtps.chadwickschoolmeals.models.SignUpBody;
import com.dtps.chadwickschoolmeals.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignInRetrofitInterface {
    @POST("login/student")
    Call<SignInResponse> requestStudentSignIn(@Body SignInBody body);

    @POST("login/teacher")
    Call<SignInResponse> requestTeacherSignIn(@Body SignInBody body);
}
