package com.company;

import java.util.ArrayList;

public interface HandInterface {

    boolean getHandBustedState();
    int getLowestHandValue();
    int getHandSize();
    ArrayList<CardInterface> getCards();
    int getBet();
    void addToBet(int valueToAddToBet);
    void setBet(int valueToSetBetTo);
    void clearBet();
    Integer returnBestScore();
    void drawCard(CardInterface cardToAddToHand);



}
