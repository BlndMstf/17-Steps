package com.mycompany.stepsmahjong;

import java.util.Collections;
import java.util.ArrayList;

/**
 * This class gives some methods that can be used
 * whenever there is a group of tiles that need
 * to do something that isn't specific to that
 * particular group of tiles (such as shuffle or arrange)
 *
 * @author Blend Mustafa
 */
public abstract class GroupOfTiles {
    public void shuffle(ArrayList tiles){
        //Uses a built-in function with collections
        Collections.shuffle(tiles);
    }
    
    public void arrange(ArrayList tiles){
        //Uses a built-in function that is based off of the compareTo in the RiichiMahjongTile class
        Collections.sort(tiles);
    }
}
