package com.codecool.enterprise.funfact.model;


import org.springframework.stereotype.Component;

@Component
public class FunFact {

    private String value = "This is a funny funfact!";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
