package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.insertUser(user);
    }
    @GetMapping
    public List<User> getUsers(){
        return userService.selectAllUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.selectUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User userDetail){
        return userService.updateUser(id,userDetail);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
