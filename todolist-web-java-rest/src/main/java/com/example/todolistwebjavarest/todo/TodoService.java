package com.example.todolistwebjavarest.todo;


import org.springframework.stereotype.Service;

@Service
public class TodoService {

    TodoRepository db;

    TodoService (TodoRepository db){
        this.db = db;
    }

    public Todo addTodo(Todo newTodo){
        db.save(newTodo);
        return db.getLastTodo();
    }

}
