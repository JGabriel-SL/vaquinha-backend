package com.donate.donate_app.service;

import com.donate.donate_app.DTO.RequestLoginAIDTO;
import com.donate.donate_app.enums.StatusCrowdfunding;
import com.donate.donate_app.response.AILoginResponse;
import com.donate.donate_app.response.AIValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.donate.donate_app.DTO.RequestAIDTO;

@Service
public class ArtificialIntelligenceService {

    @Autowired
    private WebClient webClient;

    public String login(RequestLoginAIDTO requestLoginAIDTO) {
        AILoginResponse obj =  webClient.post()
                .uri("/login")
                .body(Mono.just(requestLoginAIDTO), RequestLoginAIDTO.class)
                .retrieve()
                .bodyToMono(AILoginResponse.class)
                .block();

        return obj != null ? obj.getAccess_token() : null;
    }

    public AIValidationResponse validateCrowdfunding(RequestAIDTO requestAIDTO, String token) {
        return  webClient.post()
                .uri("/validate/crowdfunding")
                .body(Mono.just(requestAIDTO), RequestAIDTO.class)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(AIValidationResponse.class)
                .block();

    }

    public StatusCrowdfunding getCrowdfundingStatus(AIValidationResponse response) {
        if (response == null || response.getValidate() == null || "N".equals(response.getValidate())) {
            return StatusCrowdfunding.WAITING;
        }
        return StatusCrowdfunding.OPEN;
    }
}
