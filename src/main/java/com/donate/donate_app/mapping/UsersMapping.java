package com.donate.donate_app.mapping;

import com.donate.donate_app.entity.Users;
import com.donate.donate_app.response.UsersResponse;
import org.springframework.stereotype.Component;

@Component
public class UsersMapping {

    public UsersResponse UsersToResponse(Users data){
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setId(data.getId());
        usersResponse.setEmail(data.getEmail());
        usersResponse.setName(data.getName());
        usersResponse.setAuth_id(data.getAuth_id());
        return usersResponse;
    }
}
