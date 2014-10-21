package com.dhenry.lendroid.processor;

import com.dhenry.lendroid.lendingclub.models.Note;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


public abstract class NoteProcessor {

    @NotNull @Getter List<Note> notes = new ArrayList<>();

    public abstract void process(Note note);
}
