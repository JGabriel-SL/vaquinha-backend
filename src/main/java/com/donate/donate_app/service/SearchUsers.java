package com.donate.donate_app.service;

import com.donate.donate_app.entity.Users;
import com.donate.donate_app.mapping.UsersMapping;
import com.donate.donate_app.repository.UsersRepository;
import com.donate.donate_app.response.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchUsers {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private UsersMapping usersMapping;

    public Users SearchUsersById(Long id){
        return usersRepository.findById(id).orElseThrow();
    }

    public List<UsersResponse> searchAllUsers(){
        List<Users> users = usersRepository.findAll();
        List<UsersResponse> response = new ArrayList<>();

        users.forEach(u -> {
            response.add(usersMapping.UsersToResponse(u));
        });

        return response;
    }
}
