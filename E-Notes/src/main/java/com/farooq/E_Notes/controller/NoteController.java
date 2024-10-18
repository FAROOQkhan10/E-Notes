package com.farooq.E_Notes.controller;

import com.farooq.E_Notes.model.Note;
import com.farooq.E_Notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService _noteService;

    @GetMapping
    public ResponseEntity<Optional<List<Note>>> getAll(){
        try{
            Optional<List<Note>> all = _noteService.getAll();
            if(all.isPresent()){
                return new ResponseEntity<>(all, HttpStatus.OK);
            }
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Note>> getById(@PathVariable String id){
         try{
             Optional<Note> byId = _noteService.getById(id);
             if(byId.isPresent()){
                 return new ResponseEntity<>(byId, HttpStatus.OK);
             }
             else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
    }




}
