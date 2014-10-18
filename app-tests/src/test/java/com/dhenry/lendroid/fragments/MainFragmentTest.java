package com.dhenry.lendroid.fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.RobolectricGradleTestRunner;
import com.dhenry.lendroid.dagger.Dagger;
import com.dhenry.lendroid.dagger.ScopedContextWrapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import dagger.Module;
import dagger.ObjectGraph;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(RobolectricGradleTestRunner.class)
public class MainFragmentTest {
    @Module static class MyModule {}

    @Test public void testInjectorContextWrapper() {
        Robolectric.buildActivity(Activity.class).create().get();
        ObjectGraph objectGraph =
                Dagger.getObjectGraph(Robolectric.application).plus(new MyModule());
        Context context = new ScopedContextWrapper(Robolectric.application, objectGraph);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.main, new FrameLayout(context));
        assertThat(Dagger.getObjectGraph(view.getContext())).isEqualTo(objectGraph);
    }
}