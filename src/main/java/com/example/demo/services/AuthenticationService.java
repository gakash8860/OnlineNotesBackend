package com.example.demo.services;


import com.example.demo.Repo.TokenRepo;
import com.example.demo.entity.AuthenticationToken;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepo repo;


    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        repo.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        System.out.println("TTTTTTTT     ==>>> ");
        return repo.findTokenById(Math.toIntExact(user.getId()));
    }


    public AuthenticationService() {
    }
}
