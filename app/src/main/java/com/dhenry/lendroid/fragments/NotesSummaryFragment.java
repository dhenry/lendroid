package com.dhenry.lendroid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.dagger.Dagger;
import com.dhenry.lendroid.dagger.modules.MainFragmentScopeModule;
import com.dhenry.lendroid.lendingclub.LendingClubClient;
import com.dhenry.lendroid.processor.NoteOrganizer;
import com.dhenry.lendroid.utils.ActionBars;
import com.dhenry.lendroid.utils.Preferences;
import com.dhenry.lendroid.views.NotesSummaryView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.Lazy;
import dagger.ObjectGraph;
import rx.Observable;
import rx.Subscription;
import rx.android.observables.AndroidObservable;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class NotesSummaryFragment extends SwipeRefreshFragment {

    private NotesSummaryView notesSummaryView;

    @Inject Lazy<LendingClubClient> lendingClubClient;

    @Inject Preferences prefs;

    @Nullable Subscription subscription;

    @Nullable NoteOrganizer lastResult;

    @NotNull @Override protected View createScopedView(@NotNull LayoutInflater inflater,
                                                       @NotNull ViewGroup container,
                                                       @Nullable Bundle savedInstanceState) {

        notesSummaryView = (NotesSummaryView) inflater.inflate(R.layout.notes_summary, container, false);
        ButterKnife.inject(this, notesSummaryView);

        return notesSummaryView;
    }

    @NotNull @Override protected ObjectGraph createDaggerScope(@NotNull Context activity) {
        return Dagger.getObjectGraph(getActivity()).plus(new MainFragmentScopeModule());
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBars.configure(this, actionBar -> {
            ActionBars.homeAsUp(actionBar, false);
            actionBar.setTitle(R.string.my_notes);
        });
        Dagger.inject(this);

        init(savedInstanceState);
        setRetainInstance(true);
    }

    private void init(@Nullable Bundle savedInstanceState) {
        if (subscription == null) {
            if (lastResult == null) {
                makeRequest();
            } else {
                updateView();
            }
        } else {
            setRefreshing(true);
        }
    }

    void updateView() {
        if (getView() != null && lastResult != null && getActivity() != null) {
            setRefreshing(false);
            notesSummaryView.draw(lastResult);
        }
    }

    Observable<NoteOrganizer> createNewNotesObservable() {
        return lendingClubClient.get().getNotes(prefs.investorId())
                .subscribeOn(Schedulers.io());
    }

    void makeRequest() {
        setRefreshing(true);
        subscription = AndroidObservable.bindFragment(this, createNewNotesObservable())
                .doOnEach(notification -> subscription = null)
                .subscribe(summary -> {
                    lastResult = summary;
                    updateView();
                }, e -> {
                    Timber.e(e, "error getting notes");
                    setRefreshing(false);
                });
    }

    @Override public void onDestroy() {
        if (subscription != null) {
            subscription.unsubscribe();
            subscription = null;
        }
        super.onDestroy();
    }

    @NotNull @Override protected Action0 getSwipeRefreshAction() {
        return this::makeRequest;
    }
}
