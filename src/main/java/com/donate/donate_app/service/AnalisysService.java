package com.donate.donate_app.service;

import com.donate.donate_app.enums.StatusAnalisys;
import com.donate.donate_app.repository.AnalisysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.donate.donate_app.entity.Analisys;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalisysService {

    @Autowired
    AnalisysRepository analisysRepository;

    public void CreateAnalisys(Analisys data){
        analisysRepository.save(data);
    }

    public List<Analisys> GetAnalisysWaiting(){
        return analisysRepository.findAnalisysByStatus(StatusAnalisys.waiting);
    }

    public void UpdateAnalisys(Analisys data){
        analisysRepository.save(data);
    }
}
