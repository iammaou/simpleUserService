package com.example.userService.controller;

import com.example.userService.service.userService;
import com.example.userService.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private userService serv;

    @GetMapping("/users")
    public String getAll() {
        return serv.listAll().toString();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        return serv.get(id);
    }

    @PostMapping("/users")
    public String saveUser(@RequestBody User User) {
        return serv.save(User);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable int id){
        serv.delete(id);
    }
}