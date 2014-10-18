package com.dhenry.lendroid;

import android.app.Application;

import com.dhenry.lendroid.dagger.modules.ApplicationScopeModule;
import com.dhenry.lendroid.dagger.Injector;
import com.dhenry.lendroid.utils.Lists;
import com.dhenry.lendroid.utils.TimberCrashReportingTree;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dagger.ObjectGraph;
import lombok.Getter;
import timber.log.Timber;

public class App extends Application implements Injector {
    @NotNull @Getter
    final ObjectGraph objectGraph = ObjectGraph.create(getDaggerModules().toArray());

    @Override public void onCreate() {
        super.onCreate();
        Timber.plant(BuildConfig.DEBUG
                             ? new Timber.DebugTree()
                             : new TimberCrashReportingTree());
    }

    @NotNull protected List<Object> getDaggerModules() {
        return Lists.mutableOf(new ApplicationScopeModule(this));
    }
}
