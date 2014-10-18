package com.dhenry.lendroid.dagger;

import android.app.Fragment;
import android.content.Context;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import dagger.ObjectGraph;

public class Dagger {
    @NotNull public static ObjectGraph getObjectGraph(@NotNull Context context) {
        if (context instanceof Injector) {
            return ((Injector) context).getObjectGraph();
        }
        throw new IllegalArgumentException(String.format(
                "Your %s should implement Injector interface",
                context.getClass().getSimpleName()));
    }

    public static void inject(@NotNull Context context) {
        getObjectGraph(context).inject(context);
    }

    public static void inject(@NotNull View view) {
        getObjectGraph(view.getContext()).inject(view);
    }

    public static void inject(@NotNull Fragment fragment) {
        getObjectGraph(fragment.getActivity()).inject(fragment);
    }

    public static void inject(@NotNull ScopedFragment fragment) {
        getObjectGraph(fragment.getScopedContext()).inject(fragment);
    }
}