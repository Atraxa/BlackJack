package com.company;

public enum CardType implements CardInterface{
    TWO_OF_HEARTS(2),	THREE_OF_HEARTS(3),	FOUR_OF_HEARTS(4),	FIVE_OF_HEARTS(5),	SIX_OF_HEARTS(6),	SEVEN_OF_HEARTS(7),	EIGHT_OF_HEARTS(8),	NINE_OF_HEARTS(9),	TEN_OF_HEARTS(10),	JACK_OF_HEARTS(10),	QUEEN_OF_HEARTS(10),	KING_OF_HEARTS(10),	ACE_OF_HEARTS(11,1),
    TWO_OF_DIAMONDS(2),	THREE_OF_DIAMONDS(3),	FOUR_OF_DIAMONDS(4),	FIVE_OF_DIAMONDS(5),	SIX_OF_DIAMONDS(6),	SEVEN_OF_DIAMONDS(7),	EIGHT_OF_DIAMONDS(8),	NINE_OF_DIAMONDS(9),	TEN_OF_DIAMONDS(10),	JACK_OF_DIAMONDS(10),	QUEEN_OF_DIAMONDS(10),	KING_OF_DIAMONDS(10),	ACE_OF_DIAMONDS(11,1),
    TWO_OF_CLUBS(2),	THREE_OF_CLUBS(3),	FOUR_OF_CLUBS(4),	FIVE_OF_CLUBS(5),	SIX_OF_CLUBS(6),	SEVEN_OF_CLUBS(7),	EIGHT_OF_CLUBS(8),	NINE_OF_CLUBS(9),	TEN_OF_CLUBS(10),	JACK_OF_CLUBS(10),	QUEEN_OF_CLUBS(10),	KING_OF_CLUBS(10),	ACE_OF_CLUBS(11,1),
    TWO_OF_SPADES(2),	THREE_OF_SPADES(3),	FOUR_OF_SPADES(4),	FIVE_OF_SPADES(5),	SIX_OF_SPADES(6),	SEVEN_OF_SPADES(7),	EIGHT_OF_SPADES(8),	NINE_OF_SPADES(9),	TEN_OF_SPADES(10),	JACK_OF_SPADES(10),	QUEEN_OF_SPADES(10),	KING_OF_SPADES(10),	ACE_OF_SPADES(11,1);

    private final int primaryCardValue;
    private Integer alternateCardValue = null;

    CardType(int primaryValue) {
        primaryCardValue = primaryValue;
    }
    
    CardType(int primaryValue, int alternateValue){
        primaryCardValue = primaryValue;
        alternateCardValue = alternateValue;
    }

    public int getLowestCardValue() {
        if(alternateCardValue==null) return primaryCardValue;
        return Math.min(primaryCardValue, alternateCardValue);
    }

    public Integer getAlternateCardValue(){
        return alternateCardValue;
    }

    public int getPrimaryCardValue(){
        return primaryCardValue;
    }
}
