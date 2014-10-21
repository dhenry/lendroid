package com.dhenry.lendroid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.dagger.Dagger;
import com.dhenry.lendroid.dagger.ScopedFragment;
import com.dhenry.lendroid.dagger.modules.MainFragmentScopeModule;
import com.dhenry.lendroid.lendingclub.LendingClubClient;
import com.dhenry.lendroid.lendingclub.models.AccountSummary;
import com.dhenry.lendroid.utils.ActionBars;
import com.dhenry.lendroid.utils.Preferences;
import com.dhenry.lendroid.views.SummaryView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.Lazy;
import dagger.ObjectGraph;
import rx.Observable;
import rx.Subscription;
import rx.android.observables.AndroidObservable;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class SummaryFragment extends ScopedFragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private SummaryView summaryView;

    @Inject Lazy<LendingClubClient> lendingClubClient;

    @Inject Preferences prefs;

    @Nullable Subscription subscription;

    @Nullable AccountSummary lastResult;

    @NotNull @Override protected View createScopedView(@NotNull LayoutInflater inflater,
                                                       @NotNull ViewGroup container,
                                                       @Nullable Bundle savedInstanceState) {

        summaryView = (SummaryView)inflater.inflate(R.layout.summary, container, false);
        ButterKnife.inject(this, summaryView);

        swipeRefreshLayout = new SwipeRefreshLayout(container.getContext());

        swipeRefreshLayout.setOnClickListener(view1 -> makeRequest());
        swipeRefreshLayout.setOnRefreshListener(this::makeRequest);

        // Add the fragment's content view to the SwipeRefreshLayout, making sure that it fills
        // the SwipeRefreshLayout
        swipeRefreshLayout.addView(summaryView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        // Make sure that the SwipeRefreshLayout will fill the fragment
        swipeRefreshLayout.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        // Now return the SwipeRefreshLayout as this fragment's content view
        return swipeRefreshLayout;
    }

    @NotNull @Override protected ObjectGraph createDaggerScope(@NotNull Context activity) {
        return Dagger.getObjectGraph(getActivity()).plus(new MainFragmentScopeModule());
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBars.configure(this, actionBar -> {
            ActionBars.homeAsUp(actionBar, false);
            actionBar.setTitle(R.string.app_name);
        });
        Dagger.inject(this);

        init(savedInstanceState);
    }

    private void init(@Nullable Bundle savedInstanceState) {
        if (subscription == null) {
            if (lastResult == null) {
                makeRequest();
            } else {
                updateView();
            }
        } else {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    void updateView() {
        if (getView() != null && lastResult != null && getActivity() != null) {
            swipeRefreshLayout.setRefreshing(false);
            summaryView.draw(lastResult);
        }
    }

    Observable<AccountSummary> createNewSummaryObservable() {
        return lendingClubClient.get().getAccountSummary(prefs.investorId())
                                      .subscribeOn(Schedulers.io());
    }

    void makeRequest() {
        swipeRefreshLayout.setRefreshing(true);
        subscription = AndroidObservable.bindFragment(this, createNewSummaryObservable())
                .doOnEach(notification -> subscription = null)
                .subscribe(summary -> {
                    lastResult = summary;
                    updateView();
                }, e -> {
                    Timber.e(e, "error getting account summary");
                    swipeRefreshLayout.setRefreshing(false);
                });
    }

    @Override public void onDestroy() {
        if (subscription != null) {
            subscription.unsubscribe();
            subscription = null;
        }
        super.onDestroy();
    }
}
