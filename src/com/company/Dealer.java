package com.company;


public class Dealer implements DealerInterface{
    @Override
    public void dealHands(TableInterface targetTable) {
        for(CharacterInterface characterAtTable : targetTable.getPlayerListIncludingDealer()){
            HandInterface usersHand = targetTable.getHandForCharacter(characterAtTable);
            usersHand.getCards().clear();
            usersHand.getCards().add(targetTable.getDeckForTable().drawTopCard());
            usersHand.getCards().add(targetTable.getDeckForTable().drawTopCard());
        }
    }

    @Override
    public CardInterface hit(TableInterface tableAtWhichCharacterIsHitting) {
        CardInterface topCard = tableAtWhichCharacterIsHitting.getDeckForTable().drawTopCard();
        tableAtWhichCharacterIsHitting.getHandForCharacter(this).getCards().add(topCard);
        return topCard;
    }

    @Override
    public void stand(TableInterface tableAtWhichCustomerIsDoublingDown) {

    }

    @Override
    public String getName() {
        return "Dealer";
    }
}
