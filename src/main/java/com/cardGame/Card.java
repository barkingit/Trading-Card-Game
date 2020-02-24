package com.cardGame;

public class Card {
    private Integer damage;

    public Card() {
    }

    public Card(Integer damage) {
        this.damage = damage;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
