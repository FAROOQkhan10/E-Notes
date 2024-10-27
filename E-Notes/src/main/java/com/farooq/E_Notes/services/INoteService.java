package com.farooq.E_Notes.services;

import com.farooq.E_Notes.model.Note;

import java.util.List;
import java.util.Optional;

public interface INoteService {

    Optional<List<Note>> getAll();

    Optional<Note> getById(String id);

    Note add(Note addNote);

    void update(Note oldNote, Note updateNote);

    void delete(String id);
}
