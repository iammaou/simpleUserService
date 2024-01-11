package com.example.userService.controller;

import com.example.userService.service.userService;
import com.example.userService.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private userService serv;

    @GetMapping("/users")
    public List<User> getAll() {
        return serv.listAll();
    }

    @GetMapping("/users/{id}")
    public Object getUser(@PathVariable Long id) {
        return serv.get(id);
    }

    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody User user) {
        return serv.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        serv.delete(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}