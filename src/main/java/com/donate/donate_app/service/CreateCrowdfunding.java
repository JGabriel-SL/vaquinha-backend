package com.donate.donate_app.service;

import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.repository.CrowdfundingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCrowdfunding {

    @Autowired
    CrowdfundingRepository crowdfundingRepository;

    public void CreateCrowdfunding(Crowdfunding data) {
        crowdfundingRepository.save(data);
    }
}
