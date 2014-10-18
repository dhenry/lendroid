package com.dhenry.lendroid.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;

import org.jetbrains.annotations.NotNull;

import rx.functions.Action1;

public class ActionBars {
    public static void configure(@NotNull Fragment fragment, @NotNull Action1<ActionBar> action) {
        configure(fragment.getActivity(), action);
    }

    public static void configure(@NotNull Activity activity, @NotNull Action1<ActionBar> action) {
        action.call(activity.getActionBar());
    }

    public static void homeAsUp(@NotNull ActionBar actionBar, boolean enabled) {
        actionBar.setHomeButtonEnabled(enabled);
        actionBar.setDisplayHomeAsUpEnabled(enabled);
    }
}
