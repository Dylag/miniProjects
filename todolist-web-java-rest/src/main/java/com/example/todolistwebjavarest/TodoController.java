package com.example.todolistwebjavarest;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping(path = "/todo")
public class TodoController {

    TodoService service;

    TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping
    public void getReq(){

    }

    @PostMapping
    public String addTodo(@RequestBody Todo todo){
        return todo.txt;
        //service.addTodo(todo);
    }

}
