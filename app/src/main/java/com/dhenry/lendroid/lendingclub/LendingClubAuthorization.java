package com.dhenry.lendroid.lendingclub;

import retrofit.RequestInterceptor;

public class LendingClubAuthorization implements RequestInterceptor {

    private final String key;

    public LendingClubAuthorization(String key) {
        this.key = key;
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("Authorization", key);
    }
}
