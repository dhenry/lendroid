package com.dhenry.lendroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.dhenry.lendroid.dagger.Dagger;
import com.dhenry.lendroid.dagger.Injector;
import com.dhenry.lendroid.dagger.modules.MainActivityScopeModule;
import com.dhenry.lendroid.fragments.LoginFragment;
import com.dhenry.lendroid.fragments.MainFragment;
import com.dhenry.lendroid.fragments.PrefsFragment;
import com.dhenry.lendroid.fragments.SummaryFragment;
import com.dhenry.lendroid.utils.Preferences;
import com.github.mttkay.memento.Memento;
import com.github.mttkay.memento.MementoCallbacks;
import com.github.mttkay.memento.Retain;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import dagger.ObjectGraph;
import lombok.Getter;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends Activity implements MementoCallbacks, Injector {
    static {
        CalligraphyConfig.initDefault(null);
    }

    @Inject @NotNull Preferences preferences; // injected from activity scope

    @Retain @NotNull @Getter ObjectGraph objectGraph;

    @Override protected void attachBaseContext(@NotNull Context newBase) {
        super.attachBaseContext(new CalligraphyContextWrapper(newBase));
    }

    @Override public void onAttachFragment(Fragment fragment) {
        Memento.retain(this);
        super.onAttachFragment(fragment);
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Memento.retain(this);
        Dagger.inject(this);
        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(android.R.id.content) == null) {
            fm.beginTransaction()
                    .add(android.R.id.content, new SummaryFragment())
                    .commit();
        }
    }

    @Override public void onLaunch() {
        objectGraph = Dagger.getObjectGraph(getApplication())
                .plus(new MainActivityScopeModule());
    }

    @Override public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getFragmentManager().popBackStack();
                return true;

            case R.id.action_settings:
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new PrefsFragment())
                        .addToBackStack(null)
                        .commit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}