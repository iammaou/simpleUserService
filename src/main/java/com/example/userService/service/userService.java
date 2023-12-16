package com.example.userService.service;

import com.example.userService.repository.UserRepository;
import com.example.userService.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService{

    @Autowired
    private UserRepository repo;

    public List<User> listAll(){
        return repo.findAll();
    }

    public Object get(Long id){
        return repo.findById(id);
    }

    public void save(User usr){
        repo.save(usr);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

}