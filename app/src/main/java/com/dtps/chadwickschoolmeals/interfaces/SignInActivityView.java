package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.SignInResponse;

public interface SignInActivityView {
    void validateFailure();
    void validateSuccess(SignInResponse response);
}
