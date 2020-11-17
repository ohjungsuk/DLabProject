package com.dtps.chadwickschoolmeals.services;

import android.util.Log;

import com.dtps.chadwickschoolmeals.ApplicationClass;
import com.dtps.chadwickschoolmeals.interfaces.GetMenuRetrofitInterface;
import com.dtps.chadwickschoolmeals.interfaces.GetMenuView;
import com.dtps.chadwickschoolmeals.models.GetMenuBody;
import com.dtps.chadwickschoolmeals.models.GetMenuResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMenuService {
    final GetMenuView getMenuView;

    public GetMenuService(final GetMenuView getMenuView) {
        this.getMenuView = getMenuView;
    }

    public void getMenu(String date, int idx){
        final GetMenuRetrofitInterface getMenuRetrofitInterface = ApplicationClass.getRetrofit().create(GetMenuRetrofitInterface.class);
        getMenuRetrofitInterface.requestStudentSignIn(idx, date).enqueue(new Callback<GetMenuResponse>() {
            @Override
            public void onResponse(Call<GetMenuResponse> call, Response<GetMenuResponse> response) {
                GetMenuResponse getMenuResponseBody = response.body();
                if(getMenuResponseBody != null){
                    getMenuView.validateMenu(getMenuResponseBody);
                }
            }

            @Override
            public void onFailure(Call<GetMenuResponse> call, Throwable t) {
                getMenuView.validateFailure();
            }
        });
    }
}
