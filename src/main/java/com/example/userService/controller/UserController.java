package com.example.userService.controller;

import com.example.userService.service.userService;
import com.example.userService.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private userService serv;

    @GetMapping("/users")
    public List<User> getAll() {
        return serv.listAll();
    }

    @GetMapping("/users/{id}")
    public Object getUser(@PathVariable Long id){
        return serv.get(id);
    }

    @PostMapping("/users/add")
    public void saveUser(@RequestBody User User) {
        serv.save(User);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        serv.delete(id);
    }
}