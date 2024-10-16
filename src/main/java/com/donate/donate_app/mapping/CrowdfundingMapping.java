package com.donate.donate_app.mapping;

import com.donate.donate_app.DTO.CrowdfundingDTO;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.entity.Users;
import com.donate.donate_app.repository.UsersRepository;
import com.donate.donate_app.response.CrowdfundingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CrowdfundingMapping {

    @Autowired
    UsersRepository usersRepository;

    public Crowdfunding DtoToCrowdfunding(CrowdfundingDTO data){
        Users users = usersRepository.findById(data.getUsers_id()).orElseThrow();
        Integer goal_amount = 0;
        if (data.getGoal_amount()!=null){
            goal_amount = data.getGoal_amount();
        }
        return new Crowdfunding(data.getDescription(), users, goal_amount, data.getTitle());
    }

    public CrowdfundingResponse CrowdfundingToResponse(Crowdfunding data){
        CrowdfundingResponse crowdfundingResponse = new CrowdfundingResponse();
        crowdfundingResponse.setCreated_at(data.getCreated_at());
        crowdfundingResponse.setDescription(data.getDescription());
        crowdfundingResponse.setGoal_amount(data.getGoal_amount());
        crowdfundingResponse.setId(data.getId());
        crowdfundingResponse.setCurrent_amount(data.getCurrent_amount());
        crowdfundingResponse.setStatus(data.getStatus());
        return crowdfundingResponse;
    }

    public List<CrowdfundingResponse> ListCrowdfundingToResponse(List<Crowdfunding> data){
        List<CrowdfundingResponse> ListCrowdfundingResponse = data.stream().map(this::CrowdfundingToResponse).toList();
        return ListCrowdfundingResponse;
    }
}
