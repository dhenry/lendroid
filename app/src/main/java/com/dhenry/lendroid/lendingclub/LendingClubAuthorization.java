package com.dhenry.lendroid.lendingclub;

import org.jetbrains.annotations.NotNull;

import retrofit.RequestInterceptor;

public class LendingClubAuthorization implements RequestInterceptor {

    @NotNull final String key;

    public LendingClubAuthorization(@NotNull String key) {
        this.key = key;
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("Authorization", key);
    }
}
