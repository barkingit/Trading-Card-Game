package com.cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Deck() {
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
