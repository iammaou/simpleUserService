package com.example.userService.controller;

import com.example.userService.service.userService;
import com.example.userService.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
    public String saveUser(@Valid @RequestBody User User) {
        if (emailValidation(User.getEmail()) && dateValidation(User.getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
            serv.save(User);
            return "success";
        } else return "error";
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        serv.delete(id);
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

    public boolean emailValidation(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@"
                + "[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    public boolean dateValidation(LocalDate date){
        LocalDate today = LocalDate.now();

        return !(Period.between(date, today).getDays() < 0);
    }
}