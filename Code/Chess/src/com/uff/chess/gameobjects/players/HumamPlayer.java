/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.players;

import com.uff.chess.gameobjects.board.Board;
import com.uff.chess.gameobjects.GameManager;
import com.uff.chess.gameobjects.board.Spot;
import com.uff.chess.gameobjects.pieces.Piece;
import com.vpontes.gameframework.math.Vector2;
import java.util.Set;

/**
 *
 * @author Vynicius
 */
public class HumamPlayer extends Player {

    private Spot selectedSpot;
    private Set<Spot> possiblePaths;

    public HumamPlayer(GameManager manager, Piece.PieceColor color, Board board) {
        super(manager, color, board);
    }

    public void humamPlayerMove(Vector2 clickPosition) {

        Spot currentSpot = board.getSpotByMouseClick(clickPosition);

        if (currentSpot != null) {

            if (selectedSpot == null && currentSpot.isOcuppied()) {
                System.out.println(currentSpot.getCode());
                if (currentSpot.getCurrentPiece().getPieceColor() != this.color) {
                    return;
                }
                possiblePaths = board.getPossibleMoves(currentSpot);
                if (possiblePaths.isEmpty()) {
                    return;
                }
                board.turnPath(true, possiblePaths);
                selectedSpot = currentSpot;
                selectedSpot.mouseClicked();
            } else {
                
                board.clearAllSelectedSpots();
                if (selectedSpot != null && possiblePaths != null
                        && possiblePaths.contains(currentSpot)) {
                    //&& !board.kingInCheck(actualTurnColor)) {

                    //if (possiblePaths.contains(currentSpot)) {
                    //player fez sua jogada
                   
                    System.out.println("MOVED " + selectedSpot.getCurrentPiece().toString().toUpperCase() + " FROM "
                            + currentSpot.toString() + " TO " + selectedSpot.toString());
                    board.movePiece(currentSpot, selectedSpot, selectedSpot.getCurrentPiece());
                    manager.changeTurn();
                }
                selectedSpot = null;
            }
        }
    }
}
