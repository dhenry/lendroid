package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderConfirmation {

    int loanId;
    @NotNull BigDecimal requestedAmount;
    @NotNull BigDecimal investedAmount;
    @NotNull List<String> executionStatus;

}
