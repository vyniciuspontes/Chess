/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.test.gameobjects.players;

import com.uff.chess.gameobjects.GameManager;
import com.uff.chess.gameobjects.board.Board;
import com.uff.chess.gameobjects.board.Spot;
import com.uff.chess.gameobjects.pieces.Pawn;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.gameobjects.players.HumamPlayer;
import com.uff.chess.main.ChessGame;
import com.uff.chess.test.base.BaseSpotTest;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Point;
import java.util.Set;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vynicius
 */
public class HumamPlayerTest extends BaseSpotTest{
    
    public HumamPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of humamPlayerMove method, of class HumamPlayer.
     */
    @Test
    public void testHumamPlayerMove() {
        //System.out.println("humamPlayerMove");
        
        Board board = new Board(new Vector2(0, 0), 800, 600, ResourceManager.BACKGROUND);
        board.setupSpots();
        board.createDefaultPieces();
        GameManager manager = new GameManager(new ChessGame(0, 0, "Teste"), board, Piece.PieceColor.WHITE, Piece.PieceColor.BLACK, true);
        HumamPlayer instance = new HumamPlayer(manager, Piece.PieceColor.WHITE, board);
        
        //Selecionando um spot vazio
        instance.humamPlayerMove(board.getSpotByPosition(new Point(4,1)));
        assertNull(instance.getPossiblePaths());
        
        //Selecionando uma peça de outra cor
        instance.humamPlayerMove(board.getSpotByPosition(new Point(0,1)));
        assertNull(instance.getPossiblePaths());
        
        
        //Selecionando uma peça aliada mas que nao possui movimentos naquele momento
        instance.humamPlayerMove(board.getSpotByPosition(new Point(0,7)));
        assertTrue(instance.getPossiblePaths().isEmpty());
        
        //Selecionando uma peça aliada que possui movimentos
        instance.humamPlayerMove(board.getSpotByPosition(new Point(1,6)));
        assertTrue(instance.getPossiblePaths().size() > 0);
        //Clicando na mesma peça 2 vezes
        instance.humamPlayerMove(board.getSpotByPosition(new Point(1,6)));
        assertTrue(instance.getPossiblePaths().isEmpty());
        
        /**
         * Selecionando peça aliada e clicando em um spot vazio ou que nao esta nos movimentos possiveis 
         */
        instance.humamPlayerMove(board.getSpotByPosition(new Point(1,6)));
        instance.humamPlayerMove(board.getSpotByPosition(new Point(2,5)));
        assertTrue(instance.getPossiblePaths().isEmpty());
        
        /**
         * Selecionando peça aliada e clicando em um possivel movimento
         */
        instance.humamPlayerMove(board.getSpotByPosition(new Point(5,6)));
        instance.humamPlayerMove(board.getSpotByPosition(new Point(5,5)));
        
        assertTrue(board.getSpotByPosition(new Point(5,5)).getCurrentPiece() instanceof Pawn);
        
        /**
         * Selecionando peça aliada e comendo peça adversaria
         */
        Piece whitePawn = board.getSpotByPosition(new Point(1,6)).getCurrentPiece();
        Spot blackPawnOriginSpot = board.getSpotByPosition(new Point(1,1));
        Spot blackPawnDestinationSpot = board.getSpotByPosition(new Point(2,5));
        board.movePiece(blackPawnDestinationSpot, blackPawnOriginSpot, blackPawnOriginSpot.getCurrentPiece());
        
        instance.humamPlayerMove(board.getSpotByPosition(new Point(1,6)));
        instance.humamPlayerMove(board.getSpotByPosition(new Point(2,5)));
        
        assertEquals(blackPawnDestinationSpot.getCurrentPiece(), whitePawn);
        assertTrue(instance.getPossiblePaths().isEmpty());
    }
    
}
