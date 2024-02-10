package com.example.userService.controller;

import com.example.userService.model.Postal;
import com.example.userService.service.PostalService;
import com.example.userService.service.UserService;
import com.example.userService.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userServ;
    public UserController(UserService userServ){
        this.userServ = userServ;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userServ.listAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userServ.get(id);
    }

    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody User user) throws IOException {
        return userServ.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServ.delete(id);
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