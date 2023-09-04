package com.example.todolistwebjavarest.auth;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository db;

    public UserService(UserRepository db){
        this.db = db;
    }

    public String register(User newUser){
        if(db.findByName(newUser.getUsername()).isPresent())
            return "Nickname is already taken";
        db.save(newUser);
        return "ok";
    }

    public String login(User user){
        Optional<User> possibleUser = db.findByName(user.getUsername());
        if(db.findByName(user.getUsername()).isEmpty())
            return "No user with this nickname";

        if(!possibleUser.get().getPassword().equals(user.getPassword()))
            return "Wrong password";

        return "ok";
    }

}
