/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import com.uff.chess.gameobjects.pieces.Piece.PieceColor;

/**
 *
 * @author Vynicius Pontes
 */
public class GameManager implements Dynamic{

    private Board board;
    private PieceColor actualTurn;

    public PieceColor getActualTurn() {
        return actualTurn;
    }
    
    public GameManager(Board board) {
        this.board = board;
        this.actualTurn = PieceColor.WHITE;
    }
    
    
    @Override
    public void update(double deltaTime) {
    }
    
}
