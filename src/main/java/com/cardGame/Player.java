package com.cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private Integer hp;
    private Integer mana;
    private Integer currentMana;
    private List<Card> deck = new ArrayList<>();
    private List<Card> cardsInHand = new ArrayList<>();

    //private static int[] manaCards = {0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8};

    public Player() {
    }

    public Player(Integer hp, Integer mana, int[] manaCards) {
        this.hp = hp;
        this.mana = mana;
        this.currentMana = mana;
        this.deck = initilizeDeck(manaCards);
        initilizeDeck(manaCards);
    }

    private List<Card> initilizeDeck(int[] manaCards) {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < manaCards.length; i++) {
            deck.add(new Card(manaCards[i]));
        }
        Collections.shuffle(deck);

        return deck;
    }

    public void resetMana() {
        currentMana = mana;
    }


    public void drawCards(int count) {
        List<Card> returnCards = new ArrayList<>();
        for (int i = 0; i < count && deck.size() - count >= 0; i++) {
            returnCards.add(deck.get(0));
            deck.remove(0);
        }

        this.cardsInHand.addAll(returnCards);
    }

    public Card drawACard() {
        if(deck.size()==0){
            setHp(getHp()-1);
        } else {
            Card card = deck.remove(0);
            if (cardsInHand.size() < 5) {
                cardsInHand.add(card);
            }
            return card;
        }

        return null;
    }


    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public Integer getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(Integer currentMana) {
        this.currentMana = currentMana;
    }
}
