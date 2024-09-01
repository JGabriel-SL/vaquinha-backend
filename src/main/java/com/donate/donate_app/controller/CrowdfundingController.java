package com.donate.donate_app.controller;
import com.donate.donate_app.DTO.CrowdfundingDTO;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.mapping.CrowdfundingMapping;
import com.donate.donate_app.response.CrowdfundingResponse;
import com.donate.donate_app.service.CreateCrowdfunding;
import com.donate.donate_app.service.SearchCrowdfunding;
import com.donate.donate_app.service.SearchUsers;
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

    @PostMapping
    public void createCrowdfunding(@RequestBody CrowdfundingDTO data){
        Crowdfunding crowdfunding = crowdfundingMapping.DtoToCrowdfunding(data);
        createCrowdfunding.CreateCrowdfunding(crowdfunding);
    }
    @GetMapping
    public CrowdfundingResponse searchCrowdfundingById(@RequestParam Long id){
        CrowdfundingResponse response = crowdfundingMapping.CrowdfundingToResponse(searchCrowdfunding.SearchCrowdfundingById(id));
        return response;
    }

    @GetMapping("/byuser")
    public List<CrowdfundingResponse> searchCrowdfundingByUser(@RequestParam Long id){
        System.out.println(searchUsers.SearchUsersById(id));
        List<Crowdfunding> listCrowdfunding = searchCrowdfunding.SearchCrowdfundingByUser(searchUsers.SearchUsersById(id));
        List<CrowdfundingResponse> responses = crowdfundingMapping.ListCrowdfundingToResponse(listCrowdfunding);
        return responses;
    }
}
