package com.codecool.enterprise.overcomplicated.model;

import java.util.ArrayList;
import java.util.List;


public class Player {

    private static Player instance = null;

    private Player(){}

    private String userName = "Player 1";

    private List<Integer> moves = new ArrayList<>();

    public static Player getInstance() {
        if(instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public List<Integer> getMoves() {
        return moves;
    }

    public boolean addMove(int move) {
        if (!this.getMoves().contains(move)){
            this.moves.add(move);
            return true;
        }
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
