/*
*
* Chess Game
* Software Engineering II - Universidade Federal Fluminense
*
 */
package com.uff.chess.gameobjects;

import com.uff.chess.gameobjects.pieces.Bishop;
import com.uff.chess.gameobjects.pieces.King;
import com.uff.chess.gameobjects.pieces.Knight;
import com.uff.chess.gameobjects.pieces.Pawn;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.gameobjects.pieces.Queen;
import com.uff.chess.gameobjects.pieces.Rook;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.math.Vector2;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago & Vynicius Pontes
 */
public class Player {
    
    private List<Piece> pieces;
    private final PlayerColor type; 
    
    public List<Piece> getPieces(){
        return pieces;
    }

    public Player(PlayerColor type, Board board) {
        this.type = type;
        this.createPieces(type, board);
    }
    
    private void createPieces(PlayerColor color, Board board){
        
        pieces = new ArrayList<>();
        if(color == PlayerColor.WHITE){
        
            Piece kingPiece = new King(new Vector2(), 50, 50, ResourceManager.WHITE_KING);
            board.getSpots()[7][4].ocuppySpot(kingPiece);
            pieces.add(kingPiece);
            
            Piece queenPiece = new Queen(new Vector2(), 50, 50, ResourceManager.WHITE_QUEEN);
            board.getSpots()[7][3].ocuppySpot(queenPiece);
            pieces.add(queenPiece);
            
            Piece leftKnight = new Knight(new Vector2(), 50, 50, ResourceManager.WHITE_KNIGHT);
            board.getSpots()[7][2].ocuppySpot(leftKnight);
            pieces.add(leftKnight);
            
            Piece rightKnight = leftKnight.clone();
            board.getSpots()[7][5].ocuppySpot(rightKnight);
            pieces.add(rightKnight);
            
            Piece leftBishop = new Bishop(new Vector2(), 50, 50, ResourceManager.WHITE_BISHOP);
            board.getSpots()[7][1].ocuppySpot(leftBishop);
            pieces.add(leftBishop);
            
            Piece rightBishop = leftBishop.clone();
            board.getSpots()[7][6].ocuppySpot(rightBishop);
            pieces.add(rightBishop);
            
            Piece leftRook = new Rook(new Vector2(), 50, 50, ResourceManager.WHITE_ROOK);
            board.getSpots()[7][0].ocuppySpot(leftRook);
            pieces.add(leftRook);
            
            Piece rightRook = leftRook.clone();
            board.getSpots()[7][7].ocuppySpot(rightRook);
            pieces.add(rightRook);
            
            Piece currentPawn = new Pawn(new Vector2(), 50, 50, ResourceManager.WHITE_PAWN);
            for (int i = 0; i < 8; i++) {
                Piece clonePawn = currentPawn.clone();
                board.getSpots()[6][i].ocuppySpot(clonePawn);
                pieces.add(clonePawn);
            }
            
        } else if(color == PlayerColor.BLACK){
        
            Piece kingPiece = new King(new Vector2(), 50, 50, ResourceManager.BLACK_KING);
            board.getSpots()[7][4].ocuppySpot(kingPiece);
            pieces.add(kingPiece);
            
            Piece queenPiece = new Queen(new Vector2(), 50, 50, ResourceManager.BLACK_QUEEN);
            board.getSpots()[7][3].ocuppySpot(queenPiece);
            pieces.add(queenPiece);
            
            Piece leftKnight = new Knight(new Vector2(), 50, 50, ResourceManager.BLACK_KNIGHT);
            board.getSpots()[7][2].ocuppySpot(leftKnight);
            pieces.add(leftKnight);
            
            Piece rightKnight = leftKnight.clone();
            board.getSpots()[7][5].ocuppySpot(rightKnight);
            pieces.add(rightKnight);
            
            Piece leftBishop = new Bishop(new Vector2(), 50, 50, ResourceManager.BLACK_BISHOP);
            board.getSpots()[7][1].ocuppySpot(leftBishop);
            pieces.add(leftBishop);
            
            Piece rightBishop = leftBishop.clone();
            board.getSpots()[7][6].ocuppySpot(rightBishop);
            pieces.add(rightBishop);
            
            Piece leftRook = new Rook(new Vector2(), 50, 50, ResourceManager.BLACK_ROOK);
            board.getSpots()[7][0].ocuppySpot(leftRook);
            pieces.add(leftRook);
            
            Piece rightRook = leftRook.clone();
            board.getSpots()[7][7].ocuppySpot(rightRook);
            pieces.add(rightRook);
            
            Piece currentPawn = new Pawn(new Vector2(), 50, 50, ResourceManager.BLACK_PAWN);
            for (int i = 0; i < 8; i++) {
                Piece clonePawn = currentPawn.clone();
                board.getSpots()[6][i].ocuppySpot(clonePawn);
                pieces.add(clonePawn);
            }
        }
    }
    
    public enum PlayerColor{
        WHITE, BLACK
    }
}
