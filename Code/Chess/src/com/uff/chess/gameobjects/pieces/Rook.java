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
public class Rook extends Piece {

    public Rook(Vector2 position, int widght, int height, PieceColor color, String imagePath) {
        super(position, widght, height, color, imagePath);
    }

    @Override
    public int[][] getMovement() {
        return null;
    }

}
