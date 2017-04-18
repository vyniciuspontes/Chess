/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.pieces;

import com.vpontes.gameframework.math.Vector2;

/**
 *
 * @author Thiago
 */
public class Bishop extends Piece {

    public Bishop(Vector2 position, int widght, int height, String imagePath) {
        super(position, widght, height, imagePath);
    }

    @Override
    public int[][] getMovement() {
        return null;
    }

}
