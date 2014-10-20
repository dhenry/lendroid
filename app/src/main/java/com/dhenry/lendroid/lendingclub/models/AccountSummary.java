package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountSummary {

    int investorId; //	Investor ID
    int totalNotes; // Total notes
    int totalPortfolios; // Total portfolios
    @NotNull BigDecimal availableCash;//	BigDecimal	Available cash amount
    @NotNull BigDecimal accruedInterest; // interest amount
    @NotNull BigDecimal outstandingPrincipal; // Outstanding principal amount
    @NotNull BigDecimal accountTotal; // Account total
    @NotNull BigDecimal infundingBalance; // In-Funding balance
    @NotNull BigDecimal receivedInterest; // Received interest
    @NotNull BigDecimal receivedPrincipal; // Received principal
    @NotNull BigDecimal receivedLateFees; // Received late fees

}
