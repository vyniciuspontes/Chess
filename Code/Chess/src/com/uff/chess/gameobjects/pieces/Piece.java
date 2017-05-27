/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.pieces;

import com.uff.chess.gameobjects.GameObject;
import com.vpontes.gameframework.math.Vector2;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago & Vynicius Pontes
 */
public abstract class Piece extends GameObject implements Cloneable {

    private boolean removed;
    private final PieceColor pieceColor;

    public Piece(Vector2 position, int widght, int height, PieceColor color, BufferedImage image) {
        super(position, widght, height, image);

        this.pieceColor = color;
    }

    public abstract int[][] getMovements();

    public abstract boolean isContinuous();

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    @Override
    public Piece clone() {
        try {
            return (Piece) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Piece.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return this.pieceColor + " " + getClass().getSimpleName();
    }

    public enum PieceColor {
        WHITE, BLACK
    }

}
