package com.uff.chess.gameobjects;

import com.uff.chess.gameobjects.pieces.Bishop;
import com.uff.chess.gameobjects.pieces.King;
import com.uff.chess.gameobjects.pieces.Knight;
import com.uff.chess.gameobjects.pieces.Pawn;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;
import com.uff.chess.gameobjects.pieces.Queen;
import com.uff.chess.gameobjects.pieces.Rook;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.math.OverlapTester;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Vynicius Pontes
 */
public class Board extends GameObject {

    private final Spot[][] spots = new Spot[8][8];
    private Spot whiteKingSpot;
    private Spot blackKingSpot;
    private List<Piece> pieces;
    private final BufferedImage[] blocksImages = {
        ResourceManager.WHITE_SPOT,
        ResourceManager.BLACK_SPOT
    };

    public Board(Vector2 position, int widght, int height, BufferedImage image) {
        super(position, widght, height, image);
        setupSpots();
        createPieces();
    }

    /**
     * Instancia as peças no Tabuleiro
     */
    private void createPieces() {

        pieces = new ArrayList<>();

        Piece whiteKingPiece = new King(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_KING);
        this.spots[4][7].ocuppySpot(whiteKingPiece);
        whiteKingSpot = this.spots[4][7];
        pieces.add(whiteKingPiece);

         Piece whiteQueenPiece = new Queen(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_QUEEN);
        this.spots[3][7].ocuppySpot(whiteQueenPiece);
        pieces.add(whiteQueenPiece);

        /*Piece whiteLeftKnight = new Knight(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_KNIGHT);
        this.spots[2][7].ocuppySpot(whiteLeftKnight);
        pieces.add(whiteLeftKnight);

        Piece whiteRightKnight = whiteLeftKnight.clone();
        this.spots[5][7].ocuppySpot(whiteRightKnight);
        pieces.add(whiteRightKnight);

        Piece whiteLeftBishop = new Bishop(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_BISHOP);
        this.spots[1][7].ocuppySpot(whiteLeftBishop);
        pieces.add(whiteLeftBishop);

        Piece whiteRightBishop = whiteLeftBishop.clone();
        this.spots[6][7].ocuppySpot(whiteRightBishop);
        pieces.add(whiteRightBishop);

        Piece whiteLeftRook = new Rook(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_ROOK);
        this.spots[0][7].ocuppySpot(whiteLeftRook);
        pieces.add(whiteLeftRook);

        Piece whiteRightRook = whiteLeftRook.clone();
        this.spots[7][7].ocuppySpot(whiteRightRook);
        pieces.add(whiteRightRook);*/

        /*Piece whiteCurrentPawn = new Pawn(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_PAWN);

        Piece blackCurrentPawn = new Pawn(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_PAWN);
        for (int i = 0; i < 8; i++) {
            Piece whiteClonePawn = whiteCurrentPawn.clone();
            this.spots[i][6].ocuppySpot(whiteClonePawn);
            Piece blackClonePawn = blackCurrentPawn.clone();
            this.spots[i][1].ocuppySpot(blackClonePawn);
            pieces.add(whiteClonePawn);
            pieces.add(blackClonePawn);
        }*/

        Piece blackKingPiece = new King(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_KING);
        this.spots[4][0].ocuppySpot(blackKingPiece);
        this.blackKingSpot = this.spots[4][0];
        pieces.add(blackKingPiece);

        /*Piece blackQueenPiece = new Queen(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_QUEEN);
        this.spots[3][0].ocuppySpot(blackQueenPiece);
        pieces.add(blackQueenPiece);

        Piece blackLeftKnight = new Knight(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_KNIGHT);
        this.spots[2][0].ocuppySpot(blackLeftKnight);
        pieces.add(blackLeftKnight);

        Piece blackRightKnight = blackLeftKnight.clone();
        this.spots[5][0].ocuppySpot(blackRightKnight);
        pieces.add(blackRightKnight);

        Piece blackLeftBishop = new Bishop(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_BISHOP);
        this.spots[1][0].ocuppySpot(blackLeftBishop);
        pieces.add(blackLeftBishop);

        Piece blackRightBishop = blackLeftBishop.clone();
        this.spots[6][0].ocuppySpot(blackRightBishop);
        pieces.add(blackRightBishop);

        Piece blackLeftRook = new Rook(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_ROOK);
        this.spots[0][0].ocuppySpot(blackLeftRook);
        pieces.add(blackLeftRook);

        Piece blackRightRook = blackLeftRook.clone();
        this.spots[7][0].ocuppySpot(blackRightRook);
        pieces.add(blackRightRook);*/
    }

    /**
     * Organiza os blocos em suas posicoes
     */
    private void setupSpots() {
        Integer aux = 0;
        Vector2 startPosition = new Vector2(this.getWidght() / 2 - (60 * 8) / 2, this.getHeight() / 2 - (60 * 8) / 2);
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Spot newSpot = new Spot(new Vector2((x * 60) + startPosition.getX(), (y * 60) + startPosition.getY()), 60, 60,
                        blocksImages[(x + aux) % 2], new Point(x, y), letters[y] + "" + (x + 1));
                spots[x][y] = newSpot;
            }
            if (aux == 1) {
                aux = 0;
            } else {
                aux = 1;
            }
        }
    }

    public void movePiece(Spot toSpot, Spot fromSpot, Piece piece) {

        toSpot.ocuppySpot(piece);
        fromSpot.releaseSpot();

        if (toSpot.getCurrentPiece() instanceof Pawn && ((Pawn) toSpot.getCurrentPiece()).isFirstMovement()) {
            ((Pawn) toSpot.getCurrentPiece()).setFirstMovement();
        } else if (toSpot.getCurrentPiece() instanceof King) {
            if (toSpot.getCurrentPiece().getPieceColor() == PieceColor.BLACK) {
                this.blackKingSpot = toSpot;
            } else if (toSpot.getCurrentPiece().getPieceColor() == PieceColor.WHITE) {
                this.whiteKingSpot = toSpot;
            }
        }
    }

    public Spot getSpotByPosition(Point p) {
        if (checkOutofBounds(p)) {
            return null;
        }

        return spots[p.x][p.y];
    }

    public Spot getSpotByMouseClick(Vector2 clickPosition) {

        for (Spot[] spotLine : spots) {
            for (Spot currentSpot : spotLine) {
                if (OverlapTester.pointInRectangle(currentSpot.getRect(), clickPosition)) {
                    return currentSpot;
                }
            }
        }

        return null;
    }

    /**
     * Retorna um set de spots com peças da cor recebida
     * @param pieceColor
     * @return 
     */
    public Set<Spot> getSpotByPieceColor(PieceColor pieceColor) {

        Set<Spot> spotByColor = new HashSet<>();

        for (Spot[] spot : spots) {
            for (Spot spot1 : spot) {
                if (spot1.isOcuppied() && spot1.getCurrentPiece().getPieceColor() == pieceColor) {
                    spotByColor.add(spot1);
                }
            }
        }

        return spotByColor;
    }
    
    public boolean kingInCheck(PieceColor pieceColor) {

        Set<Spot> enemyPossibleMoves = new HashSet<>();

        Set<Spot> enemyOccupiedSpots = getSpotByPieceColor(pieceColor == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE);

        enemyOccupiedSpots.forEach((enemyOccupiedSpot) -> {
            enemyPossibleMoves.addAll(this.showPossiblePaths(enemyOccupiedSpot));
        });
        
        //turnPath(true, enemyPossibleMoves);

        if (pieceColor == PieceColor.BLACK) {
            if (enemyPossibleMoves.contains(this.blackKingSpot)) {
                System.out.println("Black King in xeque".toUpperCase());
                return true;
            }
        } else if (pieceColor == PieceColor.WHITE) {
            if (enemyPossibleMoves.contains(this.whiteKingSpot)) {
                System.out.println("White King in xeque".toUpperCase());
                return true;
            }
        }
        
        //turnPath(false, enemyPossibleMoves);

        return false;
    }
    
    public boolean getWinCondition(PieceColor pieceColor){
        
        //this.turnPath(false, this.spots);
        
        PieceColor enemyColor = pieceColor == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE; 
        
        King blackKing = (King) this.blackKingSpot.getCurrentPiece();
        
        Set<Spot> myPossibleMoves = new HashSet<>();
        Set<Spot> mySpots = getSpotByPieceColor(pieceColor);
        
        
        System.out.println(mySpots);
        
        mySpots.forEach((mySpot) -> {
            myPossibleMoves.addAll(this.showPossiblePaths(mySpot));
        });
        
        //turnPath(true, myPossibleMoves);
        
        this.blackKingSpot.releaseSpot();
        
        Set<Spot> enemyPossibleMoves = new HashSet<>();
        Set<Spot> enemyOccupiedSpots = getSpotByPieceColor(enemyColor);

        enemyOccupiedSpots.forEach((enemyOccupiedSpot) -> {
            enemyPossibleMoves.addAll(this.showPossiblePaths(enemyOccupiedSpot));
        });
        
        
        myPossibleMoves.removeAll(enemyPossibleMoves);
        
        turnPath(true, myPossibleMoves);
        
        System.out.println("My " + pieceColor + " Possible Moves: " + myPossibleMoves.size());
        
        this.blackKingSpot.ocuppySpot(blackKing);
        
        return false;
    }

    public void removePiece(Spot spot) {
        spot.getCurrentPiece().setRemoved(true);
        spot.releaseSpot();
    }

    private void addContinuosPath(Point startCoordinate, Point move, Piece piece, List<Spot> spotList) {
        startCoordinate.setLocation(startCoordinate.x + move.x, startCoordinate.y + move.y);
        Spot s = getSpotByPosition(startCoordinate);
        if (!checkOutofBounds(startCoordinate)) {
            if (!s.isOcuppied()) {
                spotList.add(s);
                addContinuosPath(startCoordinate, move, piece, spotList);
            } else if (s.getCurrentPiece().getPieceColor() != piece.getPieceColor()) {
                spotList.add(s);
            }
        }

    }

    public List<Spot> showPossiblePaths(Spot spot) {

        List<Spot> selectedSpots = new ArrayList<>();
        
        int direction = spot.getCurrentPiece().getPieceColor() == PieceColor.WHITE ? -1 : 1;

        Point moveCoordinate = new Point();
        if (spot.getCurrentPiece().isContinuous()) {
            for (int[] move : spot.getCurrentPiece().getMovements()) {
                moveCoordinate.x = move[0];
                moveCoordinate.y = move[1] * direction;
                addContinuosPath(new Point(spot.getBoardCoordinate()),
                        moveCoordinate, spot.getCurrentPiece(), selectedSpots);
            }
        } else {
            for (int[] move : spot.getCurrentPiece().getMovements()) {
                moveCoordinate.x = move[0];
                moveCoordinate.y = move[1] * direction;
                if (!checkOutofBounds(spot.getBoardCoordinate(), moveCoordinate)) {
                    Spot movementSpot = getSpotByPosition(new Point(spot.getBoardCoordinate().x + moveCoordinate.x, spot.getBoardCoordinate().y + moveCoordinate.y));
                    //peao possui movimentacao diferenciada
                    if (spot.getCurrentPiece() instanceof Pawn) {

                        boolean isAttackMovement = false;
                        //checa se o movimento da iteracao e um movimento de ataque do peao
                        for (int[] movement : ((Pawn) spot.getCurrentPiece()).getAttackMovements()) {
                            if (Arrays.equals(movement, move)) {
                                isAttackMovement = true;
                                break;
                            }
                        }

                        if ((isAttackMovement && movementSpot.isOcuppied() && spot.getCurrentPiece().getPieceColor() != movementSpot.getCurrentPiece().getPieceColor())
                                || (!isAttackMovement && !movementSpot.isOcuppied())) {
                            selectedSpots.add(movementSpot);
                        }
                    } else if (!movementSpot.isOcuppied() || spot.getCurrentPiece().getPieceColor() != movementSpot.getCurrentPiece().getPieceColor()) {

                        selectedSpots.add(movementSpot);
                    }
                }
            }
        }

        return selectedSpots;
    }

    public void turnPath(boolean on, Collection<Spot> spotList) {
        spotList.forEach((selectedSpot) -> {
            selectedSpot.setSelected(on);
        });
    }
    
    public void turnPath(boolean on, Spot[][] spotArray) {
        for (Spot[] spots1 : spotArray) {
            for (Spot spot : spots1) {
                spot.setSelected(on);
            }
        }
    }

    private boolean checkOutofBounds(Point current) {
        return checkOutofBounds(current, new Point(0, 0));
    }

    private boolean checkOutofBounds(Point current, Point move) {
        return !(current.x + move.x < 8 && current.x + move.x >= 0 && current.y + move.y >= 0 && current.y + move.y < 8);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Spot[] spotY : spots) {
            for (Spot spotX : spotY) {
                spotX.draw(g);
            }
        }
        
        pieces.forEach((piece) -> {
            if (!piece.isRemoved()) {
                piece.draw(g);
            }
        });
    }

}
