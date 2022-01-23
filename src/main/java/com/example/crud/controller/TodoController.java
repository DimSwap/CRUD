package com.example.crud.controller;

import com.example.crud.entity.TodoEntity;
import com.example.crud.service.TodoSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
@Autowired
private TodoSevice todoSevice;
    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long id){
        try {
            return ResponseEntity.ok(todoSevice.createTodo(todo,id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Happen mistake");
        }
    }
    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){

        try {
            return ResponseEntity.ok(todoSevice.completeTodo(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Happen mistake");
        }
    }

}
