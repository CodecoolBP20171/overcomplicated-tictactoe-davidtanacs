package com.codecool.enterprise.overcomplicated.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String userName = "Player 1";

    private List<Integer> moves = new ArrayList<>();

    public List<Integer> getMoves() {
        return moves;
    }

    public void addMove(int move) {
        this.moves.add(move);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
