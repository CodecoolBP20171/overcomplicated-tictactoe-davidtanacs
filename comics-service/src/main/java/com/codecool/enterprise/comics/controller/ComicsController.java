package com.codecool.enterprise.comics.controller;

import com.codecool.enterprise.comics.model.Comics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Random;

@RestController
public class ComicsController {

    @Autowired
    Comics comics;

    Random random = new Random();

    @GetMapping(value = "/comics")
    public String newComics(){
        int id = random.nextInt(1929 + 1);
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> comicsMap = restTemplate.getForObject("https://xkcd.com/{id}/info.0.json", HashMap.class, id);
        comics.setImage(comicsMap.get("img"));
        return comics.getImage();
    }

}
