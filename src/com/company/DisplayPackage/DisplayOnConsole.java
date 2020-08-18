package com.company.DisplayPackage;

import com.company.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DisplayOnConsole implements DisplayInterface {
    static Scanner staticScannerObject = new Scanner(System.in);
    @Override
    public void displayTableState(TableInterface targetTable, NonDealerCharacterInterface primaryPlayer) {
            for (NonDealerCharacterInterface eachNonDealerCharacter : targetTable.getNonDealerCharacterList()){
                HandInterface eachPlayersHand = targetTable.getHandForCharacter(eachNonDealerCharacter);
                if (eachNonDealerCharacter.equals(primaryPlayer)) {
                    System.out.println("You have the following cards in your hand:");
                } else {
                    System.out.println(eachNonDealerCharacter.getName() + " has the following cards in hand:");
                }
                for (CardInterface cardInPlayersHand : eachPlayersHand.getCards()) {
                    System.out.println("CardName: " + cardInPlayersHand.toString());
                }
                if (eachNonDealerCharacter.equals(primaryPlayer)) {
                    System.out.println("Your current bet is " + eachPlayersHand.getBet() + " and you have a balance of " + primaryPlayer.getWalletValue() + " remaining");
                }
            }
            System.out.print(System.lineSeparator());
            System.out.println("The Dealer's first card is " + targetTable.getHandForCharacter(targetTable.getDealerForTable()).getCards().get(0));
        }

    @Override
    public ArrayList displayNonDealerCharacterOptions(NonDealerCharacterInterface primaryPlayer, TableInterface tableForWhichWeAreConfirmingOptions) {
        HandInterface playersHand = tableForWhichWeAreConfirmingOptions.getHandForCharacter(primaryPlayer);
        if (playersHand.getHandBustedState()) {
            System.out.println("You have lost - no more options this round");
            return new ArrayList(Arrays.asList(new Integer[]{}));
        } else if (primaryPlayer.getWalletValue() >= playersHand.getBet()) {
            System.out.println("You can Stand (enter 1), Hit (enter 2) or Double Down (enter 3)");
            return new ArrayList(Arrays.asList(new Integer[]{1, 2, 3}));
        } else {
            System.out.println("You can Stand (enter 1) or Hit (enter 2)");
            return new ArrayList(Arrays.asList(new Integer[]{1, 2}));
        }
    }

    @Override
    public void displayFinalTableState(TableInterface targetTable, NonDealerCharacterInterface playerOne) {
        for (CharacterInterface eachCharacter : targetTable.getPlayerListIncludingDealer()) {
            HandInterface eachPlayersHand = targetTable.getHandForCharacter(eachCharacter);
            if (eachCharacter.equals(playerOne)) {
                System.out.println("You have the following cards in your hand:");
            } else {
                System.out.println(eachCharacter.getName() + " has the following cards in hand:");
            }
            ;
            for (CardInterface cardInPlayersHand : eachPlayersHand.getCards()) {
                System.out.println("CardName: " + cardInPlayersHand.toString());
            }
            if (eachCharacter.equals(playerOne)) {
                System.out.println("Your current bet is " + eachPlayersHand.getBet() + " and you have a balance of " + playerOne.getWalletValue() + " remaining");
            }
            System.out.print(System.lineSeparator());
        }
    }

    @Override
    public boolean executeUserChoice(NonDealerCharacterInterface characterWhosDecisionsToExecute, TableInterface tableAtWhichUserIsExecutingTheirChoice) {
        ArrayList<Integer> userOptions = displayNonDealerCharacterOptions(characterWhosDecisionsToExecute, tableAtWhichUserIsExecutingTheirChoice);
        if (userOptions.isEmpty()) return false;
        int userInput = staticScannerObject.nextInt();
        while (!userOptions.contains(userInput)) {
            System.out.println("You did not enter a valid code!");
            userInput = staticScannerObject.nextInt();
        }
        switch (userInput) {
            case 1:
                System.out.println("You have finalised your hand");
                break;
            case 2:
                CardInterface drawnCard = characterWhosDecisionsToExecute.hit(tableAtWhichUserIsExecutingTheirChoice);
                System.out.println("You drew a " + drawnCard.toString());
                System.out.println(characterWhosDecisionsToExecute.getName() + " has the following cards in hand:");
                for (CardInterface cardInPlayersHand : tableAtWhichUserIsExecutingTheirChoice.getHandForCharacter(characterWhosDecisionsToExecute).getCards()) {
                    System.out.println("CardName: " + cardInPlayersHand.toString());
                }
                break;
            case 3:
                CardInterface finalCard = characterWhosDecisionsToExecute.doubleDown(tableAtWhichUserIsExecutingTheirChoice);
                System.out.println("You drew a " + finalCard.toString());
                System.out.println(characterWhosDecisionsToExecute.getName() + " has the following cards in hand:");
                for (CardInterface cardInPlayersHand : tableAtWhichUserIsExecutingTheirChoice.getHandForCharacter(characterWhosDecisionsToExecute).getCards()) {
                    System.out.println("CardName: " + cardInPlayersHand.toString());
                }
                break;
        }
        return userInput == 2;
    }

    @Override
    public void assignWinnings(TableInterface tableToAssignWinningFor) {
        System.out.println("Round End - Results as follows:");
        ArrayList<NonDealerCharacterInterface> listOfWinners = Main.determineWinner(tableToAssignWinningFor);
        for(NonDealerCharacterInterface winningCharacter : listOfWinners) {
            winningCharacter.awardWinnings(tableToAssignWinningFor);
        }
        for(NonDealerCharacterInterface playerAtTable :tableToAssignWinningFor.getNonDealerCharacterList()){
            tableToAssignWinningFor.getHandForCharacter(playerAtTable).clearBet();
            System.out.println(playerAtTable.getName() + " has a balance of " + playerAtTable.getWalletValue() + " remaining.");
        }
    }

    @Override
    public void displayHand(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void displayHands(TableInterface targetTable, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void displayNonDealerHands(TableInterface targetTable, NonDealerCharacterInterface playerOne) {

    }

    @Override
        public void displayDealerHand(TableInterface targetTable, NonDealerCharacterInterface primaryPlayer) {
    }

    @Override
    public void displayWinnerHands(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void displayWinnings(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void displayLoserHands(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void displayLosings(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void displayResultForNonDealerCharacter(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void displayUserOption(TableInterface targetTable, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void respondToUserRequest(int userChoice) {

    }

    @Override
    public void requestUserBet(TableInterface targetTable, NonDealerCharacterInterface playerOne) {

    }

    @Override
    public void respondToUserBet(int userBetAmount) {

    }

    @Override
    public void displayCurrentBetForUser(TableInterface targetTable, NonDealerCharacterInterface targetNonDealerCharacter) {

    }

    @Override
    public void askUserForBet(NonDealerCharacterInterface inputNonDealerPlayer, TableInterface tableAtWhichPlayerIsSat) {
        int userBet;

        System.out.println("How much would you like to bet?");
        userBet = staticScannerObject.nextInt();
        if (userBet > 0 && userBet <= inputNonDealerPlayer.getWalletValue()) {
            inputNonDealerPlayer.placeBet(userBet, tableAtWhichPlayerIsSat);
            return;
        }
        do {
            System.out.println("You either bet more money that you have in your account, or you a negative value or zero. How much would you like to bet?");
            userBet = staticScannerObject.nextInt();
        } while (userBet <= 0 || userBet > inputNonDealerPlayer.getWalletValue());
        inputNonDealerPlayer.placeBet(userBet, tableAtWhichPlayerIsSat);
    }

}
