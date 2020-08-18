package com.company;

public interface NonDealerCharacterInterface extends CharacterInterface {

    CardInterface doubleDown(TableInterface tableAtWhichCustomerIsDoublingDown);
    void placeBet(int betValue, TableInterface tableAtWhichPlayerIsPlacingBet);
    void awardWinnings(TableInterface targetTableInterface);
    int getWalletValue();
    void setName(String nameToChangeTo);

}
