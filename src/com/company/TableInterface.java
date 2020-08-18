package com.company;

import java.util.ArrayList;
import java.util.Set;

public interface TableInterface {

    void playerJoin(NonDealerCharacterInterface characterToJoinTable);
    void playerLeave(NonDealerCharacterInterface characterToLeaveTable);
    DeckInterface getDeckForTable();
    DealerInterface getDealerForTable();
    HandInterface getHandForCharacter(CharacterInterface characterWhosHandToReturn);
    Set<CharacterInterface> getPlayerListIncludingDealer();
    ArrayList<NonDealerCharacterInterface> getNonDealerCharacterList();

}
