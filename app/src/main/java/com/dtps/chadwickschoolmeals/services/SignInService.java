package com.dtps.chadwickschoolmeals.services;

import android.util.Log;

import com.dtps.chadwickschoolmeals.ApplicationClass;
import com.dtps.chadwickschoolmeals.interfaces.SignInActivityView;
import com.dtps.chadwickschoolmeals.interfaces.SignInRetrofitInterface;
import com.dtps.chadwickschoolmeals.interfaces.SignUpActivityView;
import com.dtps.chadwickschoolmeals.interfaces.SignUpRetrofitInterface;
import com.dtps.chadwickschoolmeals.models.SignInBody;
import com.dtps.chadwickschoolmeals.models.SignInResponse;
import com.dtps.chadwickschoolmeals.models.SignUpBody;
import com.dtps.chadwickschoolmeals.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInService{

    public static final int STUDENT = 1;
    public static final int TEACHER = 0;

    private final SignInActivityView mSignInActivityView;

    public SignInService(final SignInActivityView signInActivityView) {
        mSignInActivityView = signInActivityView;
    }

    public void postSignIn(String id, String pw, int flag){
        final SignInRetrofitInterface signInRetrofitInterface = ApplicationClass.getRetrofit().create(SignInRetrofitInterface.class);
        if(flag == STUDENT) {
            signInRetrofitInterface.requestStudentSignIn(new SignInBody(id, pw)).enqueue(new Callback<SignInResponse>() {
                @Override
                public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                    SignInResponse signInResponse = response.body();
                    mSignInActivityView.validateSuccess(signInResponse);
                    Log.d("debug_1", "STUDENT");
                }

                @Override
                public void onFailure(Call<SignInResponse> call, Throwable t) {
                    mSignInActivityView.validateFailure();
                }
            });
        }else {
            signInRetrofitInterface.requestTeacherSignIn(new SignInBody(id, pw)).enqueue(new Callback<SignInResponse>() {
                @Override
                public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                    SignInResponse signInResponse = response.body();
                    mSignInActivityView.validateSuccess(signInResponse);
                    Log.d("debug_1", "STUDENT");
                }

                @Override
                public void onFailure(Call<SignInResponse> call, Throwable t) {
                    mSignInActivityView.validateFailure();
                }
            });
        }
    }
}
