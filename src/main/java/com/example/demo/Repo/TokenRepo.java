package com.example.demo.Repo;


import com.example.demo.entity.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken, Integer> {



        AuthenticationToken findTokenById(int user);

    

}
