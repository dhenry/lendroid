package com.dhenry.lendroid.dagger.modules;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.dhenry.lendroid.MainActivity;
import com.dhenry.lendroid.utils.DatabaseHelper;
import com.dhenry.lendroid.utils.Preferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.devland.esperandro.Esperandro;
import de.devland.esperandro.serialization.JacksonSerializer;

@Module(addsTo = ApplicationScopeModule.class,
        injects = {
                MainActivity.class
        },
        library = true)
public class MainActivityScopeModule {
    @Provides @Singleton ObjectMapper provideJackson() { return new ObjectMapper(); }

    @Provides @Singleton Preferences providePreferences(Context context,
                                                        ObjectMapper objectMapper) {
        Esperandro.setSerializer(new JacksonSerializer(objectMapper));
        return Esperandro.getPreferences(Preferences.class, context);
    }

    @Provides @Singleton DatabaseHelper provideDatabaseHelper(Context context) {
        return new DatabaseHelper(context);
    }
}
