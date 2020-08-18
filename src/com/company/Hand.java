package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Hand implements HandInterface {

    ArrayList<CardInterface> cardsInHand = new ArrayList<CardInterface>();
    int currentBetValue;

    @Override
    public boolean getHandBustedState() {
        return getLowestHandValue()>21;
    }

    @Override
    public int getLowestHandValue(){
        int lowestSumOfCardValues=0;
        for(CardInterface cardValue : cardsInHand){
            lowestSumOfCardValues+=cardValue.getLowestCardValue();
        }
        return lowestSumOfCardValues;
    }

    @Override
    public int getHandSize() {
        return cardsInHand.size();
    }

    @Override
    public ArrayList<CardInterface> getCards() {
        return cardsInHand;
    }

    @Override
    public int getBet() {
        return currentBetValue;
    }

    @Override
    public void addToBet(int valueToAddToBet) {
        currentBetValue+=valueToAddToBet;
    }

    @Override
    public void setBet(int valueToSetBetTo) {
        currentBetValue=valueToSetBetTo;
    }


    @Override
    public void clearBet() {
        currentBetValue=0;
    }

    @Override
    public Integer returnBestScore() {
        Stack<CardInterface> cardsToSum = new Stack<CardInterface>();
        cardsToSum.addAll(cardsInHand);
        ArrayList<Integer> arrayListOfPointValuesOfPaths = recursivePathChecker(cardsToSum);
        int highestLegalValue = -1;
        for (int pathValue : arrayListOfPointValuesOfPaths) {
            if (pathValue>highestLegalValue && pathValue<=21) {
                highestLegalValue=pathValue;
            }
        }
        return highestLegalValue;
    }

    @Override
    public void drawCard(CardInterface cardToAddToHand) {cardsInHand.add(cardToAddToHand);}

    private ArrayList<Integer> recursivePathChecker(Stack<CardInterface> handRemaining){
        Stack<CardInterface> cloneHand = (Stack<CardInterface>) handRemaining.clone();
        if(cloneHand.isEmpty()){
            ArrayList<Integer> initialArrayList = new ArrayList<Integer>();
            initialArrayList.add(0);
            return  initialArrayList;
        };
        CardInterface remainingCard = cloneHand.pop();
        ArrayList<Integer> pathValues = new ArrayList<>();

        ArrayList<Integer> arrayListReturnedFromRecursion = recursivePathChecker(cloneHand);
        for(int i = 0; i<arrayListReturnedFromRecursion.size();i++){
            arrayListReturnedFromRecursion.set(i,arrayListReturnedFromRecursion.get(i)+remainingCard.getPrimaryCardValue());
        }
        pathValues.addAll(arrayListReturnedFromRecursion);

        if(remainingCard.getAlternateCardValue()!=null){
            ArrayList<Integer> arrayListReturnedFromAlternateRecursion = recursivePathChecker(cloneHand);
            for(int i = 0; i<arrayListReturnedFromAlternateRecursion.size();i++){
                arrayListReturnedFromAlternateRecursion.set(i,arrayListReturnedFromAlternateRecursion.get(i)+remainingCard.getAlternateCardValue());
            }
            pathValues.addAll(arrayListReturnedFromAlternateRecursion);
        }
        return pathValues;
    }
}
