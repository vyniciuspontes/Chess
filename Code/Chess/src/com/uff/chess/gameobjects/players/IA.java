/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.players;

import com.uff.chess.gameobjects.board.Board;
import com.uff.chess.gameobjects.Dynamic;
import com.uff.chess.gameobjects.GameManager;
import com.uff.chess.gameobjects.board.Spot;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        
        List<Spot> pieceSpots = new ArrayList(board.getSpotsWithPossibleMoves(this.color));
        
        Spot fromSpot = pieceSpots.get(new Random().nextInt(pieceSpots.size()));
        
        List<Spot> moves = new ArrayList(board.getPossibleMoves(fromSpot));
        
        Spot toSpot = moves.get(new Random().nextInt(moves.size()));
        
        board.movePiece(toSpot, fromSpot, fromSpot.getCurrentPiece());
        
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
