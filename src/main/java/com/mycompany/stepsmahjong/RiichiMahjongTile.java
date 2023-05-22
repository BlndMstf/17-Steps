package com.mycompany.stepsmahjong;
import java.util.EnumSet;

/**
 * Tiles to be used for this specific game
 * This game is a variation of riichi mahjong,
 * and therefore uses the exact same tiles.
 *
 * @author Blend Mustafa
 */
public class RiichiMahjongTile extends Tile {
    private Suit enumSuit;
    private Rank enumRank;
    
    static EnumSet<Suit> manPinSou = EnumSet.of(Suit.MAN, Suit.PIN, Suit.SOU);
    static EnumSet<Suit> wind = EnumSet.of(Suit.WIND);
    static EnumSet<Suit> dragon = EnumSet.of(Suit.DRAGON);
    
    static EnumSet<Rank> numbers = EnumSet.range(Rank.ONE, Rank.NINE);
    static EnumSet<Rank> winds = EnumSet.range(Rank.NORTH, Rank.WEST);
    static EnumSet<Rank> dragons = EnumSet.range(Rank.RED, Rank.WHITE);
    
    RiichiMahjongTile (Suit suit, Rank rank){
        super(suit.suit, rank.value); //stores suit and rank as string and int respectively
        this.enumSuit = suit;
        this.enumRank = rank;
    }
    
    enum Suit {
        MAN ("Man"), PIN ("Pin"), SOU ("Sou"), 
        WIND ("Wind"), 
        DRAGON ("Dragon");
        
        String suit;
        
        Suit (String suit){
            this.suit = suit;
        }
    }

    enum Rank {
        //number tiles
        ONE (1, "One"), TWO (2, "Two"), THREE (3, "Three"), FOUR (4, "Four"), FIVE (5, "Five"), SIX (6, "Six"), SEVEN (7, "Seven"), EIGHT (8, "Eight"), NINE (9, "Nine"),
        //wind tiles
        NORTH (11, "North"), EAST (12, "East"), SOUTH (13, "South"), WEST (14, "West"),
        //dragon tiles
        RED (21, "Red"), GREEN (22, "Green"), WHITE (23, "White");
        
        int value;
        String rank;
        
        Rank (int value, String rank){
            this.value = value;
            this.rank = rank;
        }        
    }

    Suit getEnumSuit() {
        return enumSuit;
    }

    void setEnumSuit(Suit enumSuit) {
        this.enumSuit = enumSuit;
    }

    Rank getEnumRank() {
        return enumRank;
    }

    void setEnumRank(Rank enumRank) {
        this.enumRank = enumRank;
    }
    
    @Override
    public String toString() {
        return getEnumRank().rank + " " + getSuit();
    }
}
