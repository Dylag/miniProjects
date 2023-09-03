package com.example.todolistwebjavarest.todo;

import com.example.todolistwebjavarest.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query(value = """
                SELECT * FROM todo
                ORDER BY id DESC
                LIMIT 1""",nativeQuery = true)
    Todo getLastTodo();

}
