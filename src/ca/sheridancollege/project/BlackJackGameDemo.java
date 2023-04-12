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
        GroupOfCards deckOfCards = new GroupOfCards(); 
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
        System.out.printf("Your cards value is totaled: %s%n", player_1.getPlayerHand().cardValue());
        
        //player lost if card value's over 21
        if(player_1.getPlayerHand().cardValue() > 21){
                    System.out.println("Sorry, you lost! Try next time!");
                    System.exit(0);
            }
        //player hit 21, player wins, ie. ACE + TEN
        if(player_1.getPlayerHand().cardValue() == 21){
                    System.out.println(" ********************************** ");
                    System.out.println("Congratulations! You WIN !!!");
                    System.exit(0);
            }
        
        // Only 1 dealer
        BJDealer dealer = BJDealer.getInstance("MrDealer"); 
        //draw one card for dealer
        dealer.getDealerHand().drawOneCard(deckOfCards); //GroupOfCards dealerHand = new GroupOfCards();
       
        System.out.println("Dealer's first cards is: " + dealer.getDealerHand().getCardFromGroup(0).toString());

        System.out.println(" ***************************** ");
        
        // player can choose to hit or stand
        boolean answer = false;
        
        
        do{
            System.out.print("Would you like to 'HIT' or 'STAND'? ");
            String playerAnswer = input.nextLine();
            
            if(playerAnswer.matches("hit") || playerAnswer.matches("HIT") || playerAnswer.matches("Hit")){
                    //player ask to draw cards
                    player_1.getPlayerHand().drawOneCard(deckOfCards);
                    int lastPlayerHand = player_1.getPlayerHand().getCards().size()-1;
                    System.out.printf("Here is your NEW CARD, %s: %s %n", 
                    player_1.toString(), 
                    player_1.getPlayerHand().getCardFromGroup(lastPlayerHand).toString());
                    //debug
//                    System.out.println("Your cards are: " + player_1.getPlayerHand());
                    System.out.println(" ********************************** ");
                 
                //while dealer's card value < 17, draw one card for dealer
                while(dealer.getDealerHand().cardValue() < 17){
                    dealer.getDealerHand().drawOneCard(deckOfCards);
                    int lastDealerHand = dealer.getDealerHand().getCards().size()-1;
                    System.out.println("Dealer draw: " + dealer.getDealerHand().getCardFromGroup(lastDealerHand).toString());
                }
                System.out.println("Dealer cards value: " + dealer.getDealerHand().cardValue());
                
                
                if(player_1.getPlayerHand().cardValue() < 21 && dealer.getDealerHand().cardValue() < 21){
                    System.out.printf("Your total cards value is now: %s%n", player_1.getPlayerHand().cardValue() );
                    answer = true;
                    
                }else if(player_1.getPlayerHand().cardValue() < 21 && dealer.getDealerHand().cardValue() > 21){
                    //Dealer bust, show dealer's cards
                    System.out.println("Dealer Cards: " + dealer.getDealerHand().toString());
                    System.out.println("Dealer Value: " + dealer.getDealerHand().cardValue());
                    System.out.println(" ********************************** ");
                    System.out.println("Dealer bust. You WIN !!!");
                    break;
                }else if(player_1.getPlayerHand().cardValue() == 21 && dealer.getDealerHand().cardValue() != 21){
                    System.out.println(" ********************************** ");
                    System.out.println("Congratulations! You WIN !!!");
                    break;
                }else{
                    System.out.println(" ********************************** ");
                    System.out.println("Sorry, you lost! Try next time!");
                    //debug
                    System.out.println("Your cards value: " + player_1.getPlayerHand().cardValue());
                    System.out.println("Your cards are: " + player_1.getPlayerHand());
//                    System.out.println("Dealer cards value: " + dealer.getDealerHand().cardValue());
//                    System.out.println("Dealer cards are: " + dealer.getDealerHand());
                    break;
                }
                
                //player choose "stand", dealer's turn.
            }else if(playerAnswer.matches("stand")|| playerAnswer.matches("STAND") || playerAnswer.matches("Stand")){
                
                //dealer draw cards
                while(dealer.getDealerHand().cardValue() < 17){
                    dealer.getDealerHand().drawOneCard(deckOfCards);
                    int lastDealerHand = dealer.getDealerHand().getCards().size()-1;
                    System.out.println("Dealer draw: " + dealer.getDealerHand().getCardFromGroup(lastDealerHand).toString());
                }
                System.out.println("Dealer cards value: " + dealer.getDealerHand().cardValue());
                
                if(player_1.getPlayerHand().cardValue() < dealer.getDealerHand().cardValue()){
                    System.out.println(" ********************************** ");
                    System.out.println("Dealer bits you!");
                    System.out.println("Dealer cards value: " + dealer.getDealerHand().cardValue());
                    System.out.println("Your cards value: " + player_1.getPlayerHand().cardValue());
                }else if(player_1.getPlayerHand().cardValue() > dealer.getDealerHand().cardValue()){
                    System.out.println(" ********************************** ");
                    System.out.println("Congratulations! You WIN !!!");
                    System.out.println("Dealer cards value: " + dealer.getDealerHand().cardValue());
                    System.exit(0);
                }else{
                    System.out.println(" ********************************** ");
                    System.out.println("Tie! Play again!");
                    System.out.println("Dealer cards value: " + dealer.getDealerHand().cardValue());
                }
                break;
            }else{
                System.out.print("Please choose to 'HIT' or 'STAND': "); 
                answer = true;
            }
        }while(answer);
        
        
    }//end of main
}//end of BlackJackGameDemo class
