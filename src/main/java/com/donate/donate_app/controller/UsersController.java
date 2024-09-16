package com.donate.donate_app.controller;

import com.donate.donate_app.DTO.UsersDTO;
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

    @PostMapping
    public void createUsers(@RequestBody UsersDTO data){

        firebase.createFirebaseUsers(data.getEmail(),data.getPassword());

    }
}
