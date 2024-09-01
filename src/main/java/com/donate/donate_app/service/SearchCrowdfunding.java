package com.donate.donate_app.service;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.entity.Users;
import com.donate.donate_app.repository.CrowdfundingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchCrowdfunding {

    @Autowired
    CrowdfundingRepository crowdfundingRepository;

    public Crowdfunding SearchCrowdfundingById(Long id){
        Crowdfunding response = crowdfundingRepository.findById(id).orElseThrow();
        return response;
    }

    public List<Crowdfunding> SearchCrowdfundingByUser(Users users){
        List<Crowdfunding> response = crowdfundingRepository.findByUsersId(users);
        return response;
    }

}
