package com.codecool.enterprise.funfact.controller;


import com.codecool.enterprise.funfact.model.FunFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;

@RestController
public class FunFactController {

    @Autowired
    FunFact funFact;

    @GetMapping(value = "/funfact")
    public String newFunFact(){
        HashMap<Object, Object> body = new HashMap<Object, Object>();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<HashMap> entity = new HttpEntity<HashMap>(body, headers);
        HttpEntity<HashMap> response = restTemplate.exchange("https://api.chucknorris.io/jokes/random", HttpMethod.GET,entity,HashMap.class);

        funFact.setValue(response.getBody().get("value").toString());
        return funFact.getValue();
    }
}
