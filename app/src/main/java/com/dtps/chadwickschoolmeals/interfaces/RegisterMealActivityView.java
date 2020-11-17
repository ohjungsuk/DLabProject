package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.RegisterMealResponse;

public interface RegisterMealActivityView {
    void validateSuccess(RegisterMealResponse response);
    void validateFailure();

}
