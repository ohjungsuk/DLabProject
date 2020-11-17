package com.dtps.chadwickschoolmeals.services;

import android.util.Log;

import com.dtps.chadwickschoolmeals.ApplicationClass;
import com.dtps.chadwickschoolmeals.interfaces.RegisterEvalActivityView;
import com.dtps.chadwickschoolmeals.interfaces.RegisterEvalRetrofitInterface;
import com.dtps.chadwickschoolmeals.interfaces.SignUpRetrofitInterface;
import com.dtps.chadwickschoolmeals.models.RegisterEvalBody;
import com.dtps.chadwickschoolmeals.models.RegisterEvalResponse;
import com.dtps.chadwickschoolmeals.models.SignUpBody;
import com.dtps.chadwickschoolmeals.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterEvalService {
    private final RegisterEvalActivityView mRegisterEvalActivityView;

    public RegisterEvalService(RegisterEvalActivityView mRegisterEvalActivityView) {
        this.mRegisterEvalActivityView = mRegisterEvalActivityView;
    }

    public void postRegisterEval(int menuIdx,float score,String content){
        final RegisterEvalRetrofitInterface registerEvalRetrofitInterface = ApplicationClass.getRetrofit().create(RegisterEvalRetrofitInterface.class);
        registerEvalRetrofitInterface.requestRegisterEval(new RegisterEvalBody(menuIdx,score,content)).enqueue(new Callback<RegisterEvalResponse>() {
            @Override
            public void onResponse(Call<RegisterEvalResponse> call, Response<RegisterEvalResponse> response) {
                RegisterEvalResponse registerEvalResponse = response.body();

                if(registerEvalResponse != null){
                    if(response.isSuccessful()){
                        mRegisterEvalActivityView.validateSuccess(registerEvalResponse);
                    }else{
                        mRegisterEvalActivityView.validateFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterEvalResponse> call, Throwable t) {
                Log.d("RETRO", "HELLLO");
            }

        });
    }
}
