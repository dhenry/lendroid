package com.dhenry.lendroid.utils;

import org.jetbrains.annotations.NotNull;

import de.devland.esperandro.annotations.Default;
import de.devland.esperandro.annotations.SharedPreferences;

public @SharedPreferences interface Preferences {

    @Default(ofString = "API Key") public String apiKey();

    public void apiKey(@NotNull String apiKey);

    @Default(ofString = "Investor Id") public String investorId();

    public void investorId(@NotNull String investorId);
}
