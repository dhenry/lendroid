package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Note {

    int loanLength;
    @NotNull String loanStatus;
    @NotNull BigDecimal loanId;
    @NotNull BigDecimal noteId;
    @NotNull String grade;
    @NotNull BigDecimal loanAmount;
    @NotNull BigDecimal noteAmount;
    @NotNull BigDecimal interestRate;
    @NotNull BigDecimal orderId;
    @NotNull String issueDate;
    @NotNull String orderDate;
    @NotNull String loanStatusDate;
    @NotNull BigDecimal paymentsReceived;
}
