package ca.sheridancollege.project;

public class BJPlayer extends Player {

    private GroupOfCards playerHand; // cards on player's hand
    private int playerScore;
    //private int playerCardCount;  // num of cards on player's hand
    
    public BJPlayer(String name) {
        super(name);
        playerHand = new GroupOfCards();
    }
    
    
    @Override
    public void play() {
        System.out.print("Blackjack player: " + super.getName());
    }

    /**
     * @return the playerHand
     */
    public GroupOfCards getPlayerHand() {
        return playerHand;
    }

    /**
     * @param playerHand the playerHand to set
     */
    public void setPlayerHand(GroupOfCards playerHand) {
        this.playerHand = playerHand;
    }
    
    /**
     * @return the playerScore
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * @param playerScore the playerScore to set
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    
    /**
     * @return the playerCardCount
     */
//    public int getPlayerCardCount() {
//        return playerCardCount;
//    }

    /**
     * @param playerCardCount the playerCardCount to set
     */
//    public void setPlayerCardCount(int playerCardCount) {
//        this.playerCardCount = playerCardCount;
//    }
    
    public void playerHandAddCard(BJCard card){
        playerHand.addCard(card);
        //playerScore += Integer.parseInt(card.getRank());
    }
    
    public String toString(){
        return super.getName();
    }
            
}// end of BJPlayer