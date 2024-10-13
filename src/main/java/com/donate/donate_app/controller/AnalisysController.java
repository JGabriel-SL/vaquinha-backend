package com.donate.donate_app.controller;

import com.donate.donate_app.DTO.AnalisysDTO;
import com.donate.donate_app.entity.Analisys;
import com.donate.donate_app.mapping.AnalisysMapping;
import com.donate.donate_app.response.AnalisysResponse;
import com.donate.donate_app.service.AnalisysService;
import com.donate.donate_app.service.Firebase;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/crowdfunding/analisys")
public class AnalisysController {

    @Autowired
    AnalisysService analisysService;

    @Autowired
    AnalisysMapping analisysMapping;

    @Autowired
    Firebase firebase;

    @PostMapping
    public void createAnalisys(@RequestBody AnalisysDTO data, @RequestHeader String authorization) throws FirebaseAuthException {
        firebase.verifyFirebaseToken(authorization);
        Analisys analisys = analisysMapping.AnalisysDTOToAnalisys(data);
        analisysService.CreateAnalisys(analisys);
    }

    @GetMapping
    public List<AnalisysResponse> getAllAnalisysWaiting(@RequestHeader String authorization) throws FirebaseAuthException {
        firebase.verifyFirebaseToken(authorization);
        return analisysService.GetAnalisysWaiting();
    }

    @PutMapping
    public AnalisysResponse updateAnalisys(@RequestBody AnalisysDTO data, @RequestHeader String authorization) throws FirebaseAuthException {
        firebase.verifyFirebaseToken(authorization);
        Analisys analisys = analisysMapping.AnalisysDTOToAnalisysUpdate(data);
        return analisysService.UpdateAnalisys(analisys);
    }
}
