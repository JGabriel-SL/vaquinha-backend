package com.donate.donate_app.mapping;

import com.donate.donate_app.DTO.AnalisysDTO;
import com.donate.donate_app.entity.Analisys;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.entity.Users;
import com.donate.donate_app.enums.StatusAnalisys;
import com.donate.donate_app.repository.CrowdfundingRepository;
import com.donate.donate_app.repository.UsersRepository;
import com.donate.donate_app.response.AnalisysResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnalisysMapping {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CrowdfundingRepository crowdfundingRepository;

    public Analisys AnalisysDTOToAnalisys(AnalisysDTO data) {
        Users user = usersRepository.findById(data.getUser_id()).orElseThrow();
        Crowdfunding crowdfunding = crowdfundingRepository.findById(data.getCrowdfunding_id()).orElseThrow();

        return new Analisys(crowdfunding, user, data.getRefuse_motive(), StatusAnalisys.valueOf(data.getStatus()));
    }

    public Analisys AnalisysDTOToAnalisysUpdate(AnalisysDTO data) {
        return new Analisys(data.getId(), data.getStatus());
    }

    public AnalisysResponse AnalisysResponse(Analisys data) {
        return new AnalisysResponse(data);
    }

    public List<AnalisysResponse> analisysResponseList(List<Analisys> data) {
        return data.stream().map(this::AnalisysResponse).toList();
    }

}
