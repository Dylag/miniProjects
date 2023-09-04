package com.example.todolistwebjavarest.todo;


import com.example.todolistwebjavarest.auth.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    TodoRepository db;

    UserRepository udb;

    TodoService (TodoRepository db){
        this.db = db;
    }

    public Todo addTodo(Todo newTodo, String username){
        newTodo.userId = udb.findByName(username).get().getId();
        db.save(newTodo);
        System.out.println(db.getLastTodo().getTxt());
        return db.getLastTodo();
    }

}
