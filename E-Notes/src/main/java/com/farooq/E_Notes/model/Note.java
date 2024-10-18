package com.farooq.E_Notes.model;


import com.farooq.E_Notes.model.dto.NoteRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Note {

     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     public String id;
     public String name;
     public String description;

}
