package com.donate.donate_app.service;

import com.donate.donate_app.DTO.AnalisysDTO;
import com.donate.donate_app.DTO.CrowdfundingDTO;
import com.donate.donate_app.DTO.RequestLoginAIDTO;
import com.donate.donate_app.entity.Analisys;
import com.donate.donate_app.enums.StatusCrowdfunding;
import com.donate.donate_app.mapping.AnalisysMapping;
import com.donate.donate_app.mapping.ArtificialintelligenceMapping;
import com.donate.donate_app.response.AILoginResponse;
import com.donate.donate_app.response.AIValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.donate.donate_app.DTO.RequestAIDTO;

@Service
public class ArtificialIntelligenceService {

    @Autowired
    private WebClient webClient;

    @Autowired
    AnalisysMapping analisysMapping;

    @Autowired
    AnalisysService analisysService;

    @Autowired
    ArtificialintelligenceMapping artificialintelligenceMapping;

    public RequestLoginAIDTO getRequestLoginAIDTO() {
        return new RequestLoginAIDTO("gab123", "gab123");
    }

    public String login() {
        RequestLoginAIDTO requestLoginAIDTO = getRequestLoginAIDTO();

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

    public AIValidationResponse doAIRequest(CrowdfundingDTO data) {
        RequestAIDTO requestAIDTO = createAIRequest(data);
        String token = login();

        return validateCrowdfunding(requestAIDTO, token);
    }

    public RequestAIDTO createAIRequest(CrowdfundingDTO data) {
        return artificialintelligenceMapping.crowdfundingToRequestAIDTO(data);
    }

    public StatusCrowdfunding getCrowdfundingStatus(AIValidationResponse response) {
        if (response == null || response.getValidate() == null || "N".equals(response.getValidate())) {
            return StatusCrowdfunding.WAITING;
        }
        return StatusCrowdfunding.OPEN;
    }

    public void createAnalisys(AIValidationResponse response, Long crowdfunding_id, Long user_id) {
        if ("N".equals(response.getValidate())) {
            AnalisysDTO analisysDTO = new AnalisysDTO(crowdfunding_id, user_id, response.getMotive(), "WAITING");
            Analisys analisys = analisysMapping.AnalisysDTOToAnalisys(analisysDTO);
            analisysService.CreateAnalisys(analisys);
        }
    }
}
