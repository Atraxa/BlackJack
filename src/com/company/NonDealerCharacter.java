package com.company;

public class NonDealerCharacter implements NonDealerCharacterInterface{
    int userWallet = 100;
    String playerName;
    int playerId;
    static int playerIdGeneratorValue=0;
    {       playerIdGeneratorValue++;
            playerId=playerIdGeneratorValue;
    }

    NonDealerCharacter(){
        setName("Player");
    }

    NonDealerCharacter(int customUserWallet,String customName){
        userWallet=customUserWallet;
        setName(customName);
    }

    @Override
    public void placeBet(int betValue, TableInterface tableAtWhichCharacterIsPlacingABet) {
        tableAtWhichCharacterIsPlacingABet.getHandForCharacter(this).addToBet(betValue);
        this.userWallet-=betValue;
    }

    @Override
    public void awardWinnings(TableInterface targetTable) {
        userWallet+=2*targetTable.getHandForCharacter(this).getBet();
        targetTable.getHandForCharacter(this).clearBet();
    }

    @Override
    public int getWalletValue() {
        return userWallet;
    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public void setName(String nameToChangeTo) {
        playerName=nameToChangeTo+"_"+playerId;
    }

    @Override
    public CardInterface hit(TableInterface tableAtWhichCharacterIsHitting) {
        CardInterface itemToAddToHand = tableAtWhichCharacterIsHitting.getDeckForTable().drawTopCard();
        tableAtWhichCharacterIsHitting.getHandForCharacter(this).getCards().add(itemToAddToHand);
        return itemToAddToHand;
    }

    @Override
    public CardInterface doubleDown(TableInterface targetTable) {
        placeBet(targetTable.getHandForCharacter(this).getBet(),targetTable);
        return hit(targetTable);
    }

    @Override
    public void stand(TableInterface tableAtWhichCustomerIsDoublingDown) {

    }
}
