/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.pieces;

import com.uff.chess.gameobjects.GameObject;
import com.vpontes.gameframework.math.Vector2;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago & Vynicius Pontes
 */
public abstract class Piece extends GameObject implements Cloneable{

    private boolean isContinuous;
    private boolean isActive;
    
    public Piece(Vector2 position, int widght, int height, String imagePath) {
        super(position, widght, height, imagePath);
    }

    public abstract int[][] getMovement();

    public boolean isIsContinuous() {
        return isContinuous;
    }

    public void setIsContinuous(boolean isContinuous) {
        this.isContinuous = isContinuous;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public Piece clone() {
        try {
            return (Piece)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Piece.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return getClass().toString();
    }
    
    
    
}
