/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

/**
 *
 * @author Thiago
 */
public class Piece {

    
    private boolean isContinuous;
    private boolean isActive;
    
    
    public static int[][] getMovement(){
        
        return null;
    }
    
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
}
