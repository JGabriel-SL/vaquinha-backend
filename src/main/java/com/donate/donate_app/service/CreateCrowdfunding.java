package com.donate.donate_app.service;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.mapping.CrowdfundingMapping;
import com.donate.donate_app.repository.CrowdfundingRepository;
import com.donate.donate_app.response.CrowdfundingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCrowdfunding {

    @Autowired
    CrowdfundingRepository crowdfundingRepository;

    @Autowired
    CrowdfundingMapping crowdfundingMapping;

    public CrowdfundingResponse CreateCrowdfunding(Crowdfunding data) {
        Crowdfunding newCrowdfunding = crowdfundingRepository.save(data);
        return crowdfundingMapping.CrowdfundingToResponse(newCrowdfunding);
    }
}
