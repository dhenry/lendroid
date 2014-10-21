package com.dhenry.lendroid.views;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

import com.dhenry.lendroid.utils.NumberFormats;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.text.NumberFormat;

public final class FormattedTextView extends TextView
{
    private BigDecimal amount = null;
    @NotNull private NumberFormat formatter = NumberFormats.CURRENCY_FORMAT;

    public FormattedTextView(final Context context)
    {
        super(context);
    }

    public FormattedTextView(final Context context, final AttributeSet attrs)
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
            text = new SpannableStringBuilder(formatter.format(amount));
        }
        else {
            text = null;
        }

        setText(text);
    }

    public void setFormatter(@NotNull NumberFormat formatter) {
        this.formatter = formatter;
    }
}
