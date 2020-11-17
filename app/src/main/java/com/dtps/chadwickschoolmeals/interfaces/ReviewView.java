package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.GetReviewResponse;
import com.dtps.chadwickschoolmeals.models.GetTotalReviewResponse;

public interface ReviewView {
    void validateSuccess();
    void validateFailure();
    void validateRecyclerView(GetReviewResponse response);
    void validateRatingBar(GetTotalReviewResponse response);
}
