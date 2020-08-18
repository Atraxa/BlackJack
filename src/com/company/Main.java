package com.company;

import com.company.DisplayPackage.DisplayInterface;
import com.company.DisplayPackage.DisplayOnConsole;

import javax.swing.*;
import java.util.*;

public class Main {
    public DisplayInterface OutputHandler = new DisplayOnConsole();

    public static void main(String... args) {

        Table tableNumberOne = new Table();
        NonDealerCharacter playerNumberOne = new NonDealerCharacter();
        tableNumberOne.playerJoin(playerNumberOne);
        Main myMainInstance =  new Main();
        myMainInstance.playARoundOfBlackJack(playerNumberOne,tableNumberOne);
    }

    void playARoundOfBlackJack(NonDealerCharacter playerOne, TableInterface tableOfInterest) {
        OutputHandler.askUserForBet(playerOne, tableOfInterest);
        dealStartingHandsToPlayers(tableOfInterest);
        OutputHandler.displayTableState(tableOfInterest, playerOne);
        while (OutputHandler.executeUserChoice(playerOne,tableOfInterest));
        calculateHouseMove(tableOfInterest);
        OutputHandler.displayFinalTableState(tableOfInterest,playerOne);
        OutputHandler.assignWinnings(tableOfInterest);
    }


    private void dealStartingHandsToPlayers(TableInterface targetTableInterface) {
        targetTableInterface.getDealerForTable().dealHands(targetTableInterface);
    }


    void calculateHouseMove(TableInterface targetTable) {
        while (!targetTable.getHandForCharacter(targetTable.getDealerForTable()).getHandBustedState()) {
            if (targetTable.getHandForCharacter(targetTable.getDealerForTable()).getLowestHandValue() < 16) {
                targetTable.getDealerForTable().hit(targetTable);
            } else return;
        }
    }

    public static ArrayList<NonDealerCharacterInterface> determineWinner(TableInterface targetTableInterface) {
        DealerInterface dealerForTable = targetTableInterface.getDealerForTable();
        Integer dealersBestScore = targetTableInterface.getHandForCharacter(dealerForTable).returnBestScore();
        ArrayList<NonDealerCharacterInterface> winners = new ArrayList<NonDealerCharacterInterface>();
        for (NonDealerCharacterInterface player : targetTableInterface.getNonDealerCharacterList()) {
            Integer playersBestHand = targetTableInterface.getHandForCharacter(player).returnBestScore();
            if (playersBestHand!=null && playersBestHand > dealersBestScore && playersBestHand<=21) {
                winners.add( player);
            }
        }
        return winners;
    }
}
