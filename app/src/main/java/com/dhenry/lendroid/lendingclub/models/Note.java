package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
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


    public static final String A = "A";

    public enum Grade {
        A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), G("G");

        @NotNull @Getter String value;

        Grade(@NotNull String value) {
            this.value = value;
        }
    }
}
