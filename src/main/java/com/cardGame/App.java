package com.cardGame;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //:TODO deste bitince 1 hasar ver
        //:TODO eli boşsa veya oynayabileceği kart yoksa turu bitir
        Scanner scanner = new Scanner(System.in);
        GamePrinter gamePrinter = new GamePrinter();
        GameCreator gameCreator = new GameCreator();

        //Create game
        Game currentGame = gameCreator.initilizeGame();

        Boolean endGame = false;

        int currentTurn = -1; // -1 mavinin turu demek

        System.out.println((ColorConstants.ANSI_YELLOW + "Game has Started"));
        System.out.println((ColorConstants.ANSI_YELLOW + "GAMEPLAY"));
        System.out.println((ColorConstants.ANSI_YELLOW + "Active player on the current turn can pick a card to play by pressing card number on the deck(1 to 10)"));
        System.out.println((ColorConstants.ANSI_YELLOW + "Active player can end the turn by pressing 'e'"));
        System.out.println((ColorConstants.ANSI_YELLOW + "If there are no valid actions that can be taken turn ends"));
        System.out.println((ColorConstants.ANSI_YELLOW + "Invalid inputs are ignored"));

        // While game continues
        while (endGame.equals(false)) {
            String endTurn = "n";
            currentGame.drawCard();
            currentGame.addManaToCurrentPlayer();
            gamePrinter.printCurrentStatus(currentGame);
            gamePrinter.printCurrentTurn(currentGame.getCurrentTurn());

            // While turn lasts
            while (!endTurn.equals("e")) {
                int count = currentGame.getActivePlayer().getDeck().size();

                // Check if someone died because they took deck empty dmg and died
                if(currentGame.isGameOver()){
                    endGame=true;
                    break;
                }
                String nextAction = "";

                if (nextAction.equals("e")) {
                    break;
                } else {
                    Boolean isInvalid = true;
                    // Sayı aldıkça veya oyun bitmedikçe devam et
                    while (isInvalid) {
                        nextAction = scanner.nextLine();
                        if(nextAction.equals("e")){
                            endTurn ="e";
                            break;
                        }
                        Integer number;
                        try {
                            number = Integer.decode(nextAction);
                        } catch (NumberFormatException f) {
                            isInvalid = false;
                            continue;
                        }
                        Integer currentMana= currentGame.getActivePlayer().getCurrentMana();
                        if(number>0 && number<=currentGame.getActivePlayer().getCardsInHand().size()
                                && currentMana >= currentGame.getActivePlayer().getCardsInHand().get(number-1).getDamage()){
                            currentGame.damageOtherPlayer(number);
                            isInvalid=false;
                            gamePrinter.printCurrentStatus(currentGame);
                            if(currentGame.isGameOver()){
                                endTurn="e";
                                endGame=true;
                                break;
                            }
                            gamePrinter.printCurrentTurn(currentGame.getCurrentTurn());
                        }

                    }

                }

            }
            currentGame.getPlayer1().resetMana();
            currentGame.getPlayer2().resetMana();
            //Turn ended
            if(currentGame.isGameOver()){
                System.out.println(ColorConstants.ANSI_PURPLE +"GAME OVER");
                break;
            }
            currentGame.endTurn();
        }


        System.out.println((ColorConstants.ANSI_BLUE + "Blue Text"));

    }


}
