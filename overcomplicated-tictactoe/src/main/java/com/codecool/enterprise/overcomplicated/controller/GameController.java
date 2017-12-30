package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
@SessionAttributes({"player", "game", "avatar_uri"})
public class GameController {

    @ModelAttribute("player")
    public Player getPlayer() {
        return Player.getInstance();
    }

    @Autowired
    TictactoeGame tictactoeGame;

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        RestTemplate restTemplate = new RestTemplate();
        String avatar = restTemplate.getForObject("http://localhost:60003/avatar", String.class);
        return avatar;
    }


    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) {
        model.addAttribute("funfact", getNewFunFact());
        model.addAttribute("comic_uri", getNewComics());
        model.addAttribute("state", tictactoeGame.getState());
        String winner = "";
        if (tictactoeGame.isWin('X')){
            model.addAttribute("isWin", "X");
        } else if(tictactoeGame.isWin('O')){
            model.addAttribute("isWin", "O");
        } else if (tictactoeGame.isTie()){
            model.addAttribute("isWin", "-");
        }
        System.out.println(model);
        return "game";
    }

    public Object getNewFunFact(){
        RestTemplate restTemplate = new RestTemplate();
        String funFact = restTemplate.getForObject("http://localhost:60000/funfact", String.class);
        return funFact;
    }

    public Object getNewComics(){
        RestTemplate restTemplate = new RestTemplate();
        String comics = restTemplate.getForObject("http://localhost:60002/comics", String.class);
        return comics;
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
            if (tictactoeGame.setState("O", move)){
                if (tictactoeGame.getState().contains("-")){
                    int AIMove = getAIMove();
                    tictactoeGame.setState("X", AIMove);
                }
            }
        return "redirect:/game";
    }

    @GetMapping(value = "/all-move")
    @ResponseBody
    public String sendMove(){
        return tictactoeGame.getState();
    }

    public int getAIMove(){
        RestTemplate restTemplate = new RestTemplate();
        Integer newAIMove = restTemplate.getForObject("http://localhost:60001/ai", Integer.class);
        return newAIMove;
    }

}
