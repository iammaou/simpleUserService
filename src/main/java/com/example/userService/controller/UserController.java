package com.example.userService.controller;

import com.example.userService.service.userService;
import com.example.userService.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
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
    public String saveUser(@RequestBody User User) {
        if(apiLookup(User.getPostal()).header == "200"){
            User.setCity(apiLookup(User.getPostal()).city);
            User.setState(apiLookup(User.getPostal()).state);
            
            serv.save(User);
        }
        return (HttpURLConnection) externalLookup.openConnection().setRequestMethod("GET").reason;
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        serv.delete(id);
    }

    InputStream apiLookup(int postal){
        String url =  "https://us-zipcode.api.smarty.com/lookup?"+
        "auth-id=YOUR+AUTH-ID+HERE&"+
        "auth-token=YOUR+AUTH-TOKEN+HERE&"+
        "zipcode=" + toString(postal);
            
        return new URL(url.openConnection().getInputStream());
    }
}