package com.donate.donate_app.controller;

import com.donate.donate_app.DTO.CrowdfundingDTO;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.mapping.CrowdfundingMapping;
import com.donate.donate_app.response.CrowdfundingResponse;
import com.donate.donate_app.service.CreateCrowdfunding;
import com.donate.donate_app.service.Firebase;
import com.donate.donate_app.service.SearchCrowdfunding;
import com.donate.donate_app.service.SearchUsers;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "api/crowdfunding")
public class CrowdfundingController {

    @Autowired
    CrowdfundingMapping crowdfundingMapping;

    @Autowired
    CreateCrowdfunding createCrowdfunding;

    @Autowired
    SearchCrowdfunding searchCrowdfunding;

    @Autowired
    SearchUsers searchUsers;

    @Autowired
    Firebase firebase;

    @PostMapping
    public void createCrowdfunding(@RequestBody CrowdfundingDTO data, @RequestHeader String authorization) throws FirebaseAuthException {
        firebase.verifyFirebaseToken(authorization);
        Crowdfunding crowdfunding = crowdfundingMapping.DtoToCrowdfunding(data);
        createCrowdfunding.CreateCrowdfunding(crowdfunding);
    }

    @GetMapping
    public List<CrowdfundingResponse> searchCrowdfundingAll(){
        List<CrowdfundingResponse> response = crowdfundingMapping.ListCrowdfundingToResponse(searchCrowdfunding.SearchCrowdfundingAll());
        return response;
    }

    @GetMapping("/byid")
    public CrowdfundingResponse searchCrowdfundingById(@RequestParam Long id){
        CrowdfundingResponse response = crowdfundingMapping.CrowdfundingToResponse(searchCrowdfunding.SearchCrowdfundingById(id));
        return response;
    }

    @GetMapping("/byuser")
    public List<CrowdfundingResponse> searchCrowdfundingByUser(@RequestParam Long id, @RequestHeader String authorization) throws FirebaseAuthException{
        firebase.verifyFirebaseToken(authorization);
        System.out.println(searchUsers.SearchUsersById(id));
        List<Crowdfunding> listCrowdfunding = searchCrowdfunding.SearchCrowdfundingByUser(searchUsers.SearchUsersById(id));
        List<CrowdfundingResponse> responses = crowdfundingMapping.ListCrowdfundingToResponse(listCrowdfunding);
        return responses;
    }
}
