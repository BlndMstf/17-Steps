package com.mycompany.stepsmahjong;

/**
 * Abstract class that defines tiles to be used for mahjong
 *
 * @author Blend Mustafa
 */
public abstract class Tile {
    private String suit;
    private int rank;
    
    public Tile(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    
    @Override
    public String toString() {
        return rank + " " + suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }


    public void setRank(int rank) {
        this.rank = rank;
    }
}
