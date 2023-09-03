package com.example.todolistwebjavarest.auth;


import com.example.todolistwebjavarest.JsonResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository db;

    public UserService(UserRepository db){
        this.db = db;
    }

    public String register(User newUser){
        if(db.findByName(newUser.getName()).isPresent())
            return "Nickname is already taken";
        db.save(newUser);
        return "ok";
    }

    public String login(User user){
        Optional<User> possibleUser = db.findByName(user.getName());
        if(db.findByName(user.getName()).isEmpty())
            return "No user with this nickname";

        if(!possibleUser.get().getPassword().equals(user.getPassword()))
            return "Wrong password";

        return "ok";
    }

}
