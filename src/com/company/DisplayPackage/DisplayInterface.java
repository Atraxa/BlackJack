package com.company.DisplayPackage;

import com.company.CharacterInterface;
import com.company.NonDealerCharacterInterface;
import com.company.TableInterface;

import java.util.ArrayList;

public interface DisplayInterface {
    void displayTableState(TableInterface targetTable, NonDealerCharacterInterface playerOne);
    ArrayList displayNonDealerCharacterOptions(NonDealerCharacterInterface primaryPlayer, TableInterface tableForWhichWeAreConfirmingOptions);
    void displayFinalTableState(TableInterface targetTable, NonDealerCharacterInterface playerOne);
    boolean executeUserChoice(NonDealerCharacterInterface characterWhosDecisionsToExecute, TableInterface tableAtWhichUserIsExecutingTheirChoice);
    void assignWinnings(TableInterface tableToAssignWinningFor);
    void displayHand(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne);
    void displayHands(TableInterface targetTable, NonDealerCharacterInterface playerOne);
    void displayNonDealerHands(TableInterface targetTable, NonDealerCharacterInterface playerOne);
    void displayDealerHand(TableInterface targetTable, NonDealerCharacterInterface primaryPlayer);

    void displayWinnerHands(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne);
    void displayWinnings(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne);
    void displayLoserHands(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne);
    void displayLosings(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne);
    void displayResultForNonDealerCharacter(TableInterface targetTable, CharacterInterface targetCharacter, NonDealerCharacterInterface playerOne);


    void displayUserOption(TableInterface targetTable, NonDealerCharacterInterface playerOne);
    void respondToUserRequest(int userChoice);
    void requestUserBet(TableInterface targetTable, NonDealerCharacterInterface playerOne);
    void respondToUserBet(int userBetAmount);
    void displayCurrentBetForUser(TableInterface targetTable, NonDealerCharacterInterface targetNonDealerCharacter);

    void askUserForBet(NonDealerCharacterInterface inputNonDealerPlayer, TableInterface tableAtWhichPlayerIsSat);


}
