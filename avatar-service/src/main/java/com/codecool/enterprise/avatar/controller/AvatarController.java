package main.java.com.codecool.enterprise.avatar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class AvatarController {

    Random random = new Random();

    @GetMapping(value = "/avatar")
    public String newAvatar(){
        int id = random.nextInt(1000);
        return "https://robohash.org/" + id;
    }
}
