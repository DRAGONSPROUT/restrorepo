package com.restro.backend.controller;

import com.restro.backend.dto.userdto;
import com.restro.backend.model.user;
import com.restro.backend.service.userserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    userserviceimpl service;

    @GetMapping("")
    public ResponseEntity<List<user>> getUser(){
        List<user> li = new ArrayList<>();
        li = service.getUser();
        return new ResponseEntity<>(li,HttpStatus.OK);
    }

    @PostMapping("signup")
    public ResponseEntity<> saveUser(@RequestBody user user)
    {
        String message = service.saveUser(user);
        if(message.equals("USER CREATED"))
            return new ResponseEntity<>(message,HttpStatus.CREATED);
        else
            return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

}
