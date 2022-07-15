package com.example.demo.Repo;

import com.example.demo.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepo extends JpaRepository<Notes,Long> {

    List<Notes> getNotesByUserId(Long id);

}
