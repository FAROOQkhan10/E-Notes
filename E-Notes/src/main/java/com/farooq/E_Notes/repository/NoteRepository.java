package com.farooq.E_Notes.repository;

import com.farooq.E_Notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,String> {
}
