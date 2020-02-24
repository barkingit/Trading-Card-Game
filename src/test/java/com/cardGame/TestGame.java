package com.cardGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGame {

    @Test
    public void playersStartingWithThreeCardsTest() {
        GameCreator gameCreator = new GameCreator();
        Game testGame = gameCreator.initilizeGame();

        assertEquals(3, testGame.getPlayer1().getCardsInHand().size(), "At the start of the game each player should have 3 cards in hand");
        assertEquals(3, testGame.getPlayer2().getCardsInHand().size(), "At the start of the game each player should have 3 cards in hand");
    }

    @Test
    public void drawaCardTest() {
        GameCreator gameCreator = new GameCreator();
        Game testGame = gameCreator.initilizeGame();

        testGame.getPlayer1().drawACard();

        assertEquals(4, testGame.getPlayer1().getCardsInHand().size(), "After drawing a card, player 1 should have 4 cards");
    }

}
