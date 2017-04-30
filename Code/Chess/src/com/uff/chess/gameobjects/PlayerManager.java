/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import com.uff.chess.gameobjects.pieces.Piece;
import com.vpontes.gameframework.math.OverlapTester;
import com.vpontes.gameframework.math.Vector2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Vynicius Pontes
 */
public class PlayerManager implements MouseListener {

    private final Board board;
    private final Player player1;
    private final Player player2;
    private final Piece.PieceColor actualTurnColor;
    private Spot selectedSpot;

    public PlayerManager(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.actualTurnColor = Piece.PieceColor.BLACK;
    }

    public void playerMove(Vector2 clickPosition) {

        Spot currentSpot = board.getSpotByMouseClick(clickPosition);

        //o spot retornado e nulo ?
        if (currentSpot != null) {
            
            if (selectedSpot == null && currentSpot.isOcuppied()) {
                if(currentSpot.getCurrentPiece().getPieceColor() != actualTurnColor)
                    return;
                selectedSpot = currentSpot;
                board.showPossiblePaths(currentSpot);
            } else {
                if (selectedSpot != null && !currentSpot.isOcuppied()) {
                    currentSpot.ocuppySpot(selectedSpot.getCurrentPiece());
                    selectedSpot.releaseSpot();
                }
                selectedSpot = null;

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() != 1) {
            return;
        }

        Vector2 clickPosition = new Vector2(e.getPoint().getX(), e.getPoint().getY());

        playerMove(clickPosition);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
