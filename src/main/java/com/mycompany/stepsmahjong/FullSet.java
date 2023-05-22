package com.mycompany.stepsmahjong;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This represents a full set of mahjong tiles.
 * There should be 136 tiles in total.
 * Probably a good idea to make this a singleton.
 *
 * @author Blend Mustafa
 */
public class FullSet {
    private final ArrayList<RiichiMahjongTile> tiles;
    private final int numOfEachTile = 4; //there are 4 of each tile
    
    public FullSet() {
        this.tiles = new ArrayList<>();
    }
   
    public void fill() {
        //Fills the set with the necessary amount of tiles
        for (int i = 1; i <= numOfEachTile; i++){
            //numbered tiles
            for (RiichiMahjongTile.Suit suit : RiichiMahjongTile.manPinSou){
                for (RiichiMahjongTile.Rank rank : RiichiMahjongTile.numbers){
                    RiichiMahjongTile tile = new RiichiMahjongTile(suit, rank);
                    getTiles().add(tile);
                }
            }
            //wind tiles
            for (RiichiMahjongTile.Suit suit : RiichiMahjongTile.wind){
                for (RiichiMahjongTile.Rank rank : RiichiMahjongTile.winds){
                    RiichiMahjongTile tile = new RiichiMahjongTile(suit, rank);
                    getTiles().add(tile);
                }
            }
            //dragon tiles
            for (RiichiMahjongTile.Suit suit : RiichiMahjongTile.dragon){
                for (RiichiMahjongTile.Rank rank : RiichiMahjongTile.dragons){
                    RiichiMahjongTile tile = new RiichiMahjongTile(suit, rank);
                    getTiles().add(tile);
                }
            }
        }
    }
    
    public void shuffle(){
        Collections.shuffle(tiles);
    }

    public ArrayList<RiichiMahjongTile> getTiles() {
        return tiles;
    }
}
