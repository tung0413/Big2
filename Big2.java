/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evonne
 */
public class Big2 {

    public static void main(String[] args) {
        // create player     
        Player p1 = new Player("  ONE", 1);
        Player p2 = new Player("  TWO", 2);
        Player p3 = new Player("THREE", 3);
        Player p4 = new Player(" FOUR", 4);   
        
        //create new game
        CardGame game=new CardGame();   
        
        //player join game
        game.player.add(p1);
        game.player.add(p2);
        game.player.add(p3);
        game.player.add(p4);
        
        //game start
        game.startGame();
        
        /*
        // create a new deck
        Deck deck = new Deck();
        
        //show deck
        System.out.println("Create a new deck:");
        System.out.println(deck.toString() + "\n");

        // shuffle
        System.out.println("Show the deck after shuffle:");
        deck.shuffle();
        //show deck after shuffle
        System.out.println(deck.toString() + "\n");

        // deal the card
        deck.deal(p1, p2, p3, p4);
        */
        
        // show everyone's hand                         
        System.out.println("\n");
        Hand hand = new Hand();
        System.out.println(p1.toString());
        hand.findAll(p1.playerHand);
        System.out.println(p2.toString());
        hand.findAll(p2.playerHand);
        System.out.println(p3.toString());
        hand.findAll(p3.playerHand);
        System.out.println(p4.toString());
        hand.findAll(p4.playerHand);
    
    }
}
