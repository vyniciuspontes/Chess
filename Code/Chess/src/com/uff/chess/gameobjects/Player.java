/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import java.util.List;

/**
 *
 * @author Thiago
 */
public class Player {
    
    private static List<Piece> pieces;
    
    public static List<Piece> getPieces(){
        return pieces;
    }
}
