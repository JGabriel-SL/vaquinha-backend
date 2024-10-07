package com.donate.donate_app.mapping;

import com.donate.donate_app.DTO.AnalisysDTO;
import com.donate.donate_app.entity.Analisys;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.entity.Users;
import com.donate.donate_app.repository.AnalisysRepository;
import com.donate.donate_app.repository.CrowdfundingRepository;
import com.donate.donate_app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnalisysMapping {

    @Autowired
    AnalisysRepository analisysRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CrowdfundingRepository crowdfundingRepository;

    public Analisys AnalisysDTOToAnalisys(AnalisysDTO data) {
        Users user = usersRepository.findById(data.getUser_id()).orElseThrow();
        Crowdfunding crowdfunding = crowdfundingRepository.findById(data.getCrowdfunding_id()).orElseThrow();

        return new Analisys(crowdfunding, user, data.getRefuse_motive(), data.getStatus());
    }
}
