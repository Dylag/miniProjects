package com.example.todolistwebjavarest;

import com.example.todolistwebjavarest.auth.User;
import com.example.todolistwebjavarest.auth.UserService;
import com.example.todolistwebjavarest.todo.Todo;
import com.example.todolistwebjavarest.todo.TodoService;
import jakarta.servlet.http.Cookie;
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
    public Todo addTodo(@RequestBody Todo todo, @CookieValue(name = "username",defaultValue = "no name") String username){
        if(username.equals("no name"))
            return new Todo();
        return todoService.addTodo(todo,username);
    }

    @PostMapping(path = "/auth/reg")
    public JsonResponse register(HttpServletResponse servletResponse, @RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        String response = userService.register(user);

        if(response.equals("ok"))
            servletResponse.addCookie(new Cookie("username",user.getUsername()));



        return new JsonResponse(response);
    }

    //@CookieValue(value = "username", defaultValue = "Atta"
    @PostMapping(path = "/auth/login")
    public JsonResponse login(@RequestBody User user,HttpServletResponse servletResponse){
        String response = userService.login(user);

        if(response.equals("ok"))
            servletResponse.addCookie(new Cookie("username",user.getUsername()));
        System.out.println(response);
        return new JsonResponse(response);
    }

}
