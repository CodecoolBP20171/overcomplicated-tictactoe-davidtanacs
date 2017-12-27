package com.codecool.enterprise.funfact.controller;


import com.codecool.enterprise.funfact.model.FunFact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunFactController {

    @RequestMapping(value = "/funfact")
    public FunFact newFunFact(){
        return new FunFact();
    }
}
