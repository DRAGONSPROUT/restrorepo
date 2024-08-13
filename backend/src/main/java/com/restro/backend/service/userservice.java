package com.restro.backend.service;

import com.restro.backend.model.user;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public interface userservice {

    public List<user> getUser();

    public String saveUser(@RequestBody user user);
}
