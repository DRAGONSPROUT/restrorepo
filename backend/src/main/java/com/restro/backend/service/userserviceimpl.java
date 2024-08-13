package com.restro.backend.service;


import com.restro.backend.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import com.restro.backend.repository.userrepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class userserviceimpl implements userservice{

    @Autowired
    userrepo userrepo;

    @Override
    public List<user> getUser(){
        List<user> li = new ArrayList<>();
        li = userrepo.findAll();
        return li;
    }

    @Override
    public String saveUser(user user)
    {

        user us = this.userrepo.findByUsername(user.getUsername());
        System.out.print(user.getUsername());
        if( us == null) {
            this.userrepo.save(user);
            return "USER CREATED";
        }
        else
            return "USER ALREADY EXISTS";


    }

}
