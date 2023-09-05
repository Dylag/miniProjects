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
        System.out.println("add todo");
        if(username.equals("no name")) {
            System.out.println("no username, returning new Todo()...");
            return new Todo();
        }
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
    public JsonResponse login(HttpServletResponse servletResponse,@RequestBody User user){
        String response = userService.login(user);

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        if(response.equals("ok")) {
            System.out.println("adding cookie");
            servletResponse.addCookie(new Cookie("username", user.getUsername()));
        }

        return new JsonResponse(response);
    }

}
