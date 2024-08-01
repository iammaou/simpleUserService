package com.example.userService.controller;

import com.example.userService.model.Postal;
import com.example.userService.service.PostalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class PostalController {

    private PostalService postServ;

    @GetMapping("/postal")
    public List<Postal> getAll(){
        return postServ.getAll();
    }

    @GetMapping("/postal/{id}")
    public Postal getPostal(@PathVariable Long id){
        return postServ.getPostal(id);
    }
}
