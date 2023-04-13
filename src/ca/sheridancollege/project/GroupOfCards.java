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
    private int size; //the size of the grouping
    
    public GroupOfCards() {
        bjCards = new ArrayList<BJCard>();
    }
    public GroupOfCards(int size) {
        this.size = size;
        bjCards = new ArrayList<BJCard>();
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
    
    public void shuffle() {
        Collections.shuffle(bjCards);
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<BJCard> getCards() {
        return bjCards;
    }
    
    public BJCard getCardFromGroup(int index) {
        return bjCards.get(index);
    }

    public void addCard(BJCard cards){
        bjCards.add(cards);
    }
    
    public void removeCard(int index){
        bjCards.remove(index);
    }
    
    //generate a deck of 52 cards
    public void getDeckOfCard(){
        int i=0;
        for( BJCard.Suit suits : BJCard.Suit.values() ) //suits - spade 
        {
            for(BJCard.Rank ranks: BJCard.Rank.values()) //ranks  1
            {
                bjCards.add(new BJCard(suits, ranks)); //spade,1,deckOfCards[1]=spade,2
                i++;
            }
        }
    }
    
    public void drawTwoCards(GroupOfCards deck){
        deck.shuffle();
        int num = (int)(Math.random()* (deck.getSize()));      // 0 - 51, total 52
        bjCards.add(deck.getCardFromGroup(num)); // add 1 card to hand 
        deck.removeCard(num);                    // remove it from deckOfCards
        int numNew = (int)(Math.random()* (deck.getSize()-1));
        bjCards.add(deck.getCardFromGroup(numNew)); 
    }
    
    public void drawOneCard(GroupOfCards deck){
        deck.shuffle();
        int num = (int)(Math.random()* deck.getSize());      
        bjCards.add(deck.getCardFromGroup(num)); 
    }    
    
    public int cardValue(){
        int sum = 0;
        int ace = 0;
        
        for(BJCard card : bjCards){
            switch(card.getRank()){
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
                        sum += 10;
                        break;
                case JACK:
                        sum += 10;
                        break;
                case QUEEN:    
                        sum += 10;
                        break;            
                case KING:    
                        sum += 10;
                        break;
                case ACE: 
                        ace += 1;
                        break;
                }//end switch
        }//end for loop
            
            for(int i = 0; i < ace; i++){
                if(sum > 10){
                    sum += 1;
                }else{
                    sum += 11;
                }
            }
            return sum;    
    }
    
    public String toString(){
        String listCards = "";
        for(BJCard card: bjCards){
            listCards += "\n" + card.toString();
        }
        return listCards;
    }
    
}//end class
