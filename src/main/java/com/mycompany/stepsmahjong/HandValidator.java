package com.mycompany.stepsmahjong;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is meant to check if a hand is valid or not
 * Generally a valid hand must have:
 * - 1 Pair (a pair is two tiles of the same suit rank)
 * - A combination of 4 Sequences or Triplets:
 *     A sequence is a group of three tiles of the same suit with sequential ranks (ex 5, 6, 7)
 *     A triplet is a group of three tiles of the same suit and rank (ex 8, 8, 8)
 * There are special conditions but this is the general condition
 * 
 * @author 
 */
public class HandValidator {
    public static boolean ValidateHand(ArrayList<RiichiMahjongTile> hand, int pairCount, int sequenceCount, int tripletCount){
        
        if (pairCount == 1 && sequenceCount + tripletCount == 4) {
            return true;
        }

        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getRank() == 0) {
                continue;
            }

            // in trio
            if (Collections.frequency(hand, hand.get(i)) >= 3) {
                RiichiMahjongTile tempTile = hand.get(i);
                int removedCount = 0;
                
                for (int j = 0; j < hand.size(); j++) {
                    if (hand.get(j).equals(tempTile)) {
                        hand.remove(j);
                        j--;
                        removedCount++;
                    }
                    if (removedCount == 3) {
                        break;
                        }
                    }
                if (ValidateHand(hand, pairCount, sequenceCount, tripletCount+1)) {
                    return true;
                }
                for (int j = 0; j < 3; j++) {
                        hand.add(tempTile);
                    }
                }

            // in pair
            if (Collections.frequency(hand, hand.get(i)) >= 2) {
                RiichiMahjongTile tempTile = hand.get(i);
                int removedCount = 0;
                
                for (int j = 0; j < hand.size(); j++) {
                    if (hand.get(j).equals(tempTile)) {
                        hand.remove(j);
                        j--;
                        removedCount++;
                    }
                    if (removedCount == 2) {
                        break;
                        }
                    }
                if (ValidateHand(hand, pairCount+1, sequenceCount, tripletCount)) {
                    return true;
                }
                for (int j = 0; j < 2; j++) {
                        hand.add(tempTile);
                    }
                }

            // in sequence
            /*
            if (i + 2 <= 9 && hand.get(i).getRank() >= 1 && hand.get(i+1).getRank() >= 1 && hand.get(i+2).getRank() >= 1) {
                hand.get(i).setRank(hand.get(i).getRank()-1);
                hand.get(i+1).setRank(hand.get(i).getRank()-1);
                hand.get(i+2).setRank(hand.get(i).getRank()-1);
                if (ValidateHand(hand, pairCount, sequenceCount+1, tripletCount)) {
                    return true;
                }
                hand.get(i).setRank(hand.get(i).getRank()+1);
                hand.get(i+1).setRank(hand.get(i).getRank()+1);
                hand.get(i+2).setRank(hand.get(i).getRank()+1);
            }
            */
        }
        return false;
    }
}
