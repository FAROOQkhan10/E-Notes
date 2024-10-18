package com.farooq.E_Notes.controller;

import com.farooq.E_Notes.model.Note;
import com.farooq.E_Notes.model.dto.NoteRequest;
import com.farooq.E_Notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<Note> add(@RequestBody Note addNote){
        try{
            _noteService.add(addNote);
            return new ResponseEntity<>(addNote,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Note> update(@PathVariable String id,@RequestBody Note updateNote){
        try{

            Note old = _noteService.getById(id).orElse(null);
            if(old!=null){
                _noteService.update(old,updateNote);
                return new ResponseEntity<>(old, HttpStatus.OK);
            }

            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        try{
            Note note = _noteService.getById(id).orElse(null);
            if(note != null){
                _noteService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
