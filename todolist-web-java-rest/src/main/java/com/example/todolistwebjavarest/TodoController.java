package com.example.todolistwebjavarest;

import org.springframework.web.bind.annotation.*;


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
    public Todo addTodo(@RequestBody Todo todo){
        return service.addTodo(todo);
    }

}
