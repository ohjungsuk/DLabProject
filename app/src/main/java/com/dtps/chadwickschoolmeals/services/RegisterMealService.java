package com.dtps.chadwickschoolmeals.services;

import android.util.Log;

import com.dtps.chadwickschoolmeals.ApplicationClass;
import com.dtps.chadwickschoolmeals.interfaces.RegisterMealActivityView;
import com.dtps.chadwickschoolmeals.interfaces.RegsiterMealRetrofitInterface;

import com.dtps.chadwickschoolmeals.models.RegisterMealBody;
import com.dtps.chadwickschoolmeals.models.RegisterMealResponse;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterMealService {
    private final RegisterMealActivityView mRegisterMealActivityView;

    public RegisterMealService(RegisterMealActivityView mRegisterMealActivityView) {
        this.mRegisterMealActivityView = mRegisterMealActivityView;
    }

    public void postKorean(String date, Integer foodIdx, ArrayList menuList){
        final RegsiterMealRetrofitInterface registerMealRetrofitInterface = ApplicationClass.getRetrofit().create(RegsiterMealRetrofitInterface.class);
        registerMealRetrofitInterface.requestRegisterMeal(new RegisterMealBody(date,foodIdx,menuList)).enqueue(new Callback<RegisterMealResponse>() {
            @Override
            public void onResponse(Call<RegisterMealResponse> call, Response<RegisterMealResponse> response) {
                RegisterMealResponse registerMealResponse = response.body();

                if(registerMealResponse != null){
                    if(response.isSuccessful()){
                        mRegisterMealActivityView.validateSuccess(registerMealResponse);
                    }else{
                        mRegisterMealActivityView.validateFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterMealResponse> call, Throwable t) {
                Log.d("RETRO", "HELLLO");
            }
        });
    }
    public void postInternational(String date, Integer foodIdx, ArrayList menuList){
        final RegsiterMealRetrofitInterface registerMealRetrofitInterface = ApplicationClass.getRetrofit().create(RegsiterMealRetrofitInterface.class);
        registerMealRetrofitInterface.requestRegisterMeal(new RegisterMealBody(date,foodIdx,menuList)).enqueue(new Callback<RegisterMealResponse>() {
            @Override
            public void onResponse(Call<RegisterMealResponse> call, Response<RegisterMealResponse> response) {
                RegisterMealResponse registerMealResponse = response.body();

                if(registerMealResponse != null){
                    if(response.isSuccessful()){
                        mRegisterMealActivityView.validateSuccess(registerMealResponse);
                    }else{
                        mRegisterMealActivityView.validateFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterMealResponse> call, Throwable t) {
                Log.d("RETRO", "HELLLO");
            }
        });
    }
    public void postNoodle(String date, Integer foodIdx, ArrayList menuList){
        final RegsiterMealRetrofitInterface registerMealRetrofitInterface = ApplicationClass.getRetrofit().create(RegsiterMealRetrofitInterface.class);
        registerMealRetrofitInterface.requestRegisterMeal(new RegisterMealBody(date,foodIdx,menuList)).enqueue(new Callback<RegisterMealResponse>() {
            @Override
            public void onResponse(Call<RegisterMealResponse> call, Response<RegisterMealResponse> response) {
                RegisterMealResponse registerMealResponse = response.body();

                if(registerMealResponse != null){
                    if(response.isSuccessful()){
                        mRegisterMealActivityView.validateSuccess(registerMealResponse);
                    }else{
                        mRegisterMealActivityView.validateFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterMealResponse> call, Throwable t) {
                Log.d("debug_2", "fail");
            }
        });
    }
}
