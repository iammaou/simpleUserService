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

    public User get(int id){
        return repo.getReferenceById(id);
    }

    public String save(User usr){
        repo.save(usr);
        return null;
    }

    public void delete(int id){
        repo.deleteById(id);
    }

}