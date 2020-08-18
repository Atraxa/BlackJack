package com.company;

import com.company.CardInterface;
import com.company.TableInterface;

import java.util.ArrayList;

public interface CharacterInterface {
    CardInterface hit(TableInterface tableAtWhichCharacterIsHitting);
    void stand(TableInterface tableAtWhichCustomerIsDoublingDown);
    String getName();

}
