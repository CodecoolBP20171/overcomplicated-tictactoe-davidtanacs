package com.codecool.enterprise.comics.model;


import org.springframework.stereotype.Component;

@Component
public class Comics {

    String image;

    public Comics() {
    }

    public Comics(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
