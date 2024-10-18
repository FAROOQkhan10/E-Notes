package com.farooq.E_Notes.services;

import com.farooq.E_Notes.model.Note;
import com.farooq.E_Notes.model.dto.NoteResponse;
import com.farooq.E_Notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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


}
