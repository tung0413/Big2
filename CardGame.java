
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evonne
 */
public class CardGame {
    Deck deck;
    ArrayList<Player> player = new ArrayList();

    public CardGame() {
        deck=new Deck();
    }  
    
    public void startGame(){
        deck.shuffle();
        deck.deal(player.get(0), player.get(1), player.get(2), player.get(3));
    }  
}
