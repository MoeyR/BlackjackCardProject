/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {
    
    //The group of cards, stored in an ArrayList
    private ArrayList<BJCard> bjCards;
    private int size;//the size of the grouping
    
    public GroupOfCards() {
        bjCards = new ArrayList<BJCard>();
    }
    public GroupOfCards(int size) {
        this.size = size;
        bjCards = new ArrayList<BJCard>();
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<BJCard> getCards() {
        return bjCards;
    }

    public void shuffle() {
        Collections.shuffle(bjCards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public void addCards(BJCard cards){
        getCards().add(cards);
    }
    
    public int cardValue(){
        int sum = 0;
        int ace = 0;
        
        for(BJCard card : bjCards)
            switch(card.getRank()){
                case ACE: 
                        ace += 1;
                        break;
                case TWO: 
                        sum += 2;
                        break;
                case THREE: 
                        sum += 3;
                        break;
                case FOUR: 
                        sum += 4;
                        break;
                case FIVE: 
                        sum += 5;
                        break;    
                case SIX: 
                        sum += 6;
                        break;    
                case SEVEN: 
                        sum += 7;
                        break;    
                case EIGHT: 
                        sum += 8;
                        break;    
                case NINE: 
                        sum += 9;
                        break;    
                case TEN:
                case JACK:
                case KING:    
                        sum += 10;
                        break;    
                }
            for(int i = 0; i < ace; i++){
                    if(sum > 10){
                        sum += 1;
                    }else{
                        sum += 11;
                    }        
                    
            }
            return sum;    
    }
    
}//end class
