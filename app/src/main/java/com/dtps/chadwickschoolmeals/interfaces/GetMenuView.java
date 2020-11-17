package com.dtps.chadwickschoolmeals.interfaces;

import com.dtps.chadwickschoolmeals.models.GetMenuResponse;

public interface GetMenuView {
    void validateMenu(GetMenuResponse response);
    void validateFailure();
}
