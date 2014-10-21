package com.dhenry.lendroid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.lendingclub.models.AccountSummary;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AccountSummaryView extends LinearLayout {

    @InjectView(R.id.account_number) TextView accountNumber;
    @InjectView(R.id.account_total) FormattedTextView accountTotal;
    @InjectView(R.id.available_cash) FormattedTextView availableCash;
    @InjectView(R.id.accrued_interest) FormattedTextView accruedInterest;
    @InjectView(R.id.received_interest) FormattedTextView receivedInterest;

    @NotNull AccountSummary accountSummary;

    public AccountSummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override protected void onFinishInflate() {
        if (!isInEditMode()) {
            ButterKnife.inject(this);
        }
    }

    public void draw(@NotNull AccountSummary accountSummary) {
        this.accountSummary = accountSummary;
        accountNumber.setText(String.valueOf(accountSummary.getInvestorId()));
        accountTotal.setAmount(accountSummary.getAccountTotal());
        availableCash.setAmount(accountSummary.getAvailableCash());
        accruedInterest.setAmount(accountSummary.getAccruedInterest());
        receivedInterest.setAmount(accountSummary.getReceivedInterest());
    }
}
