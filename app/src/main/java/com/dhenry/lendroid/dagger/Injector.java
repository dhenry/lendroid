package com.dhenry.lendroid.dagger;

import org.jetbrains.annotations.NotNull;

import dagger.ObjectGraph;

public interface Injector {
    @NotNull ObjectGraph getObjectGraph();
}
