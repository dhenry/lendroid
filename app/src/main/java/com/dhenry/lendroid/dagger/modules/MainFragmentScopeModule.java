package com.dhenry.lendroid.dagger.modules;

import com.dhenry.lendroid.fragments.LoginFragment;
import com.dhenry.lendroid.fragments.MainFragment;
import com.dhenry.lendroid.lendingclub.LendingClubAPI;
import com.dhenry.lendroid.lendingclub.LendingClubAuthorization;
import com.dhenry.lendroid.utils.Preferences;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.JacksonConverter;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import timber.log.Timber;

/**
 * Created by adelnizamutdinov on 10/1/14
 */
@Module(addsTo = MainActivityScopeModule.class,
        injects = {
                MainFragment.class,
                LoginFragment.class
        },
        library = true)
public class MainFragmentScopeModule {
    @Provides @Singleton
    Subject<Boolean, Boolean> provideTruth() { return PublishSubject.create(); }

    @Provides @Singleton Converter provideJacksonConverter(ObjectMapper objectMapper) {
        return new JacksonConverter(objectMapper);
    }

    @Provides @Singleton LendingClubAuthorization provideLendingClubAuthorization(Preferences preferences) {
        return new LendingClubAuthorization(preferences.apiKey());
    }

    @Provides @Singleton
    LendingClubAPI provideLendingClubApi(OkHttpClient okHttpClient, Converter converter,
                                         LendingClubAuthorization authorization) {

        Timber.d("creating lendingClubAPI");
        return new RestAdapter.Builder()
                .setEndpoint(LendingClubAPI.SERVER)
                .setClient(new OkClient(okHttpClient))
                .setConverter(converter)
                .setRequestInterceptor(authorization)
                .setLog(Timber::d)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .build()
                .create(LendingClubAPI.class);
    }
}
