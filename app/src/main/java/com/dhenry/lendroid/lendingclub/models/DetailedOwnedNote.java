package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DetailedOwnedNote extends OwnedNote {

    int portfolioId;
    int	loanLength;
    boolean canBeTraded;
    @NotNull String portfolioName;
    @NotNull BigDecimal accruedInterest;
    @NotNull String purpose;
    @NotNull String loanStatusDate;
    @NotNull String creditTrend;
    @NotNull String currentPaymentStatus;
    @NotNull String nextPaymentDate;
    @NotNull BigDecimal principalPending;
    @NotNull BigDecimal interestPending;
    @NotNull BigDecimal interestReceived;
    @NotNull BigDecimal principalReceived;

}
