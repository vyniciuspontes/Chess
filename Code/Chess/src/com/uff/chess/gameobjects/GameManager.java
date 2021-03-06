/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import com.uff.chess.gameobjects.board.Board;
import com.uff.chess.gameobjects.players.HumamPlayer;
import com.uff.chess.gameobjects.players.IA;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;
import com.uff.chess.screens.Menu;
import com.vpontes.gameframework.core.Game;
import com.vpontes.gameframework.math.Vector2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Vynicius Pontes
 */
public class GameManager implements MouseListener, Dynamic {

    private final Board board;
    private HumamPlayer player1;
    private HumamPlayer player2;
    private IA ia;
    private PieceColor currentColor;
    private Game game;
    
    
    private GameManager(Board board, Game game) {
        this.board = board;
        this.game = game;
        this.currentColor = PieceColor.WHITE;
    }

    public GameManager(Game game, Board board, PieceColor player1Color, PieceColor player2Color, boolean onlyHumans) {
        this(board, game);
        if(onlyHumans){
            player1 = new HumamPlayer(this, player1Color, board);
            player2 = new HumamPlayer(this, player2Color, board);
        }else{
            player1 = new HumamPlayer(this, player1Color, board);
            ia= new IA(this, player2Color, board);
        }
    }

    public void changeTurn() {

        switch (currentColor) {
            case WHITE:
                currentColor = PieceColor.BLACK;
                break;
            case BLACK:
                currentColor = PieceColor.WHITE;
                break;
            default:
                throw new AssertionError();
        }
        
        if(board.getWinCondition(currentColor)){
            if(currentColor == PieceColor.WHITE) {
                JOptionPane.showMessageDialog(this.game.getFrame(), "O Lado Preto Venceu !", "O Jogo Acabou",
                    JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this.game.getFrame(), "O Lado Branco Venceu !", "O Jogo Acabou",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
            this.game.setScreen(new Menu(game));
        }
        
        if (ia != null && currentColor == ia.getColor()) {
            this.ia.play();
        }
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton() != 1 || (ia != null && currentColor == ia.getColor())) {
            return;
        }

        Vector2 clickPosition = new Vector2(e.getPoint().getX(), e.getPoint().getY());

        if (player1.getColor() == currentColor) {
            player1.humamPlayerMove(clickPosition);
        } else {
            player2.humamPlayerMove(clickPosition);
        }

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
