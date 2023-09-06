package com.example.todolistwebjavarest.session;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class SessionService {

    SessionRepository sessionDB;

    SessionService(SessionRepository sessionDB){
        this.sessionDB = sessionDB;
    }

    public UUID createSession(String username){
        Session newSession = new Session(username);
        sessionDB.save(newSession);
        return newSession.getId();
    }

}
