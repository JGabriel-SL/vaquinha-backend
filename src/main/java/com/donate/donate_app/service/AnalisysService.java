package com.donate.donate_app.service;

import com.donate.donate_app.enums.StatusAnalisys;
import com.donate.donate_app.mapping.AnalisysMapping;
import com.donate.donate_app.repository.AnalisysRepository;
import com.donate.donate_app.response.AnalisysResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.donate.donate_app.entity.Analisys;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalisysService {

    @Autowired
    AnalisysRepository analisysRepository;

    @Autowired
    AnalisysMapping analisysMapping;

    public void CreateAnalisys(Analisys data){
        analisysRepository.save(data);
    }

    public List<AnalisysResponse> GetAnalisysWaiting(){
        return analisysMapping.analisysResponseList(analisysRepository.findAnalisysByStatus(StatusAnalisys.WAITING));
    }

    public AnalisysResponse UpdateAnalisys(Analisys data){
        Analisys old_data = analisysRepository.findById(data.getId()).orElse(null);
        if (old_data != null){
            old_data.setStatus(data.getStatus());
            analisysRepository.save(old_data);
        } else {
            System.out.println("Usuario não encontrado!");
        }
        return analisysMapping.AnalisysResponse(old_data);
    }
}
