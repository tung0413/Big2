/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evonne
 */
public class Card {

    private int rank; //0-12
    private int suit; //0-3
    public static final String[] rankString = {" A", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K"};// change num to string
    public static final String[] suitString = {"   club", "diamond", "  heart", "  spade"}; // change num to string

    public Card() {
    }

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getStringRank() {
        return rankString[rank];
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public String getStringSuit() {
        return suitString[suit];
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return getStringSuit() + ' ' + getStringRank();// suit(english) rank
    }
}
