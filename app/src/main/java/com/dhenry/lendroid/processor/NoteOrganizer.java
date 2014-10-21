package com.dhenry.lendroid.processor;

import com.dhenry.lendroid.lendingclub.models.Note;
import com.dhenry.lendroid.lendingclub.models.Notes;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import lombok.Getter;

public class NoteOrganizer {
    @NotNull @Getter NoteProcessor aGradeProcessor;
    @NotNull @Getter NoteProcessor bGradeProcessor;
    @NotNull @Getter NoteProcessor cGradeProcessor;
    @NotNull @Getter NoteProcessor dGradeProcessor;
    @NotNull @Getter NoteProcessor eGradeProcessor;
    @NotNull @Getter NoteProcessor fGradeProcessor;
    @NotNull @Getter NoteProcessor gGradeProcessor;

    @NotNull @Getter List<Note> notes;

    public NoteOrganizer(Notes notes) {
        this.notes = notes.getMyNotes();

        aGradeProcessor = new NoteGradeProcessor(Note.Grade.A.getValue());
        bGradeProcessor = new NoteGradeProcessor(Note.Grade.B.getValue());
        cGradeProcessor = new NoteGradeProcessor(Note.Grade.C.getValue());
        dGradeProcessor = new NoteGradeProcessor(Note.Grade.D.getValue());
        eGradeProcessor = new NoteGradeProcessor(Note.Grade.E.getValue());
        fGradeProcessor = new NoteGradeProcessor(Note.Grade.F.getValue());
        gGradeProcessor = new NoteGradeProcessor(Note.Grade.G.getValue());

        for (Note note : (List<Note>) notes.getMyNotes()) {
            aGradeProcessor.process(note);
            bGradeProcessor.process(note);
            cGradeProcessor.process(note);
            dGradeProcessor.process(note);
            eGradeProcessor.process(note);
            fGradeProcessor.process(note);
            gGradeProcessor.process(note);
        }
    }
}
