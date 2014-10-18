package com.dhenry.lendroid;

import com.dhenry.lendroid.dagger.ModulesTestModule;
import com.dhenry.lendroid.utils.Lists;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TestApp extends App {
    @NotNull @Override protected List<Object> getDaggerModules() {
        return Lists.add(super.getDaggerModules(), new ModulesTestModule());
    }
}
