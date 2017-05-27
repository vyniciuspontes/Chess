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
public class King extends Piece {

    public King(Vector2 position, int widght, int height, PieceColor color, BufferedImage image) {
        super(position, widght, height, color, image);
    }

    @Override
    public int[][] getMovements() {
        return new int[][]{
            {1, 0}, {1,1}, {1,-1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, -1}, {0, 1}
        };
    }

    @Override
    public boolean isContinuous() {
        return false;
    }

}
