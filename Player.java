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

public class Player {

    private String name;
    private int id;
    //Card[] hand = new Card[13];
    ArrayList<Card> playerHand = new ArrayList();

    public Player() {
    }

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    //show player's info
    public String toString() {
        String str = id + "-" + name + ": ";
        for (var card : playerHand) {
            str += card + "  ";
        }
        return str;
    }
}
