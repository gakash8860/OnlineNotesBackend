package com.example.demo.services;

import com.example.demo.Repo.UserRepo;
import com.example.demo.entity.AuthenticationToken;
import com.example.demo.entity.SignInDto;
import com.example.demo.entity.SignInResponse;
import com.example.demo.entity.User;
import com.example.demo.exceptions.AuthenticationFailedException;
import com.example.demo.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Transactional
    public String signUp( User user){


        ///check user is already present
        if (Objects.nonNull(userRepo.findByEmail(user.getEmail()))){
            throw new CustomException("user already present");
        }

        //hash the password

        String encrypt;
        try {
            encrypt=hashPassword(user.getPassword());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //save User
        User user1 = new User( user.getName(), user.getEmail(),user.getPhoneNumber(),encrypt);

        userRepo.save(user1);


        //Creating token

        final AuthenticationToken authenticationToken = new AuthenticationToken(user1);

        authenticationService.saveConfirmationToken(authenticationToken);

        return "Created";
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }


    public SignInResponse signIn(SignInDto signInDto) {


        //find User By Email
        User user = userRepo.findByEmail(signInDto.getEmail());
        if (Objects.isNull(user)){
            throw new AuthenticationFailedException("Bad Credential");
        }


        //hash the password

        try {
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
                throw new AuthenticationFailedException("Wrong Password");
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } {

        }



        //compare the password in DB


        // if password match
        AuthenticationToken token = authenticationService.getToken(user);
//

        System.out.println("TOKEN ++>>> "+token);
//        // retrive token
//

        return new SignInResponse("Success",token.getToken());


    }

    public User getNotes(Long id) {
    return  userRepo.getUserById(id);
    }






}
