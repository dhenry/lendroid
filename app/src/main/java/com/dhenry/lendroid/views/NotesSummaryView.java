package com.dhenry.lendroid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.lendingclub.models.Note;
import com.dhenry.lendroid.lendingclub.models.Notes;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NotesSummaryView extends LinearLayout {

    @InjectView(R.id.notes_count) TextView notesCount;

    @NotNull Notes<Note> notes;

    public NotesSummaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        if (!isInEditMode()) {
            ButterKnife.inject(this);
        }
    }

    public void draw(@NotNull Notes<Note> notes) {
        this.notes = notes;

        notesCount.setText(String.valueOf(notes.getMyNotes().size()));
    }
}
