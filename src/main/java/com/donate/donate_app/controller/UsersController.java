package com.donate.donate_app.controller;

import com.donate.donate_app.DTO.LoginDTO;
import com.donate.donate_app.entity.Users;
import com.donate.donate_app.response.UsersResponse;
import com.donate.donate_app.service.CreateUsers;
import com.donate.donate_app.service.Firebase;
import com.donate.donate_app.service.SearchUsers;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private Firebase firebase;

    @Autowired
    private CreateUsers createUsers;

    @Autowired
    private SearchUsers searchUsers;

    @PostMapping
    public UsersResponse createUsers(@RequestBody LoginDTO data){
        Users users = firebase.createFirebaseUsers(data.getName(), data.getEmail(),data.getPassword());
        System.out.println(users);
        return createUsers.createUsers(users);
    }

    @GetMapping
    public List<UsersResponse> getUsers(@RequestHeader String authorization) throws FirebaseAuthException {
        firebase.verifyFirebaseToken(authorization);
        return searchUsers.searchAllUsers();
    }
}
