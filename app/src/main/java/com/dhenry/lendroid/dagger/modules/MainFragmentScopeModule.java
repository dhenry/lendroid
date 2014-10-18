package com.dhenry.lendroid.dagger.modules;

import com.dhenry.lendroid.fragments.LoginFragment;
import com.dhenry.lendroid.fragments.MainFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by adelnizamutdinov on 10/1/14
 */
@Module(addsTo = MainActivityScopeModule.class,
        injects = {
                MainFragment.class,
                LoginFragment.class
        })
public class MainFragmentScopeModule {
    @Provides @Singleton
    Subject<Boolean, Boolean> provideTruth() { return PublishSubject.create(); }
}
