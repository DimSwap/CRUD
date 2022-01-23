package com.example.crud.repository;

import com.example.crud.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoEntity,Long> {

}
