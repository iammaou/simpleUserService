package com.example.userService.service;

import com.example.userService.repository.UserRepository;
import com.example.userService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
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

    public User save(User user){
        if(dateValidation(user.getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())){
            repo.save(user);
            return user;
        } else throw new IllegalArgumentException();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public boolean dateValidation(LocalDate date){
        LocalDate today = LocalDate.now();

        return !(Period.between(date, today).getDays() < 0);
    }
}