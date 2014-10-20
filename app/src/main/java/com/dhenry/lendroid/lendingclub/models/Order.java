package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {

    int loanId;
    int portfolioId;
    @NotNull BigDecimal requestedAmount;
}
