package com.cardGame;

public class GamePrinter {

    public void printCurrentStatus (Game game){
        System.out.println((ColorConstants.ANSI_BLUE +"Player 1 HP: "+game.getPlayer1().getHp()+" M: "+game.getPlayer1().getCurrentMana()));
        System.out.println("Deck Count: "+game.getPlayer1().getDeck().size());
        System.out.print("CARDS:");
        for(Card card:game.getPlayer1().getCardsInHand()){
            System.out.print(card.getDamage()+" ");
        }
        System.out.println();
        System.out.println((ColorConstants.ANSI_RED +"Player 2 HP: "+game.getPlayer2().getHp()+" M: "+game.getPlayer2().getCurrentMana()));
        System.out.println("Deck Count: "+game.getPlayer2().getDeck().size());
        System.out.print("CARDS:");
        for(Card card:game.getPlayer2().getCardsInHand()){
            System.out.print(card.getDamage()+" ");
        }
        System.out.println();
    }

    public void printCurrentTurn(int turn){
        if(turn==-1){
            System.out.println((ColorConstants.ANSI_BLUE +"BLUE TURN"));
        } else {
            System.out.println((ColorConstants.ANSI_RED +"RED TURN"));
        }
    }


}
