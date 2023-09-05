package com.example.todolistwebjavarest.todo;


import com.example.todolistwebjavarest.auth.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    TodoRepository db;

    UserRepository udb;

    TodoService (TodoRepository db, UserRepository udb){
        this.db = db;
        this.udb = udb;
    }

    public Todo addTodo(Todo newTodo, String username){
        System.out.println("add todo from service");
        newTodo.setUserId(udb.findByName(username).get().getId());
        db.save(newTodo);

        System.out.println(db.getLastTodoByUserId(newTodo.getUserId()).get().getTxt());
        return db.getLastTodoByUserId(newTodo.getUserId()).get();
    }

}
