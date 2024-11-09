package com.donate.donate_app.service;
import com.donate.donate_app.entity.Analisys;
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

    public CrowdfundingResponse updateCrowdfunding(Crowdfunding data) {
        Crowdfunding old_data = crowdfundingRepository.findById(data.getId()).orElse(null);
        if (old_data != null) {
            old_data.setStatus(data.getStatus());
            return crowdfundingMapping.CrowdfundingToResponse(crowdfundingRepository.save(data));
        } else {
            System.out.println("Crowdfunding not found");
            return null;
        }
    }
}
