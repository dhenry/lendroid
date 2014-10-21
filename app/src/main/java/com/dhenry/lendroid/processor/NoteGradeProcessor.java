package com.dhenry.lendroid.processor;

import com.dhenry.lendroid.lendingclub.models.Note;

import org.jetbrains.annotations.NotNull;

public class NoteGradeProcessor extends NoteProcessor {

    @NotNull String grade;

    public NoteGradeProcessor(@NotNull String grade) {
        this.grade = grade;
    }

    @Override
    public void process(Note note) {
        if (note.getGrade().equals(this.grade)) {
            getNotes().add(note);
        }
    }
}
