/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evonne
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cardDeck = new ArrayList();

    //create new deck
    public Deck() {
        for (int rank = 0; rank < 13; rank++) {
            for (int suit = 0; suit < 4; suit++) {
                cardDeck.add(new Card(rank, suit));
            }
        }
    }
    
    public void shuffle() {
        Random random = new Random();
        // Swap with subsequent cards
        for (int i = 0; i < 52; i++) {
            int num = random.nextInt(52);
            Collections.swap(cardDeck, i, num);
        }
    }

    public void deal(Player p1, Player p2, Player p3, Player p4) {
        for (int i = 51; i >= 0; i = i - 4) {
            // Deal four cards at a time
            p1.playerHand.add(cardDeck.get(i));
            p2.playerHand.add(cardDeck.get(i - 1));
            p3.playerHand.add(cardDeck.get(i - 2));
            p4.playerHand.add(cardDeck.get(i - 3));
        }
    }

    @Override
    public String toString() {
        String str = "";
        int i = 1;
        for (Card card : cardDeck) {
            str += card + " ";
            i++;
            if (i == 13) {
                str += "\n";
                i = 1;
            }
        }
        return str;
    }
}
