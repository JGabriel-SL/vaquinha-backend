package com.donate.donate_app.controller;

import com.donate.donate_app.DTO.LoginDTO;
import com.donate.donate_app.entity.Users;
import com.donate.donate_app.response.UsersResponse;
import com.donate.donate_app.service.CreateUsers;
import com.donate.donate_app.service.Firebase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    Firebase firebase;

    @Autowired
    CreateUsers createUsers;

    @PostMapping
    public UsersResponse createUsers(@RequestBody LoginDTO data){
        Users users = firebase.createFirebaseUsers(data.getName(), data.getEmail(),data.getPassword());
        return createUsers.createUsers(users);
    }
}
