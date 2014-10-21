package com.dhenry.lendroid.views;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

import com.dhenry.lendroid.utils.NumberFormats;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public final class CurrencyTextView extends TextView
{
    private BigDecimal amount = null;

    public CurrencyTextView(final Context context)
    {
        super(context);
    }

    public CurrencyTextView(final Context context, final AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setAmount(@NotNull final BigDecimal amount)
    {
        this.amount = amount;
        updateView();
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();

        setSingleLine();
    }

    private void updateView()
    {
        final Editable text;

        if (amount != null) {
            text = new SpannableStringBuilder(NumberFormats.CURRENCY_FORMAT.format(amount));
        }
        else {
            text = null;
        }

        setText(text);
    }
}
