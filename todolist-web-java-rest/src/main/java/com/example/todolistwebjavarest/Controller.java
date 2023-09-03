package com.example.todolistwebjavarest;

import com.example.todolistwebjavarest.auth.User;
import com.example.todolistwebjavarest.auth.UserService;
import com.example.todolistwebjavarest.todo.Todo;
import com.example.todolistwebjavarest.todo.TodoService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/todo")
public class Controller {

    TodoService todoService;

    UserService userService;


    Controller(TodoService todoService, UserService userService){
        this.todoService = todoService;
        this.userService = userService;
    }

    @GetMapping
    public void getReq(){

    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PostMapping(path = "/reg")
    public JsonResponse register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping(path = "/login")
    public JsonResponse login(@RequestBody User user){
        return userService.login(user);
    }
}
