package com.example.todolistwebjavarest;


import org.springframework.stereotype.Service;

@Service
public class TodoService {

    TodoRepository db;

    TodoService (TodoRepository db){
        this.db = db;
    }

    public void addTodo(Todo newTodo){
        db.save(newTodo);
    }

}
