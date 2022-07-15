package com.example.demo.services;


import com.example.demo.Repo.NotesRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.entity.Notes;
import com.example.demo.entity.User;
import com.example.demo.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

@Service
public class NotesService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    NotesRepo notesRepo;


    public Notes addNotes(Notes notes){
        System.out.println("ASASASASSA"+notes.getUser());
       return notesRepo.save(notes);



    }


    public List<Notes> getNotes(Long id) {
        System.out.println("EEENTRY  "+notesRepo.getNotesByUserId(id)+" "+id);
       List<Notes> notes = new ArrayList<>();


        notes.addAll(notesRepo.getNotesByUserId(id)) ;
        System.out.println("EEENTRY 1111"+notes.get(1));

        return notes;

    }

    public List<Notes> getAllNotes() {
        System.out.println(notesRepo.findAll()+"dsadaadsdsadsaads");
    return notesRepo.findAll();
    }
}
