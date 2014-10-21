package com.dhenry.lendroid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.lendingclub.models.AccountSummary;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SummaryView extends LinearLayout {

    @InjectView(R.id.account_total) CurrencyTextView accountTotal;

    @NotNull AccountSummary accountSummary;

    public SummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override protected void onFinishInflate() {
        if (!isInEditMode()) {
            ButterKnife.inject(this);
        }
    }

    public void draw(@NotNull AccountSummary accountSummary) {
        this.accountSummary = accountSummary;
        accountTotal.setAmount(accountSummary.getAccountTotal());
    }
}
