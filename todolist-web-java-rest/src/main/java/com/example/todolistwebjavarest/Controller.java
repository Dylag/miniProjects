package com.example.todolistwebjavarest;

import com.example.todolistwebjavarest.auth.User;
import com.example.todolistwebjavarest.auth.UserService;
import com.example.todolistwebjavarest.todo.Todo;
import com.example.todolistwebjavarest.todo.TodoService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
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

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PostMapping(path = "/reg")
    public JsonResponse register(@RequestBody User user, HttpServletResponse servletResponse){

        String response = userService.register(user);

        if(response.equals("ok"))
            servletResponse.addCookie(new Cookie("name",user.getName()));

        return new JsonResponse(response);
    }

    //@CookieValue(value = "username", defaultValue = "Atta"
    @PostMapping(path = "/login")
    public JsonResponse login(@RequestBody User user,HttpServletResponse servletResponse){
        String response = userService.login(user);

        if(response.equals("ok"))
            servletResponse.addCookie(new Cookie("name",user.getName()));
        System.out.println(response);
        return new JsonResponse(response);
    }


    @GetMapping
    public JsonResponse getUsername(@CookieValue(value = "name",defaultValue = "no name") String name){
        return new JsonResponse("hello, " + name);
    }
}
