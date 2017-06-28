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
public class Pawn extends Piece {

    private boolean firstMovement;
    private int[][] movements;
    private final int[][] attackMovements = new int[][]{{1, 1}, {-1, 1}};

    public Pawn(Vector2 position, int widght, int height, PieceColor color, BufferedImage image) {
        super(position, widght, height, color, image);
        this.firstMovement = true;
        this.movements = new int[][]{{0, 2}, {0, 1}, {1, 1}, {-1, 1}};
    }

    public boolean isFirstMovement() {
        return firstMovement;
    }

    public void setFirstMovement() {
        this.firstMovement = false;
        this.movements = new int[][]{ {0, 1}, {1, 1}, {-1, 1} };
    }

    @Override
    public int[][] getMovements() {
        return movements;
    }

    public int[][] getAttackMovements() {
        return attackMovements;
    }

    @Override
    public boolean isContinuous() {
        return false;
    }

}
