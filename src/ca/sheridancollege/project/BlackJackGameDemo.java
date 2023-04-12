package ca.sheridancollege.project;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 * This class +++ Insert class description here +++ 
 *
 * @author Moyu Ran
 */
public class BlackJackGameDemo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        PlayBJGame round_1 = new PlayBJGame("Round_1");
        round_1.play();
        
        //BJGame has a deckOfCards of 52 cards
        GroupOfCards deckOfCards = new GroupOfCards(52); 
        deckOfCards.getDeckOfCard(); // A deck of all Blackjack Cards: 4 suits x 13 values = 52 cards
        //System.out.println(deckOfCards.getSize());
        
        deckOfCards.shuffle();
        // all 52 cards
//        for(BJCard c : deckOfCards.getCards()){
//            System.out.println(c.getSuit()+ " " + c.getRank());
//        }
        
        // player_1
        System.out.print("Please enter your name: ");
        String player_1_name = input.nextLine();
        BJPlayer player_1 = new BJPlayer(player_1_name);
        //draw two cards for player
        player_1.getPlayerHand().drawTwoCards(deckOfCards); //GroupOfCards playerHand = new GroupOfCards();
        System.out.printf("Here are your cards on hand, %s: %s %n", player_1.toString(), player_1.getPlayerHand().toString());
        System.out.printf("Your cards value is totaled: %s%n", player_1.getPlayerHand().cardValue() );
    
        // Only 1 dealer
        BJDealer dealer = BJDealer.getInstance("MrDealer"); 
        //draw two cards for dealer
        dealer.getDealerHand().drawTwoCards(deckOfCards); //GroupOfCards dealerHand = new GroupOfCards();
        System.out.println("One of dealer's cards is: " + dealer.getDealerHand().getCardFromGroup(0).toString());
        
        System.out.println(" ***************************** ");
        
        // player can choose to hit or stand
        boolean answer = false;
        do{
            System.out.print("Would you like to 'HIT' or 'STAND'? ");
            String playerAnswer = input.nextLine();
            
            if(playerAnswer.matches("hit") || playerAnswer.matches("HIT") || playerAnswer.matches("Hit")){
                //draw one card for player
                player_1.getPlayerHand().drawOneCard(deckOfCards);
                System.out.printf("Here is your new card %s: %s %n", 
                        player_1.toString(), player_1.getPlayerHand().getCardFromGroup(2).toString());
                if(player_1.getPlayerHand().cardValue() > 21){
                    System.out.println("Sorry, you lost! Try next time!");
                    break;
                }else{
                    System.out.printf("Your total cards value is now: %s%n", player_1.getPlayerHand().cardValue() );
                }
                
                answer = false;
            }else if(playerAnswer.matches("stand")|| playerAnswer.matches("STAND") || playerAnswer.matches("Stand")){
                break;
            }else{
                System.out.print("Please choose to 'HIT' or 'STAND': ");
                answer = true;
            }
        }while(answer);
        
    }//end of main
}//end of BlackJackGameDemo class
