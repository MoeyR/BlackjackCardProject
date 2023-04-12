package ca.sheridancollege.project;

public class BJCard extends Card {
    
    public enum Suit {HEARTS, DEMONDS, SPADES, CLUBS} 
    public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
    
    private Rank rank;
    private Suit suit;
    
    public BJCard(Suit suit, Rank rank){
        this.setSuit(suit);
        this.setRank(rank);
    }
    /**
     * @return the value
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * @param value the value to set
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    
    @Override
    public String toString() {
        return "Blackjack cards";
    }
	
    
}