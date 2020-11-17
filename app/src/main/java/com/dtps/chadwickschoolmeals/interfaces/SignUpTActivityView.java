package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.SignUpTBody;
import com.dtps.chadwickschoolmeals.models.SignUpTResponse;

public interface SignUpTActivityView {
    void validateSuccess2(SignUpTResponse response);
    void validateFailure2();
}
