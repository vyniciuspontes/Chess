package com.uff.chess.test.base;


import com.uff.chess.gameobjects.board.Spot;
import java.util.HashSet;
import java.util.Set;

/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */

/**
 *
 * @author Vynicius
 */
public class BaseSpotTest {
    
    public Set<Spot> getSpotSet(String[] codes) {

        Set<Spot> returnSet = new HashSet<>();

        for (String code : codes) {
            returnSet.add(new Spot(code));
        }

        return returnSet;
    }
}
