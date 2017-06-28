/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.test.gameobjects.board;

import com.uff.chess.test.base.BaseSpotTest;
import com.uff.chess.gameobjects.board.Board;
import com.uff.chess.gameobjects.board.Spot;
import com.uff.chess.gameobjects.pieces.King;
import com.uff.chess.gameobjects.pieces.Pawn;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;
import com.uff.chess.gameobjects.pieces.Queen;
import com.uff.chess.gameobjects.pieces.Rook;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Point;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vynicius
 */
public class BoardTest extends BaseSpotTest{

    public BoardTest() {

    }

    @Before
    public void setUp() {
    }

    @Test
    public void testWhiteKingXeque() {

        Board board = new Board(new Vector2(0, 0), 800, 600, null);
        board.setupSpots();
        Point whiteKingPosition = new Point(4, 6);
        board.addPieceToSpot(whiteKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.WHITE, null));

        assertFalse("Erro ao verificar rei branco em xeque sem inimigos", board.kingInCheck(PieceColor.WHITE, board.getSpotByPosition(whiteKingPosition)));

        board.addPieceToSpot(new Point(4, 4), new Queen(new Vector2(), 0, 0, PieceColor.BLACK, null));

        assertTrue("Erro ao verificar rei branco em xeque", board.kingInCheck(PieceColor.WHITE, board.getSpotByPosition(whiteKingPosition)));

        board.addPieceToSpot(new Point(4, 5), new Pawn(new Vector2(), 0, 0, PieceColor.WHITE, null));

        assertFalse("Erro ao verificar rei branco não está em xeque", board.kingInCheck(PieceColor.WHITE, board.getSpotByPosition(whiteKingPosition)));
    }

    @Test
    public void testBlackKingXeque() {

        Board board = new Board(new Vector2(0, 0), 800, 600, null);
        board.setupSpots();
        Point whiteKingPosition = new Point(4, 6);
        board.addPieceToSpot(whiteKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.BLACK, null));

        assertFalse("Erro ao verificar rei preto não está em xeque sem inimigos", board.kingInCheck(PieceColor.BLACK, board.getSpotByPosition(whiteKingPosition)));

        board.addPieceToSpot(new Point(4, 4), new Queen(new Vector2(), 0, 0, PieceColor.WHITE, null));

        assertTrue("Erro ao verificar rei preto em xeque", board.kingInCheck(PieceColor.BLACK, board.getSpotByPosition(whiteKingPosition)));

        board.addPieceToSpot(new Point(4, 5), new Pawn(new Vector2(), 0, 0, PieceColor.BLACK, null));

        assertFalse("Erro ao verificar rei preto não está em xeque", board.kingInCheck(PieceColor.BLACK, board.getSpotByPosition(whiteKingPosition)));
    }

    @Test
    public void testPossibleKingMoves() {

        Set<Spot> predefinedResultSet;

        Board board = new Board(new Vector2(0, 0), 800, 600, null);
        board.setupSpots();

        //Sem remover white king
        Point whiteKingPosition = new Point(4, 6);
        Spot whiteKingSpot = board.getSpotByPosition(whiteKingPosition);
        board.addPieceToSpot(whiteKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.WHITE, null));
        predefinedResultSet = this.getSpotSet(new String[]{"F6", "H6", "F5", "H5", "G6", "G4", "F4", "H4"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(whiteKingSpot));

        //Removendo caminhos em xeque white king
        Spot blackQueenSpot = board.getSpotByPosition(new Point(2, 6));
        board.addPieceToSpot(new Point(2, 6), new Queen(new Vector2(), 0, 0, Piece.PieceColor.BLACK, null));
        predefinedResultSet = this.getSpotSet(new String[]{"F6", "H6", "F5", "H5"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(whiteKingSpot));

        //Removendo caminhos em xeque comendo a peça que ameaça o rei white king
        board.movePiece(board.getSpotByPosition(new Point(3, 6)), blackQueenSpot, blackQueenSpot.getCurrentPiece());
        predefinedResultSet = this.getSpotSet(new String[]{"F6", "H6", "G4"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(whiteKingSpot));

        //Removendo caminhos em xeque evitando comer a peça que ameaça o rei visto que se fizer isso havera outra ameaça white king
        board.addPieceToSpot(new Point(2, 6), new Rook(new Vector2(), 0, 0, Piece.PieceColor.BLACK, null));

        predefinedResultSet = this.getSpotSet(new String[]{"F6", "H6"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(whiteKingSpot));

        //Sem remover black king
        Point blackKingPosition = new Point(4, 1);
        Spot blackKingSpot = board.getSpotByPosition(blackKingPosition);
        board.addPieceToSpot(blackKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.BLACK, null));
        predefinedResultSet = this.getSpotSet(new String[]{"A6", "C6", "A5", "C5", "B6", "B4", "A4", "C4"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(blackKingSpot));

        //Removendo caminhos em xeque black king
        Spot whiteQueenSpot = board.getSpotByPosition(new Point(2, 1));
        board.addPieceToSpot(new Point(2, 1), new Queen(new Vector2(), 0, 0, Piece.PieceColor.WHITE, null));
        predefinedResultSet = this.getSpotSet(new String[]{"A6", "C6", "A5", "C5"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(blackKingSpot));

        //Removendo caminhos em xeque comendo a peça que ameaça o rei black king
        board.movePiece(board.getSpotByPosition(new Point(3, 1)), whiteQueenSpot, whiteQueenSpot.getCurrentPiece());
        predefinedResultSet = this.getSpotSet(new String[]{"A6", "C6", "B4"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(blackKingSpot));

        //Removendo caminhos em xeque evitando comer a peça que ameaça o rei visto que se fizer isso havera outra ameaça black king
        board.addPieceToSpot(new Point(2, 1), new Rook(new Vector2(), 0, 0, Piece.PieceColor.WHITE, null));
        predefinedResultSet = this.getSpotSet(new String[]{"A6", "C6"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(blackKingSpot));

    }

    @Test
    public void testWhitePiecesProtectingKing() {

        Set<Spot> predefinedResultSet;

        Board board = new Board(new Vector2(0, 0), 800, 600, null);
        board.setupSpots();

        /**
         * Teste o movimento da rainha branca caso o rei esteja em perigo e sua
         * posição para defender seja vazia
         */
        Point whiteKingPosition = new Point(4, 6);
        Point whiteQueenPosition = new Point(3, 6);
        Spot whiteQueenSpot = board.getSpotByPosition(whiteQueenPosition);
        
        board.addPieceToSpot(whiteKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.WHITE, null));
        board.addPieceToSpot(whiteQueenPosition, new Queen(new Vector2(), 0, 0, Piece.PieceColor.WHITE, null));
        board.addPieceToSpot(new Point(4, 4), new Queen(new Vector2(), 0, 0, PieceColor.BLACK, null));
        predefinedResultSet = this.getSpotSet(new String[]{"F5"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(whiteQueenSpot));
        
        /**
         * Testa caso a peça esteja protegendo o rei de alguma ameaça ela nao pode se mover
         */
        //assertTrue(board.getPossibleMoves(whiteQueenSpot).isEmpty());

        /**
         * Teste do movimento da rainha branca caso o rei esteja em perido e seu
         * movimento para defender contenha o agressor
         */
        board.movePiece(board.getSpotByPosition(new Point(0, 4)), whiteQueenSpot, whiteQueenSpot.getCurrentPiece());
        whiteQueenSpot = board.getSpotByPosition(new Point(0, 4));

        predefinedResultSet = this.getSpotSet(new String[]{"E5"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(whiteQueenSpot));
    }

    @Test
    public void testBlackPiecesProtectingKing() {

        Set<Spot> predefinedResultSet;

        Board board = new Board(new Vector2(0, 0), 800, 600, null);
        board.setupSpots();

        /**
         * Teste o movimento da rainha preta caso o rei esteja em perigo e sua
         * posição para defender seja vazia
         */
        Point blackKingPosition = new Point(4, 6);
        Point blackQueenPosition = new Point(3, 6);
        Spot blackQueenSpot = board.getSpotByPosition(blackQueenPosition);
        
        board.addPieceToSpot(blackKingPosition, new King(new Vector2(), 0, 0, Piece.PieceColor.BLACK, null));
        board.addPieceToSpot(blackQueenPosition, new Queen(new Vector2(), 0, 0, Piece.PieceColor.BLACK, null));
        board.addPieceToSpot(new Point(4, 4), new Queen(new Vector2(), 0, 0, PieceColor.WHITE, null));
        predefinedResultSet = this.getSpotSet(new String[]{"F5"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(blackQueenSpot));

        /**
         * Teste do movimento da rainha preta caso o rei esteja em perigo e seu
         * movimento para defender contenha o agressor
         */
        board.movePiece(board.getSpotByPosition(new Point(0, 4)), blackQueenSpot, blackQueenSpot.getCurrentPiece());
        blackQueenSpot = board.getSpotByPosition(new Point(0, 4));

        predefinedResultSet = this.getSpotSet(new String[]{"E5"});
        assertEquals(predefinedResultSet, board.getPossibleMoves(blackQueenSpot));
    }

}
