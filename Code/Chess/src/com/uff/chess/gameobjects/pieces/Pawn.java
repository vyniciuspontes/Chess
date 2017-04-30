/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.pieces;

import com.vpontes.gameframework.math.Vector2;
import java.awt.Image;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Thiago
 */
public class Pawn extends Piece {

    public static int[][] checkAttackMovement() {

        return null;
    }

    public Pawn(Vector2 position, int widght, int height, PieceColor color, String imagePath) {
        super(position, widght, height,color, imagePath);
    }
    
    @Override
    public int[][] getMovement() {
        return new int[][]{
            {0, 1}
        };
    }

}
