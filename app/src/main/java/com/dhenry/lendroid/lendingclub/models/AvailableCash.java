package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AvailableCash {

    int investorId;
    @NotNull BigDecimal availableCash;
}
