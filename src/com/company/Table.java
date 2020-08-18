package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Table implements TableInterface {

    ArrayList<NonDealerCharacterInterface> currentPlayerList = new ArrayList<>();
    private DeckInterface deckForTable = new Deck();
    private DealerInterface tableDealer = new Dealer();
    HashMap<CharacterInterface,HandInterface> handsOnTable = new HashMap<CharacterInterface,HandInterface>();
    {handsOnTable.put(tableDealer,new Hand());}

    @Override
    public void playerJoin(NonDealerCharacterInterface characterToJoinTable) {
        currentPlayerList.add(characterToJoinTable);
        handsOnTable.put(characterToJoinTable,new Hand());
    }

    @Override
    public void playerLeave(NonDealerCharacterInterface characterToLeaveTable) {
        currentPlayerList.remove(characterToLeaveTable);
        handsOnTable.remove(characterToLeaveTable);
    }

    @Override
    public DeckInterface getDeckForTable() {
        return deckForTable;
    }

    @Override
    public DealerInterface getDealerForTable() {
        return tableDealer;
    }

    @Override
    public HandInterface getHandForCharacter(CharacterInterface characterWhosHandToReturn) {
        return handsOnTable.get(characterWhosHandToReturn);
    }

    @Override
    public Set<CharacterInterface> getPlayerListIncludingDealer() {
        return handsOnTable.keySet();
    }

    @Override
    public ArrayList<NonDealerCharacterInterface> getNonDealerCharacterList() {
        return (ArrayList<NonDealerCharacterInterface>) currentPlayerList.clone();
    }
}
