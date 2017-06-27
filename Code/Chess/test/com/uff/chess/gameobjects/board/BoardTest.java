/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects.board;

import com.uff.chess.gameobjects.pieces.King;
import com.uff.chess.gameobjects.pieces.Pawn;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;
import com.uff.chess.gameobjects.pieces.Queen;
import com.uff.chess.gameobjects.pieces.Rook;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vynicius
 */
public class BoardTest {
    
    public BoardTest() {
        
    }
    @Before
    public void setUp() {        
    }
    
    @Test
    public void testWhiteKingXeque(){
        
        Board board = new Board(new Vector2(0, 0), 800, 600, null);
        board.setupSpots();
        Point whiteKingPosition = new Point(4,6);
        board.addPieceToSpot(whiteKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.WHITE, null));
        
        assertFalse("Erro ao verificar rei branco em xeque sem inimigos", board.kingInCheck(PieceColor.WHITE, board.getSpotByPosition(whiteKingPosition)));
        
        board.addPieceToSpot(new Point(4, 4), new Queen(new Vector2(), 0, 0, PieceColor.BLACK, null));
        
        assertTrue("Erro ao verificar rei branco em xeque", board.kingInCheck(PieceColor.WHITE, board.getSpotByPosition(whiteKingPosition)));
        
        board.addPieceToSpot(new Point(4, 5), new Pawn(new Vector2(), 0, 0, PieceColor.WHITE, null));
        
        assertFalse("Erro ao verificar rei branco não está em xeque", board.kingInCheck(PieceColor.WHITE, board.getSpotByPosition(whiteKingPosition)));
    }
    
    @Test
    public void testBlackKingXeque(){
        
        Board board = new Board(new Vector2(0, 0), 800, 600, null);
        board.setupSpots();
        Point whiteKingPosition = new Point(4,6);
        board.addPieceToSpot(whiteKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.BLACK, null));
        
        assertFalse("Erro ao verificar rei preto não está em xeque sem inimigos", board.kingInCheck(PieceColor.BLACK, board.getSpotByPosition(whiteKingPosition)));
        
        board.addPieceToSpot(new Point(4, 4), new Queen(new Vector2(), 0, 0, PieceColor.WHITE, null));
        
        assertTrue("Erro ao verificar rei preto em xeque", board.kingInCheck(PieceColor.BLACK, board.getSpotByPosition(whiteKingPosition)));
        
        board.addPieceToSpot(new Point(4, 5), new Pawn(new Vector2(), 0, 0, PieceColor.BLACK, null));
        
        assertFalse("Erro ao verificar rei preto não está em xeque", board.kingInCheck(PieceColor.BLACK, board.getSpotByPosition(whiteKingPosition)));
    }
    
    @Test
    public void testPossibleKingMoves(){
        Board board = new Board(new Vector2(0, 0), 800, 600, null);
        board.setupSpots();
        
        //Sem remover
        Point whiteKingPosition = new Point(4,6);
        Spot whiteKingSpot = board.getSpotByPosition(whiteKingPosition);
        board.addPieceToSpot(whiteKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.WHITE, null));
        assertEquals(8, board.getPossibleMoves(whiteKingSpot).size());
       
        //Sem remover
        Point blackKingPosition = new Point(4,1);
        Spot blackKingSpot = board.getSpotByPosition(blackKingPosition);
        board.addPieceToSpot(blackKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.BLACK, null));
        assertEquals(8, board.getPossibleMoves(blackKingSpot).size());
        
        //Removendo caminhos em xeque
        Spot blackQueenSpot = board.getSpotByPosition(new Point(2, 6));
        board.addPieceToSpot(new Point(2, 6), new Queen(new Vector2(), 0,0,Piece.PieceColor.BLACK, null));
        assertEquals(4, board.getPossibleMoves(whiteKingSpot).size());
        
        //Removendo caminhos em xeque comendo a peça que ameaça o rei
        board.movePiece(board.getSpotByPosition(new Point(3, 6)), blackQueenSpot, blackQueenSpot.getCurrentPiece());
        assertEquals(3, board.getPossibleMoves(whiteKingSpot).size());
        
        //Removendo caminhos em xeque evitando comer a peça que ameaça o rei visto que se fizer isso havera outra ameaça
        board.addPieceToSpot(new Point(2, 6), new Rook(new Vector2(), 0,0,Piece.PieceColor.BLACK, null));
        assertEquals(2, board.getPossibleMoves(whiteKingSpot).size());
        
    }
    
    
}
