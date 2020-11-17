package com.dtps.chadwickschoolmeals.services;

import android.util.Log;

import com.dtps.chadwickschoolmeals.ApplicationClass;
import com.dtps.chadwickschoolmeals.interfaces.SignUpActivityView;
import com.dtps.chadwickschoolmeals.interfaces.SignUpRetrofitInterface;
import com.dtps.chadwickschoolmeals.interfaces.SignUpTActivityView;
import com.dtps.chadwickschoolmeals.interfaces.SignUpTRetrofitInterface;
import com.dtps.chadwickschoolmeals.models.SignUpBody;
import com.dtps.chadwickschoolmeals.models.SignUpResponse;
import com.dtps.chadwickschoolmeals.models.SignUpTBody;
import com.dtps.chadwickschoolmeals.models.SignUpTResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpTService {
    private final SignUpTActivityView mSignUpTActivityView;

    public SignUpTService(final SignUpTActivityView signUpTActivityView) {
        mSignUpTActivityView = signUpTActivityView;
    }

    public void postSignUpT(String id, String pw, String name, String bday){
        final SignUpTRetrofitInterface signUpTRetrofitInterface = ApplicationClass.getRetrofit().create(SignUpTRetrofitInterface.class);
        signUpTRetrofitInterface.requestSignUpT(new SignUpTBody(id,pw,name,bday)).enqueue(new Callback<SignUpTResponse>() {
            @Override
            public void onResponse(Call<SignUpTResponse> call, Response<SignUpTResponse> response) {
                SignUpTResponse signUpTResponse = response.body();

                if(signUpTResponse != null) {
                    if (signUpTResponse.getIsSuccess()) {
                        mSignUpTActivityView.validateSuccess2(signUpTResponse);
                    } else {
                        mSignUpTActivityView.validateFailure2();
                    }
                }
            }

            @Override
            public void onFailure(Call<SignUpTResponse> call, Throwable t) {
                Log.d("RETRO", "teacherfail");
            }
        });
    }
}
