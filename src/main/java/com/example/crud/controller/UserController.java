package com.example.crud.controller;

import com.example.crud.entity.UserEntity;
import com.example.crud.exeption.UserAlreadyExistExeption;
import com.example.crud.exeption.UserNotFoundExep;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

@Autowired
private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Changes saved successfully");
        } catch (UserAlreadyExistExeption e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Happen mistake");
        }
    }


    @GetMapping
    public ResponseEntity getOneUsers(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(userService.getOneUser(id));
        } catch (UserNotFoundExep e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Happen mistake");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleleUser(id));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Happen mistake");
        }
    }


}
