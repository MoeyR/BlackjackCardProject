package ca.sheridancollege.project;

import java.util.ArrayList;

public class PlayBJGame extends Game {

    public PlayBJGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Welcome to play Blackjack Card Game!");
        
        //BJGame has a deckOfCards of 52 cards
        GroupOfCards deckOfCards = new GroupOfCards(52); //4 suits x 13 values = 52 cards
        int i=0;
        for( BJCard.Suit suits : BJCard.Suit.values() ) //suits - spade 
        {
            for(BJCard.Rank ranks: BJCard.Rank.values()) //ranks  1
            {
                deckOfCards.addCards(new BJCard(suits, ranks)); //spade,1,deckOfCards[1]=spade,2
                i++;
            }
        }
        // all 52 cards
//        for(BJCard c : deckOfCards.getCards()){
//            System.out.println(c.getSuit()+ " " + c.getRank());
//        }
        
        deckOfCards.shuffle();
        //generate two random cards for player and dear
        
        // Only 1 dealer
        BJDealer dealer = BJDealer.getInstance("MrDealer"); 
        GroupOfCards dealerHand = new GroupOfCards(2); 
        
        // player_1
        BJPlayer player_1 = new BJPlayer("player_1");
        GroupOfCards playerHand = new GroupOfCards(2); 
        
        System.out.printf("Here are your cards on hand player_1: ");
    }
    
    
    @Override
    public void declareWinner() {
        System.out.print("To be overriden..");
    }
    
}