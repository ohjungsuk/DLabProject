package com.dtps.chadwickschoolmeals.services;

import android.util.Log;

import com.dtps.chadwickschoolmeals.ApplicationClass;
import com.dtps.chadwickschoolmeals.interfaces.SignUpActivityView;
import com.dtps.chadwickschoolmeals.interfaces.SignUpRetrofitInterface;
import com.dtps.chadwickschoolmeals.models.SignUpBody;
import com.dtps.chadwickschoolmeals.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpService {
    private final SignUpActivityView mSignUpActivityView;

    public SignUpService(final SignUpActivityView signUpActivityView) {
        mSignUpActivityView = signUpActivityView;
    }

    public void postSignUp(String id, String pw, String name , int grade, String className, String bday){
        final SignUpRetrofitInterface signUpRetrofitInterface = ApplicationClass.getRetrofit().create(SignUpRetrofitInterface.class);
        signUpRetrofitInterface.requestSignUp(new SignUpBody(id,pw,name,grade,className,bday)).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                SignUpResponse signUpResponse = response.body();

                if(signUpResponse != null){
                    if(response.isSuccessful()){
                        mSignUpActivityView.validateSuccess();
                    }else{
                        mSignUpActivityView.validateFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Log.d("RETRO", "HELLLO");
            }
        });
    }
}
