package com.example.crud.service;

import com.example.crud.entity.TodoEntity;
import com.example.crud.entity.UserEntity;
import com.example.crud.model.Todo;
import com.example.crud.repository.TodoRepo;
import com.example.crud.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class TodoSevice {
    private TodoRepo todoRepo;
    private UserRepo userRepo;


    public void UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public TodoSevice(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public Todo createTodo(TodoEntity todoEntity,Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todoEntity.setUser(user);
        return Todo.toModel(todoRepo.save(todoEntity));
    }
    public Todo completeTodo(Long id){
       TodoEntity todoEntity  =todoRepo.findById(id).get();
       todoEntity.setCompleted(!todoEntity.getCompleted());
       return Todo.toModel(todoRepo.save(todoEntity));

    }
}
