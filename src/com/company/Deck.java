package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck implements DeckInterface {

    ArrayList<CardInterface> cardsInDeck = new ArrayList<CardInterface>();
    CardType cardsToP;

    Deck(){
        cardsInDeck.addAll(Arrays.asList(CardType.values()));
        shuffleDeck();
    }


    @Override
    public void shuffleDeck() {
        Collections.shuffle(cardsInDeck);
    }

    @Override
    public int remainingCardCount() {
        return cardsInDeck.size();
    }

    @Override
    public CardInterface drawTopCard() {
        return cardsInDeck.remove(0);
    }


}
