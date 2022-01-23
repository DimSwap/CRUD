package com.example.crud.service;

import com.example.crud.entity.UserEntity;
import com.example.crud.exeption.UserAlreadyExistExeption;
import com.example.crud.exeption.UserNotFoundExep;
import com.example.crud.model.Users;
import com.example.crud.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity registration (UserEntity user) throws UserAlreadyExistExeption {
        if(userRepo.findByUsername(user.getUsername())!= null){
            throw new UserAlreadyExistExeption("A user with the same name already exists");
        }
        return userRepo.save(user);
    }

    public Users getOneUser(Long id) throws UserNotFoundExep {
        UserEntity user = userRepo.findById(id).get();
        if(user==null){
            throw new UserNotFoundExep("User not found ");
        }
        return Users.toModel(user);
    }

    public Long deleleUser(Long id){
        userRepo.deleteById(id);
        return id;
    }

}
