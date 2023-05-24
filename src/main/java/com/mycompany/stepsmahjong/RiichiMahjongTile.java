package com.mycompany.stepsmahjong;
import java.util.EnumSet;
import java.util.Collections;
import java.util.Objects;

/**
 * Tiles to be used for this specific game
 * This game is a variation of riichi mahjong,
 * and therefore uses the exact same tiles.
 *
 * @author Blend Mustafa
 */
public class RiichiMahjongTile extends Tile implements Comparable {
    private Suit enumSuit;
    private Rank enumRank;
    private int order;
    
    static EnumSet<Suit> manPinSou = EnumSet.of(Suit.MAN, Suit.PIN, Suit.SOU);
    static EnumSet<Suit> wind = EnumSet.of(Suit.WIND);
    static EnumSet<Suit> dragon = EnumSet.of(Suit.DRAGON);
    
    static EnumSet<Rank> numbers = EnumSet.range(Rank.ONE, Rank.NINE);
    static EnumSet<Rank> winds = EnumSet.range(Rank.EAST, Rank.NORTH);
    static EnumSet<Rank> dragons = EnumSet.range(Rank.WHITE, Rank.RED);
    
    private boolean isGreen = false; //checks if a tile is fully green
    private boolean isHonorOrTerminal = false; //checks if a tile is an honor or a terminal
    private boolean isRedFive = false; //boolean that makes a tile red when activated
    
    RiichiMahjongTile (Suit suit, Rank rank){
        super(suit.suit, rank.value); //stores suit and rank as string and int respectively
        this.enumSuit = suit;
        this.enumRank = rank;
        
        //used to put the tiles in correct order (man, pin, sou, wind, dragon)
        switch (suit) {
            case MAN:
                this.order = this.enumRank.value;
                break;
            case PIN:
                this.order = this.enumRank.value + 9;
                break;
            case SOU:
                this.order = this.enumRank.value + 18;
                break;
            default:
                this.order = this.enumRank.value;
                break;
        }
        
        //used to designate certain tiles as honors or terminals
        if (rank == Rank.ONE || rank == Rank.NINE || suit == Suit.WIND || suit == Suit.DRAGON){
            this.isHonorOrTerminal = true;
        }
        
        //used to designate certain tiles as green (tile only uses green ink)
        if (suit == Suit.SOU){
            switch (rank){
                case TWO:
                    this.isGreen = true;
                    break;
                case THREE:
                    this.isGreen = true;
                    break;
                case FOUR:
                    this.isGreen = true;
                    break;
                case SIX:
                    this.isGreen = true;
                    break;
                case EIGHT:
                    this.isGreen = true;
                    break;
                default:
                    break;
            }
        }
        else if (rank == Rank.GREEN){
            this.isGreen = true;
        }
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
        EAST (28, "East"), SOUTH (29, "South"), WEST (30, "West"), NORTH (31, "North"),
        //dragon tiles
        WHITE (32, "White"), GREEN (33, "Green"), RED (34, "Red");
        
        int value;
        String rank;
        
        Rank (int value, String rank){
            this.value = value;
            this.rank = rank;
        }        
    }
    
    @Override
    public String toString() {
        return getEnumRank().rank + " " + getSuit();
    }
    
    @Override
    public int compareTo(Object otherTileAsObject)
    {
        //Used to arrange a group of tiles in the typical mahjong order (man, pin, sou, winds, dragons)
        RiichiMahjongTile otherTile = (RiichiMahjongTile)otherTileAsObject;
        
        if (order < otherTile.order){
            return -1;
        }
        else if (order > otherTile.order){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public boolean equals(Object otherTileAsObject) {
        if (this == otherTileAsObject) {
            return true;
        }
        if (otherTileAsObject == null || getClass() != otherTileAsObject.getClass()) {
            return false;
        }
        RiichiMahjongTile otherTile = (RiichiMahjongTile) otherTileAsObject;
        return (Objects.equals(suit, otherTile.suit) && Objects.equals(rank, otherTile.rank));
    }

    //Rest is getters and setters
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public boolean isHonorOrTerminal() {
        return isHonorOrTerminal;
    }

    public boolean isRedFive() {
        return isRedFive;
    }

    public void setIsRedFive(boolean isRedFive) {
        this.isRedFive = isRedFive;
    }
}
