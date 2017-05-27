/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;
import com.vpontes.gameframework.math.Vector2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * @author Vynicius Pontes
 */
public class GameManager implements MouseListener {

    private final Board board;
    private final Player player1;
    private final Player player2;
    private PieceColor actualTurnColor;
    private Spot selectedSpot;
    private List<Spot> possiblePaths;

    public GameManager(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.actualTurnColor = PieceColor.WHITE;
    }

    public void playerMove(Vector2 clickPosition) {

        Spot currentSpot = board.getSpotByMouseClick(clickPosition);

        if (currentSpot != null) {

            if (selectedSpot == null && currentSpot.isOcuppied()) {
                if (currentSpot.getCurrentPiece().getPieceColor() != actualTurnColor) {
                    return;
                }
                selectedSpot = currentSpot;
                selectedSpot.mouseClicked();
                possiblePaths = board.showPossiblePaths(currentSpot);
            } else {
                if (selectedSpot != null && possiblePaths != null && possiblePaths.contains(currentSpot)) {
                    //player fez sua jogada
                    currentSpot.ocuppySpot(selectedSpot.getCurrentPiece());
                    selectedSpot.releaseSpot();
                    changeTurn();
                }
                board.turnOffPath();
                selectedSpot = null;
            }
        }
    }

    private void changeTurn() {
        switch (actualTurnColor) {
            case WHITE:
                this.actualTurnColor = PieceColor.BLACK;
                break;
            case BLACK:
                actualTurnColor = PieceColor.WHITE;
                break;
            default:
                throw new AssertionError();
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
