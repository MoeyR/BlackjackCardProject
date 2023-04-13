package ca.sheridancollege.project;

public class BJDealer extends Player {
    //declare single object - dealer
    private static BJDealer dealer = null;
    private GroupOfCards dealerHand; // cards on dealer's hand
    private int dealerScore;
    
    //private constructor: restrict the other class to create ONLY ONE dealer
    private BJDealer(String name) {
        super(name);
        dealerHand = new GroupOfCards();
    }
    
    //method to provide one dealer to other classes
    public static BJDealer getInstance(String name){
        if(dealer == null){
            dealer = new BJDealer(name); //one dealer is created, and return it
        }
        return dealer; //if an dealer already created,then return the dealer created ealier.
    }
    
    /**
     * @return the dealerHand
     */
    public GroupOfCards getDealerHand() {
        return dealerHand;
    }

    /**
     * @param dealerHand the dealerHand to set
     */
    public void setDealerHand(GroupOfCards dealerHand) {
        this.dealerHand = dealerHand;
    }
    
    /**
     * @return the dealerScore
     */
    public int getDealerScore() {
        return dealerScore;
    }

    /**
     * @param dealerScore the dealerScore to set
     */
    public void setDealerScore(int dealerScore) {
        this.dealerScore = dealerScore;
    }
    
    @Override
    public void play() {
        System.out.print("Blackjack dealer: " + super.getName()); 
    }
    
    
}//end of BJDealer 