package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.RegisterEvalResponse;

public interface RegisterEvalActivityView {

    void validateSuccess(RegisterEvalResponse response);

    void validateFailure();
}
