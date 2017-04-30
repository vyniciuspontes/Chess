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
 * @author Thiago & Vynicius Pontes
 */
public class Player implements Dynamic {

    private final PieceColor type;
    private final Board board;

    public Player(PieceColor type, Board board) {
        this.type = type;
        this.board = board;
    }

    public PieceColor getType() {
        return type;
    }

    @Override
    public void update(double deltaTime) {
    }
}
