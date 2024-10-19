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
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import com.donate.donate_app.DTO.RequestAIDTO;

import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

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
                .onStatus(HttpStatusCode::isError, clientResponse -> {
                    return Mono.error(new RuntimeException(("Error: Failed to connection to AI")));
                })
                .bodyToMono(AILoginResponse.class)
                .onErrorResume(throwable -> {
                    switch (throwable) {
                        case WebClientResponseException webClientResponseException ->
                                System.err.println("Error HTTP Request: " + webClientResponseException.getStatusCode());
                        case TimeoutException timeoutException ->
                                System.err.println("Error: TimeOut");
                        case ConnectException connectException -> System.err.println("Error: Connection refused");
                        case null, default -> System.err.println("Unknown Error: " + throwable.getMessage());
                    }
                    return Mono.justOrEmpty(null);
                })
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

        if (token != null) {
            return validateCrowdfunding(requestAIDTO, token);
        } else {
            return noConnectionIAResponse();
        }
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

    public AIValidationResponse noConnectionIAResponse() {
        return new AIValidationResponse("Error : No Connection to AI", "N");
    }

    public void createAnalisys(AIValidationResponse response, Long crowdfunding_id, Long user_id) {
        if ("N".equals(response.getValidate())) {
            AnalisysDTO analisysDTO = new AnalisysDTO(crowdfunding_id, user_id, response.getMotive(), "WAITING");
            Analisys analisys = analisysMapping.AnalisysDTOToAnalisys(analisysDTO);
            analisysService.CreateAnalisys(analisys);
        }
    }
}
