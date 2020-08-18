package com.company;

import static com.company.CardType.*;
import static com.company.Hand.*;
import static org.junit.jupiter.api.Assertions.*;

class TestToCheckBestHandValue {

    @org.junit.jupiter.api.Test
    void returnBestScore() {
        HandInterface handToTest = new Hand();
        handToTest.drawCard(TWO_OF_CLUBS);
        handToTest.drawCard(ACE_OF_CLUBS);
        handToTest.drawCard(ACE_OF_DIAMONDS);
        handToTest.drawCard(TWO_OF_HEARTS);

        HandInterface handToTest2 = new Hand();
        handToTest2.drawCard(JACK_OF_CLUBS);
        handToTest2.drawCard(JACK_OF_DIAMONDS);
        handToTest2.drawCard(QUEEN_OF_SPADES);



        assertEquals(16,handToTest.returnBestScore());
        if(handToTest.returnBestScore().equals(16)){
            System.out.println("Test1 Success");
        };
        assertEquals(-1,handToTest2.returnBestScore());
        System.out.println("Test2 Success");

        assertTrue(handToTest.getHandBustedState());
        if(!handToTest.getHandBustedState()){
            System.out.println("Test 3 Success");
        }

        assertTrue(handToTest.getHandBustedState());


    }

}