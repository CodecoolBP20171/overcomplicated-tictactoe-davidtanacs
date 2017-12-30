package com.codecool.enterprise.overcomplicated.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TictactoeGame {

    String state = "---------";


    public String getState() {
        return state;
    }

    public boolean setState(String move, int index) {
        if (this.getState().charAt(index) != '-') {
            return false;
        }
        String newState = "";
        for (int i = 0; i < this.state.length(); i++) {
            if (i == index) {
                newState += move;
            } else {
                newState += this.state.charAt(i);
            }
        }
        this.state = newState;
        return true;
    }

    public boolean isWin(char player) {
        //check three horizontal winning situation
        if (this.getState().charAt(0) == player && this.getState().charAt(1) == player && this.getState().charAt(2) == player ||
                this.getState().charAt(3) == player && this.getState().charAt(4) == player && this.getState().charAt(5) == player ||
                this.getState().charAt(6) == player && this.getState().charAt(7) == player && this.getState().charAt(8) == player ||
                //check three vertical winning situation
                this.getState().charAt(0) == player && this.getState().charAt(3) == player && this.getState().charAt(6) == player ||
                this.getState().charAt(1) == player && this.getState().charAt(4) == player && this.getState().charAt(7) == player ||
                this.getState().charAt(2) == player && this.getState().charAt(5) == player && this.getState().charAt(8) == player ||
                //check two diagonal winning situation
                this.getState().charAt(0) == player && this.getState().charAt(4) == player && this.getState().charAt(8) == player ||
                this.getState().charAt(2) == player && this.getState().charAt(4) == player && this.getState().charAt(6) == player) {
            return true;
        }
        return false;
    }

    public boolean isTie(){
        if (!this.getState().contains("-")){
            if (!isWin('X') && !isWin('O')){
                return true;
            }
        }
        return false;
    }
}
