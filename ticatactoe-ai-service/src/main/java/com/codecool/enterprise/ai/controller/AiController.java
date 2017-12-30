package com.codecool.enterprise.ai.controller;


import com.codecool.enterprise.ai.model.AI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
public class AiController {

    @Autowired
    AI ai;

    @RequestMapping(value = "/ai")
    public int getAllPlayerMove(){
        RestTemplate restTemplate = new RestTemplate();
        String state = restTemplate.getForObject("http://localhost:8080/all-move", String.class);
        System.out.println(state);
        HashMap<Object, Object> newAIMove = restTemplate.getForObject("http://tttapi.herokuapp.com/api/v1/{state}/O", HashMap.class, state);
        System.out.println(newAIMove);
        return (Integer)newAIMove.get("recommendation");
    }


}
