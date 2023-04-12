package ca.sheridancollege.project;

public class BJDealer extends Player {
    //declare single object - dealer
    private static BJDealer dealer = null;
    
    //private constructor: restrict the other class to create ONLY ONE dealer
    private BJDealer(String name) {
        super(name);
    }
    
    //method to provide one dealer to other classes
    public static BJDealer getInstance(String name){
        if(dealer == null){
            dealer = new BJDealer(name); //one dealer is created, and return it
        }
        return dealer; //if an dealer already created,then return the dealer created ealier.
    }
    
    @Override
    public void play() {
        System.out.print("Blackjack dealer: " + super.getName()); 
    }
    
    
}