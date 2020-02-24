package com.cardGame;

import java.util.List;

public class GameCreator {

    public Game initilizeGame(){
        int[] manaCards = {0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8};// Eğer ileride oyunculara farklı deste vermek istersek diye

        Player player1 = new Player(30,0,manaCards);
        Player player2 = new Player(30,0,manaCards);

        Game game = new Game(player1,player2);

        game.getPlayer1().drawCards(3);
        game.getPlayer2().drawCards(3);

        game.setCurrentTurn(-1);

        return game;

    }
}
