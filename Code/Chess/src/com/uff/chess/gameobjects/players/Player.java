/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.players;

import com.uff.chess.gameobjects.board.Board;
import com.uff.chess.gameobjects.GameManager;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;

/**
 *
 * @author Vynicius
 */
public class Player {

    protected PieceColor color;
    protected final Board board;
    protected final GameManager manager;

    public PieceColor getColor() {
        return color;
    }

    public Player(GameManager manager, PieceColor color, Board board) {
        this.color = color;
        this.board = board;
        this.manager = manager;
    }
}
