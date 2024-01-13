package com.example.userService.service;

import com.example.userService.repository.UserRepository;
import com.example.userService.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

@Service
public class userService{

    private UserRepository repo;

    public userService(UserRepository repo){
        this.repo = repo;
    }

    public List<User> listAll(){
        return repo.findAll();
    }

    public User get(Long id){
        return repo.findById(id).get();
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

    private boolean dateValidation(LocalDate date){
        LocalDate today = LocalDate.now();

        return !(Period.between(date, today).getDays() < 0);
    }
}