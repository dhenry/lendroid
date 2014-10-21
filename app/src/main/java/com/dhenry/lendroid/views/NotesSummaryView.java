package com.dhenry.lendroid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dhenry.lendroid.R;
import com.dhenry.lendroid.processor.NoteOrganizer;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NotesSummaryView extends LinearLayout {

    @InjectView(R.id.notes_count) TextView notesCount;
    @InjectView(R.id.a_grade_notes) TextView aGradeNotes;
    @InjectView(R.id.b_grade_notes) TextView bGradeNotes;
    @InjectView(R.id.c_grade_notes) TextView cGradeNotes;
    @InjectView(R.id.d_grade_notes) TextView dGradeNotes;
    @InjectView(R.id.e_grade_notes) TextView eGradeNotes;
    @InjectView(R.id.f_grade_notes) TextView fGradeNotes;
    @InjectView(R.id.g_grade_notes) TextView gGradeNotes;

    @NotNull NoteOrganizer notes;

    public NotesSummaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        if (!isInEditMode()) {
            ButterKnife.inject(this);
        }
    }

    public void draw(@NotNull NoteOrganizer organizedNotes) {
        this.notes = organizedNotes;

        notesCount.setText(String.valueOf(organizedNotes.getNotes().size()));

        aGradeNotes.setText(String.valueOf(organizedNotes.getAGradeProcessor().getNotes().size()));
        bGradeNotes.setText(String.valueOf(organizedNotes.getBGradeProcessor().getNotes().size()));
        cGradeNotes.setText(String.valueOf(organizedNotes.getCGradeProcessor().getNotes().size()));
        dGradeNotes.setText(String.valueOf(organizedNotes.getDGradeProcessor().getNotes().size()));
        eGradeNotes.setText(String.valueOf(organizedNotes.getEGradeProcessor().getNotes().size()));
        fGradeNotes.setText(String.valueOf(organizedNotes.getFGradeProcessor().getNotes().size()));
        gGradeNotes.setText(String.valueOf(organizedNotes.getGGradeProcessor().getNotes().size()));
    }
}
