package com.example.crud.model;

import com.example.crud.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private Long id;
    private String username;

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    private List<Todo> todoList;
    public static Users toModel(UserEntity userEntity){
        Users model = new Users();
        model.setId(userEntity.getId());
        model.setUsername(userEntity.getUsername());
        model.setTodoList(userEntity.getTodoEntityList().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;

    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
