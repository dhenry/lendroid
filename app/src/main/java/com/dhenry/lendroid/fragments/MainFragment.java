package com.dhenry.lendroid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.dagger.Dagger;
import com.dhenry.lendroid.dagger.ScopedFragment;
import com.dhenry.lendroid.dagger.modules.MainFragmentScopeModule;
import com.dhenry.lendroid.utils.ActionBars;
import com.dhenry.lendroid.utils.DatabaseHelper;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.ObjectGraph;
import rx.subjects.Subject;

public class MainFragment extends ScopedFragment {
    @Inject @NotNull Lazy<Picasso>                   picasso; // application scope
    @Inject @NotNull Lazy<DatabaseHelper>            databaseHelper; //activity scope
    @Inject @NotNull Lazy<Subject<Boolean, Boolean>> truth; //fragment scope

    @NotNull @Override protected ObjectGraph createDaggerScope(@NotNull Context activity) {
        return Dagger.getObjectGraph(getActivity()).plus(new MainFragmentScopeModule());
    }

    @NotNull @Override protected View createScopedView(@NotNull LayoutInflater inflater,
                                                       @NotNull ViewGroup container,
                                                       @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main, container, false);
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBars.configure(this, actionBar -> {
            ActionBars.homeAsUp(actionBar, false);
            actionBar.setTitle(R.string.app_name);
        });
        Dagger.inject(this);
    }
}
