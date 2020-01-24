package com.av.accounting.controller;

import com.av.accounting.entity.User;
import com.av.accounting.repositories.UserRepository;
import com.av.accounting.validation.UserValidate;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path = "/user")
public class UserC {
    UserRepository userRepository;
    UserValidate userValidate;

    @Autowired
    public UserC(UserRepository userRepository, UserValidate userValidate) {
        this.userRepository = userRepository;
        this.userValidate = userValidate;
    }


    @GetMapping(path = "/findAll")
    public List<User> getAllAccount() {
        return userRepository.findAll();
    }


    @GetMapping(path = "/addUser")
    public String addUser(@RequestParam("name") String name, @RequestParam("phone") String phone) {
        User user = new User(null, name, phone, null, null);
        String userValidation = userValidate.userValidation(user);
        Gson gson = new Gson();
        gson.toJson(user);
        if (userValidation.equals("Successfully")) {
            userRepository.save(user);
            return gson.toJson(user);

        } else {
            return userValidation;
        }
    }

    @PostMapping(path = "/addUser/body")
    public User addUserByBody(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

}


