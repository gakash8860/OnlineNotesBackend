package com.example.demo.Controller;


import com.example.demo.Repo.NotesRepo;
import com.example.demo.entity.Notes;
import com.example.demo.entity.User;
import com.example.demo.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

@RestController
public class NoteController {

    @Autowired
    NotesService service;

    @PostMapping("/add")
    public Notes add(@RequestBody Notes notes){
        return service.addNotes(notes);
    }


    @GetMapping(value = "/add")
    public List<Notes> getNotes(@RequestParam(name = "id") Long id){
        return service.getNotes(id);
    }


    @GetMapping("/getall")
    public List<Notes> getAllNotes(){
        return service.getAllNotes();
    }

}
