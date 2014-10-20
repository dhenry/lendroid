package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Portfolio {

    int portfolioId;
    @NotNull String portfolioName;
    @NotNull String portfolioDescription;
}
