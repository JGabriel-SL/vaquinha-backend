package com.donate.donate_app.mapping;

import com.donate.donate_app.DTO.CrowdfundingDTO;
import com.donate.donate_app.DTO.RequestAIDTO;
import org.springframework.stereotype.Component;

@Component
public class ArtificialintelligenceMapping {

    public RequestAIDTO crowdfundingToRequestAIDTO(CrowdfundingDTO data) {
        return new RequestAIDTO(data.getTitle(), data.getDescription(), data.getGoal_amount().toString());
    }

}
