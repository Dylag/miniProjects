package com.example.todolistwebjavarest.todo;


import com.example.todolistwebjavarest.auth.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    TodoRepository todoDB;

    UserRepository userDB;

    TodoService (TodoRepository db, UserRepository udb){
        this.todoDB = db;
        this.userDB = udb;
    }

    public Todo addTodo(Todo newTodo, String username){
        System.out.println("add todo from service");
        newTodo.setUserId(userDB.findByName(username).get().getId());
        todoDB.save(newTodo);

        System.out.println(todoDB.getLastTodoByUserId(newTodo.getUserId()).get().getTxt());
        return todoDB.getLastTodoByUserId(newTodo.getUserId()).get();
    }

    public String deleteTodo(String username, int id){
        return null;
    }

}
