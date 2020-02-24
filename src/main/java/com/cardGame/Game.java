package com.cardGame;

public class Game {
    private Player player1;
    private Player player2;
    private int currentTurn = 1;

    public Game(Player player1, Player player2) {
        this.setPlayer1(player1);
        this.setPlayer2(player2);
    }

    public void drawCard() {
        if (currentTurn == -1) {
            player1.drawACard();
        } else {
            player2.drawACard();
        }
    }

    public Player getActivePlayer() {
        if (currentTurn == -1) {
            return player1;
        } else {
            return player2;
        }
    }

    public void damageOtherPlayer(int cardNo) {
        Integer dmg = 0;
        if (currentTurn == -1) {
            dmg = player1.getCardsInHand().get(cardNo-1).getDamage();
            player2.setHp(player2.getHp()-dmg);
            player1.getCardsInHand().remove(cardNo-1);
            player1.setCurrentMana(player1.getCurrentMana()-dmg);
        } else {
            dmg = player2.getCardsInHand().get(cardNo-1).getDamage();
            player1.setHp(player1.getHp()-dmg);
            player2.getCardsInHand().remove(cardNo-1);
            player2.setCurrentMana(player2.getCurrentMana()-dmg);
        }
    }

    public void addManaToCurrentPlayer(){
        if (currentTurn == -1) {
            if(player1.getMana()<10){
                player1.setMana(player1.getMana()+1);
            }
            player1.resetMana();
        } else {
            if(player2.getMana()<10){
                player2.setMana(player2.getMana()+1);
            }
            player2.resetMana();
        }
    }

    public Boolean isGameOver(){
        if(player1.getHp()<=0 || player2.getHp()<=0){
            return true;
        } else {
            return false;
        }
    }

    public void endTurn(){
        setCurrentTurn(getCurrentTurn()*-1);
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Game() {
    }
}
