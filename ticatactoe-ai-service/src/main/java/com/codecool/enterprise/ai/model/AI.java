package com.codecool.enterprise.ai.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class AI {


    Random random = new Random();

    private List<Integer> allMoves = new ArrayList<>();


    public List<Integer> getAllMoves() {
        return allMoves;
    }

    public void addAllMoves(Integer moves) {
        this.allMoves.add(moves);
    }

    public int makeNextMove(String state){
        int rand = random.nextInt(8);
        while (state.charAt(rand) != '-'){
            rand = random.nextInt(8);
        }
        this.addAllMoves(rand);
        return rand;
    }
}
