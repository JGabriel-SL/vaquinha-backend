package com.donate.donate_app.service;

import com.donate.donate_app.entity.Users;
import com.donate.donate_app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchUsers {

    @Autowired
    UsersRepository usersRepository;

    public Users SearchUsersById(Long id){
        Users response = usersRepository.findById(id).orElseThrow();
        return response;
    }
}
