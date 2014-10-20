package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderExecutionResponse {

    int orderInstructId;
    @NotNull List<OrderConfirmation> orderConfirmations;
}
