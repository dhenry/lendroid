package com.dhenry.lendroid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.dagger.Dagger;
import com.dhenry.lendroid.dagger.ScopedFragment;
import com.dhenry.lendroid.dagger.modules.MainFragmentScopeModule;
import com.dhenry.lendroid.utils.ActionBars;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import dagger.ObjectGraph;

public class LoginFragment extends ScopedFragment {

    @InjectView(R.id.usernameInput) AutoCompleteTextView usernameInput;
    @InjectView(R.id.passwordInput) EditText passwordInput;
    @InjectView(R.id.loginButton) Button loginButton;
    @InjectView(R.id.progressIndicator) ProgressBar progressIndicator;

    @NotNull @Override protected View createScopedView(@NotNull LayoutInflater inflater,
                                                       @NotNull ViewGroup container,
                                                       @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @NotNull @Override protected ObjectGraph createDaggerScope(@NotNull Context activity) {
        return Dagger.getObjectGraph(getActivity()).plus(new MainFragmentScopeModule());
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBars.configure(this, actionBar -> {
            ActionBars.homeAsUp(actionBar, false);
            actionBar.setTitle(R.string.app_name);
        });
        Dagger.inject(this);
    }

    @OnClick(R.id.loginButton) void onLoginClicked() {
        String userEmail = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        Toast.makeText(getScopedContext(),
                String.format("Hello %s", userEmail), Toast.LENGTH_LONG).show();
    }
}
