package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PortfolioRequest {

    int aid;                                // actorId
    @NotNull String portfolioName;
    @NotNull String portfolioDescription;
}
