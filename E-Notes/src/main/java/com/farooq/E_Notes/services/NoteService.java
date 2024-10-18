package com.farooq.E_Notes.services;

import com.farooq.E_Notes.model.Note;
import com.farooq.E_Notes.model.dto.NoteRequest;
import com.farooq.E_Notes.model.dto.NoteResponse;
import com.farooq.E_Notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository _noteRepository;

    public Optional<List<Note>> getAll(){
        return Optional.of(_noteRepository.findAll());
    }

    public Optional<Note> getById(String id){
        return _noteRepository.findById(id);
    }

    public Note add(Note addNote){
         return _noteRepository.save(addNote);
    }

    public void update(Note oldNote, Note updateNote) {

        oldNote.setName(updateNote.getName().isBlank() || updateNote.getName().isEmpty()? oldNote.getName() : updateNote.getName());
        oldNote.setDescription(updateNote.getDescription().isBlank() || updateNote.getDescription().isEmpty()? oldNote.getDescription() : updateNote.getDescription());
        _noteRepository.save(oldNote);
    }

    public void delete(String id){
         _noteRepository.deleteById(id);
    }

}
