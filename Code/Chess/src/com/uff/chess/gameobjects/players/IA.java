/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.players;

import com.uff.chess.gameobjects.Board;
import com.uff.chess.gameobjects.Dynamic;
import com.uff.chess.gameobjects.GameManager;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;

/**
 *
 * @author Vynicius
 */
public class IA extends Player implements Dynamic {

    private boolean moved;

    public IA(GameManager manager, PieceColor color, Board board) {
        super(manager, color, board);
    }

    public void play() {
        this.moved = true;
        System.out.println("IA is played");
        this.manager.changeTurn();
    }

    public boolean moved() {
        return moved;
    }

    @Override
    public void update(double deltaTime) {
        if (moved) {
            System.out.println("IA is playing");
            this.moved = false;
        }

    }
}
