package com.example.demo.Controller;

import com.example.demo.entity.Notes;
import com.example.demo.entity.SignInDto;
import com.example.demo.entity.SignInResponse;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Stack;


@RestController
public class UserControllers {
    

    @Autowired
    UserService service;

    @PostMapping("/signup")
    public String createAccount(@RequestBody User user){
        return service.signUp(user);
    }

    @PostMapping("/signin")
    public SignInResponse sign(@RequestBody SignInDto signInDto){
        return service.signIn(signInDto);

    }

    @GetMapping(value = "/getuser")
    public User getNotes(@RequestParam(name = "id") Long id){
        return service.getNotes(id);
    }


}
