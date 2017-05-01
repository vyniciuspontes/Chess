/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.pieces;

import com.vpontes.gameframework.math.Vector2;
import java.awt.image.BufferedImage;

/**
 *
 * @author Thiago
 */
public class Rook extends Piece {

    public Rook(Vector2 position, int widght, int height, PieceColor color, BufferedImage image) {
        super(position, widght, height, color, image);
    }

    @Override
    public int[][] getMovement() {
        return new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
    }

    @Override
    public boolean isContinuous() {
        return true;
    }

}
