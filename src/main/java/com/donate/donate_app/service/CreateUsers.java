package com.donate.donate_app.service;

import com.donate.donate_app.entity.Users;
import com.donate.donate_app.mapping.UsersMapping;
import com.donate.donate_app.repository.UsersRepository;
import com.donate.donate_app.response.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUsers {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersMapping usersMapping;

    public UsersResponse createUsers(Users data){
        Users users = usersRepository.save(data);
        return usersMapping.UsersToResponse(users);
    }
}
