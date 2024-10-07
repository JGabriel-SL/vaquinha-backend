package com.donate.donate_app.service;

import com.donate.donate_app.repository.AnalisysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.donate.donate_app.entity.Analisys;
import org.springframework.stereotype.Service;

@Service
public class AnalisysService {

    @Autowired
    AnalisysRepository analisysRepository;

    public void CreateAnalisys(Analisys data){
        analisysRepository.save(data);
    }
}
