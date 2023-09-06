package com.example.todolistwebjavarest.todo;


import com.example.todolistwebjavarest.auth.UserRepository;
import com.example.todolistwebjavarest.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TodoService {

    TodoRepository todoDB;

    UserRepository userDB;

    SessionRepository sessionDB;

    TodoService (TodoRepository db, UserRepository udb, SessionRepository sessionDB){
        this.todoDB = db;
        this.userDB = udb;
        this.sessionDB = sessionDB;
    }

    public Todo addTodo(Todo newTodo, UUID sessionId){

        int userId = sessionDB.findById(sessionId).get().getUserId();

        newTodo.setUserId(userId);
        todoDB.save(newTodo);

        return todoDB.getLastTodoByUserId(userId).get();
    }

    public String deleteTodo(String username, int id){
        return null;
    }

}
