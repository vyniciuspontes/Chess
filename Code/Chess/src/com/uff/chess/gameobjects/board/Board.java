package com.uff.chess.gameobjects.board;

import com.uff.chess.gameobjects.GameObject;
import com.uff.chess.gameobjects.pieces.Bishop;
import com.uff.chess.gameobjects.pieces.King;
import com.uff.chess.gameobjects.pieces.Knight;
import com.uff.chess.gameobjects.pieces.Pawn;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.gameobjects.pieces.Piece.PieceColor;
import com.uff.chess.gameobjects.pieces.Queen;
import com.uff.chess.gameobjects.pieces.Rook;
import com.uff.chess.screens.PawnPromotion;
import com.uff.chess.screens.PawnPromotion.PromotionPiece;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.core.Game;
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
import java.util.stream.Collectors;

/**
 *
 * @author Vynicius Pontes
 */
public class Board extends GameObject {

    private final Spot[][] spots = new Spot[8][8];
    private Spot whiteKingSpot;
    private Spot blackKingSpot;
    private List<Piece> pieces;
    private Game game;
    private final BufferedImage[] blocksImages = {
        ResourceManager.WHITE_SPOT,
        ResourceManager.BLACK_SPOT
    };

    public static enum RoqueStatus 
    {
        RoqueLeft,
        RoqueRight,
        RoqueBoth,
        NoRoque,
    }
    
    public Board(Vector2 position, int widght, int height, BufferedImage image) {
        super(position, widght, height, image);
        
        this.pieces = new ArrayList<>();
    }
    
    public Board(Vector2 position, int widght, int height, BufferedImage image, Game game) {
        super(position, widght, height, image);
        
        this.pieces = new ArrayList<>();
        this.game = game;
    }
    
    /**
     * Instancia as peças no Tabuleiro
     */
    public void createDefaultPieces() {

        /*Piece whiteKingPiece = new King(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_KING);
        this.spots[4][7].ocuppySpot(whiteKingPiece);
        whiteKingSpot = this.spots[4][7];
        pieces.add(whiteKingPiece);

        Piece whiteQueenPiece = new Queen(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_QUEEN);
        this.spots[3][7].ocuppySpot(whiteQueenPiece);
        pieces.add(whiteQueenPiece);

        Piece blackKingPiece = new King(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_KING);
        this.spots[4][0].ocuppySpot(blackKingPiece);
        this.blackKingSpot = this.spots[4][0];
        pieces.add(blackKingPiece);

        Piece blackQueenPiece = new Queen(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_QUEEN);
        this.spots[3][0].ocuppySpot(blackQueenPiece);
        pieces.add(blackQueenPiece);

        Piece whiteLeftBishop = new Bishop(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_BISHOP);
        this.spots[2][7].ocuppySpot(whiteLeftBishop);
        pieces.add(whiteLeftBishop);

        Piece whiteRightBishop = whiteLeftBishop.clone();
        this.spots[5][7].ocuppySpot(whiteRightBishop);
        pieces.add(whiteRightBishop);

        Piece whiteCurrentPawn = new Pawn(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_PAWN);
        this.spots[1][2].ocuppySpot(whiteCurrentPawn);
        pieces.add(whiteCurrentPawn);
        
        Piece blackCurrentPawn = new Pawn(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_PAWN);
        this.spots[1][5].ocuppySpot(blackCurrentPawn);
        pieces.add(blackCurrentPawn);*/
        
        Piece whiteKingPiece = new King(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_KING);
        this.spots[4][7].ocuppySpot(whiteKingPiece);
        whiteKingSpot = this.spots[4][7];
        pieces.add(whiteKingPiece);

        Piece whiteQueenPiece = new Queen(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_QUEEN);
        this.spots[3][7].ocuppySpot(whiteQueenPiece);
        pieces.add(whiteQueenPiece);
        

        Piece whiteLeftKnight = new Knight(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_KNIGHT);
        this.spots[1][7].ocuppySpot(whiteLeftKnight);
        pieces.add(whiteLeftKnight);

        Piece whiteRightKnight = whiteLeftKnight.clone();
        this.spots[6][7].ocuppySpot(whiteRightKnight);
        pieces.add(whiteRightKnight);

        Piece whiteLeftBishop = new Bishop(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_BISHOP);
        this.spots[2][7].ocuppySpot(whiteLeftBishop);
        pieces.add(whiteLeftBishop);

        Piece whiteRightBishop = whiteLeftBishop.clone();
        this.spots[5][7].ocuppySpot(whiteRightBishop);
        pieces.add(whiteRightBishop);

        Piece whiteLeftRook = new Rook(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_ROOK);
        this.spots[0][7].ocuppySpot(whiteLeftRook);
        pieces.add(whiteLeftRook);

        Piece whiteRightRook = whiteLeftRook.clone();
        this.spots[7][7].ocuppySpot(whiteRightRook);
        pieces.add(whiteRightRook);

        Piece whiteCurrentPawn = new Pawn(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_PAWN);

        Piece blackCurrentPawn = new Pawn(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_PAWN);
        for (int i = 0; i < 8; i++) {
            Piece whiteClonePawn = whiteCurrentPawn.clone();
            this.spots[i][6].ocuppySpot(whiteClonePawn);
            Piece blackClonePawn = blackCurrentPawn.clone();
            this.spots[i][1].ocuppySpot(blackClonePawn);
            pieces.add(whiteClonePawn);
            pieces.add(blackClonePawn);
        }

        Piece blackKingPiece = new King(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_KING);
        this.spots[4][0].ocuppySpot(blackKingPiece);
        this.blackKingSpot = this.spots[4][0];
        pieces.add(blackKingPiece);

        Piece blackQueenPiece = new Queen(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_QUEEN);
        this.spots[3][0].ocuppySpot(blackQueenPiece);
        pieces.add(blackQueenPiece);

        Piece blackLeftKnight = new Knight(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_KNIGHT);
        this.spots[1][0].ocuppySpot(blackLeftKnight);
        pieces.add(blackLeftKnight);

        Piece blackRightKnight = blackLeftKnight.clone();
        this.spots[6][0].ocuppySpot(blackRightKnight);
        pieces.add(blackRightKnight);

        Piece blackLeftBishop = new Bishop(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_BISHOP);
        this.spots[2][0].ocuppySpot(blackLeftBishop);
        pieces.add(blackLeftBishop);

        Piece blackRightBishop = blackLeftBishop.clone();
        this.spots[5][0].ocuppySpot(blackRightBishop);
        pieces.add(blackRightBishop);

        Piece blackLeftRook = new Rook(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_ROOK);
        this.spots[0][0].ocuppySpot(blackLeftRook);
        pieces.add(blackLeftRook);

        Piece blackRightRook = blackLeftRook.clone();
        this.spots[7][0].ocuppySpot(blackRightRook);
        pieces.add(blackRightRook);
    }

    /**
     * Organiza os blocos em suas posicoes
     */
    public void setupSpots() {
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
    
    private boolean isLastSpot(Spot spot, PieceColor color){
        if(color == PieceColor.WHITE){
            for (Spot[] spot1 : spots) {
                
                if (spot.equals(spot1[0])) {
                    return true;
                }
            }
        }else{
            for (Spot[] spot1 : spots) {
                
                if (spot.equals(spot1[7])) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private void pawnPromotion(Spot spot){
        PromotionPiece promotionPiece = null;
        PawnPromotion dialog = null;
        do{
            dialog = new PawnPromotion(this.game.getFrame());
            dialog.setVisible(true);
            promotionPiece = dialog.getPromotionPiece();
        }while(promotionPiece == null);
        
        
        PieceColor color = spot.getCurrentPiece().getPieceColor();
        this.removePiece(spot);
        Piece newPiece = null;
        switch(dialog.getPromotionPiece()){
            case QUEEN:
                if(color == PieceColor.WHITE){
                    newPiece = new Queen(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_QUEEN);
                }else {
                    newPiece = new Queen(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_QUEEN);
                }
                spot.ocuppySpot(newPiece);
                pieces.add(newPiece);
                break;
            case BISHOP:
                if(color == PieceColor.WHITE){
                    newPiece = new Bishop(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_BISHOP);
                }else {
                    newPiece = new Bishop(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_BISHOP);
                }
                break;
            case KNIGHT:
                if(color == PieceColor.WHITE){
                    newPiece = new Knight(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_KNIGHT);
                }else {
                    newPiece = new Knight(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_KNIGHT);
                }
                break;
            case ROOK:
                if(color == PieceColor.WHITE){
                    newPiece = new Rook(new Vector2(), 50, 50, PieceColor.WHITE, ResourceManager.WHITE_ROOK);
                }else {
                    newPiece = new Rook(new Vector2(), 50, 50, PieceColor.BLACK, ResourceManager.BLACK_ROOK);
                }
                break;
        }
        
        
        spot.ocuppySpot(newPiece);
        pieces.add(newPiece);
    }

    /**
     * Move uma peça de um spot para outro
     *
     * @param toSpot
     * @param fromSpot
     * @param piece
     */
    public void movePiece(Spot toSpot, Spot fromSpot, Piece piece) {

        if(toSpot.isOcuppied()){
            if(fromSpot.getCurrentPiece().getPieceColor() != toSpot.getCurrentPiece().getPieceColor()){
                removePiece(toSpot);
            }
        }
        
        toSpot.ocuppySpot(piece);
        fromSpot.releaseSpot();

        if (toSpot.getCurrentPiece() instanceof Pawn ) {
            Pawn pawn = (Pawn) toSpot.getCurrentPiece();
            if(pawn.isFirstMovement()){
                pawn.setFirstMovement();
            }else if(isLastSpot(toSpot, pawn.getPieceColor())){
                pawnPromotion(toSpot);
            }
        } else if (toSpot.getCurrentPiece() instanceof King) {
            if (toSpot.getCurrentPiece().getPieceColor() == PieceColor.BLACK) 
            {
                this.blackKingSpot = toSpot;
                //Executa o roque caso o rei tenha andado 2 a esquerda ou direita
                if(toSpot == spots[2][0] && canRoque(toSpot) != RoqueStatus.NoRoque)
                {
                    movePiece(spots[3][0],spots[0][0], spots[0][0].getCurrentPiece());
                }
                else if(toSpot == spots[6][0] && canRoque(toSpot) != RoqueStatus.NoRoque)
                {
                    movePiece(spots[5][0],spots[7][0], spots[7][0].getCurrentPiece());
                }
            } 
            else if (toSpot.getCurrentPiece().getPieceColor() == PieceColor.WHITE) 
            {
                this.whiteKingSpot = toSpot;
                
                //Executa o roque caso o rei tenha andado 2 a esquerda ou direita
                if(toSpot == spots[2][7] && canRoque(toSpot) != RoqueStatus.NoRoque)
                {
                    movePiece(spots[3][7],spots[0][7], spots[0][7].getCurrentPiece());
                }
                else if(toSpot == spots[6][7] && canRoque(toSpot) != RoqueStatus.NoRoque)
                {
                    movePiece(spots[5][7],spots[7][7], spots[7][7].getCurrentPiece());
                }
            }
        }
    }

    /**
     * Retorna um spot a partir de uma posicao x e y
     *
     * @param p
     * @return
     */
    public Spot getSpotByPosition(Point p) {
        if (checkOutofBounds(p)) {
            return null;
        }

        return spots[p.x][p.y];
    }

    /**
     * Retorna uma spot a partir de um Vector2
     *
     * @param clickPosition
     * @return
     */
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
     *
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

    /**
     * Verifica se o rei esta em xeque em uma dada posicao
     *
     * @param pieceColor cor do rei
     * @param kingSpot posicao a ser veririficada
     * @return
     */
    public boolean kingInCheck(PieceColor pieceColor, Spot kingSpot) {

        Set<Spot> enemyPossibleMoves = new HashSet<>();

        Set<Spot> enemyOccupiedSpots = getSpotByPieceColor(pieceColor == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE);

        enemyOccupiedSpots.forEach((enemyOccupiedSpot) -> {
            enemyPossibleMoves.addAll(this.getPiecePathKingCheck(enemyOccupiedSpot));
        });

        if (pieceColor == PieceColor.BLACK) {

            if (enemyPossibleMoves.contains(kingSpot)) {
                return true;
            }
        } else if (pieceColor == PieceColor.WHITE) {
            if (enemyPossibleMoves.contains(kingSpot)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Retorna um set de spots os quais todas as peças de uma determinada cor
     * pode mover
     *
     * @param pieceColor
     * @param considerMyColorPieces
     * @return
     */
    public Set<Spot> getPossibleMovesByColor(PieceColor pieceColor, boolean considerMyColorPieces) {

        Set<Spot> possibleSpotMoves = new HashSet<>();

        Set<Spot> colorOccupiedSpots = getSpotByPieceColor(pieceColor);
        colorOccupiedSpots.forEach((occupiedSpot) -> {
            possibleSpotMoves.addAll(this.getPiecePath(occupiedSpot, considerMyColorPieces, false));
        });

        return possibleSpotMoves;
    }

    /**
     * Verifica se o jogo acabou
     *
     * @param pieceColor cor do lado a ser verificado
     * @return caso os possiveis movimentos de um lado forem igual a 0 o jogo
     * acabou
     */
    public boolean getWinCondition(PieceColor pieceColor) {

        Set<Spot> possibleMoves = new HashSet<>();
        Set<Spot> currentColorPiecesSpots = getSpotByPieceColor(pieceColor);

        currentColorPiecesSpots.forEach((spot) -> {
            possibleMoves.addAll(this.getPossibleMoves(spot));
        });

        System.out.println(pieceColor + " side possible moves: " + possibleMoves.size());

        return possibleMoves.size() <= 0;
    }
    
    /**
     * Verifica se o spot sendo ocupado por uma peça aliada este pode previnir um xeque
     * @param spot
     * @param kingPosition
     * @param color
     * @return 
     */
    private boolean checkIfSpotIsPreventative(Spot spot, Spot kingPosition, PieceColor color) {

        boolean b;

        if (spot.getCurrentPiece() == null) {
            spot.ocuppySpot(new Pawn(new Vector2(), 0, 0, color, null));
            b = this.kingInCheck(color, kingPosition);
            spot.releaseSpot();
        }else{
            Piece currentPiece = spot.getCurrentPiece();
            spot.releaseSpot();
            b = this.kingInCheck(color, kingPosition);
            spot.ocuppySpot(currentPiece);
        }

        return !b;
    }

    /**
     * Faz uma busca logica dos possiveis movimentos dado um spot com peça e os retorna num set
     * @param spot
     * @return 
     */
    public Set<Spot> getPossibleMoves(Spot spot) {

        if (spot == null || spot.getCurrentPiece() == null) {
            return new HashSet<>();
        }

        //clearAllSelectedSpots();
        
        
        
        PieceColor pieceColor = spot.getCurrentPiece().getPieceColor();

        PieceColor enemyColor = pieceColor == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE;
        Spot currentKingSpot;
        King currentKing;

        if (pieceColor == PieceColor.WHITE) {
            currentKingSpot = whiteKingSpot;
            currentKing = (King) this.whiteKingSpot.getCurrentPiece();
        } else {
            currentKingSpot = blackKingSpot;
            currentKing = (King) this.blackKingSpot.getCurrentPiece();
        }
        
        /*if(!checkIfSpotIsPreventative(spot, currentKingSpot, PieceColor.WHITE)){
            
            return new HashSet<>();
        }*/

        Set<Spot> possibleMoves = this.getPiecePath(spot);

        currentKingSpot.releaseSpot();

        Set<Spot> enemyPossibleMoves = getPossibleMovesByColor(enemyColor, false);

        currentKingSpot.ocuppySpot(currentKing);

        //turnPath(true, enemyPossibleMoves);
        
        Set<Spot> kingPossibleMoves = this.getPiecePath(currentKingSpot);

        if (spot.getCurrentPiece() instanceof King) {
            possibleMoves.removeIf(p
                    -> 
                    (
                        p.getCurrentPiece() == null && (kingPossibleMoves.contains(p) && kingInCheck(pieceColor, p))
                    )
                    || enemyPossibleMoves.contains(p));

        } else if (kingInCheck(pieceColor, currentKingSpot)) {

            possibleMoves.removeIf(p
                    -> !checkIfSpotIsPreventative(p, currentKingSpot, pieceColor));

        }

        return possibleMoves;
    }

    public void addPieceToSpot(Point spotPosition, Piece piece){
        
        if(piece != null && piece instanceof King){
            if(piece.getPieceColor() == PieceColor.WHITE)
                this.whiteKingSpot = this.spots[spotPosition.x][spotPosition.y];
            else
                this.blackKingSpot = this.spots[spotPosition.x][spotPosition.y];
        }
        
        this.spots[spotPosition.x][spotPosition.y].ocuppySpot(piece);
    }
    
    /**
     * Remove uma peça de jogo
     * @param spot 
     */
    public void removePiece(Spot spot) {
        spot.getCurrentPiece().setRemoved(true);
        spot.releaseSpot();
    }

    /**
     * Calcula os movimentos de peças continuas
     * @param startCoordinate
     * @param move
     * @param piece
     * @param spotList
     * @param considerBoardPieces 
     */
    private void addContinuosPath(Point startCoordinate, Point move, Piece piece, Set<Spot> spotList, boolean considerBoardPieces) {
        startCoordinate.setLocation(startCoordinate.x + move.x, startCoordinate.y + move.y);
        Spot s = getSpotByPosition(startCoordinate);
        if (!checkOutofBounds(startCoordinate)) {
            if (!s.isOcuppied()) {
                spotList.add(s);
                addContinuosPath(startCoordinate, move, piece, spotList, considerBoardPieces);
            } else if (s.getCurrentPiece().getPieceColor() != piece.getPieceColor() || !considerBoardPieces) {
                spotList.add(s);
            }
        }

    }

    private Set<Spot> getPiecePathKingCheck(Spot spot) {
        return Board.this.getPiecePath(spot, true, true);
    }
    
    
    public RoqueStatus canRoque(Spot spot)
    {
        RoqueStatus roqueStatus = RoqueStatus.NoRoque;
        //Retorna falso caso a peça tenha sido movida anteriormente
        if(spot.getCurrentPiece().getMoved())
        {
            return roqueStatus;
        }
        
        //Retorna falso se o rei está em check
        if(kingInCheck(spot.getCurrentPiece().getPieceColor(), spot))
        {
            return roqueStatus;
        }
        
        
        if(spot.getCurrentPiece().getPieceColor() == PieceColor.BLACK)
        {
            roqueStatus = RoqueStatus.RoqueLeft;
            
            //Se a casa da torre a esquerda não está ocupada, se a peça já se movou, ou se não é uma torre ele retorna falso
            if (spots[0][0].isOcuppied() && spots[0][0].getCurrentPiece() != null && 
                    spots[0][0].getCurrentPiece().getMoved() && spots[0][0].getCurrentPiece() instanceof Rook == false)
            {
                roqueStatus = RoqueStatus.NoRoque;
            }

            //retorna falso se algum espaço entre o rei e a torre estiver ocupado
            
            if (spots[1][0].isOcuppied() || (spots[2][0].isOcuppied() && (spots[2][0].getCurrentPiece() instanceof King && 
                    spots[2][0].getCurrentPiece().getMoved())) || spots[3][0].isOcuppied())
            {
                roqueStatus = RoqueStatus.NoRoque;
            }            
            
            //Se a casa da torre a direita não está ocupada, se a peça já se movou, ou se não é uma torre ele retorna falso
            if (spots[7][0].isOcuppied() && !spots[7][0].getCurrentPiece().getMoved() && (spots[7][0].getCurrentPiece() instanceof Rook)) 
            {
                if(roqueStatus == RoqueStatus.RoqueLeft)
                {
                    roqueStatus = RoqueStatus.RoqueBoth;
                }
                else
                {
                    roqueStatus = RoqueStatus.RoqueRight;
                }
            }
            
            //retorna falso se algum espaço entre o rei e a torre estiver ocupado
            if ((!spots[6][0].isOcuppied() || (spots[6][0].getCurrentPiece() instanceof King && 
                    !spots[6][0].getCurrentPiece().getMoved())) && (!spots[5][0].isOcuppied() || (spots[5][0].getCurrentPiece() instanceof King && 
                    !spots[5][0].getCurrentPiece().getMoved()))
                && spots[7][0].isOcuppied() && !spots[7][0].getCurrentPiece().getMoved() && (spots[7][0].getCurrentPiece() instanceof Rook))
            {
                if(roqueStatus == RoqueStatus.NoRoque)
                {
                    roqueStatus = RoqueStatus.RoqueRight;
                }
            }
            else
            {
                if(roqueStatus == RoqueStatus.RoqueBoth)
                {
                    roqueStatus = RoqueStatus.RoqueLeft;
                }
                else
                {
                    roqueStatus = RoqueStatus.NoRoque;
                }
            }
        }
        else
        {
            roqueStatus = RoqueStatus.RoqueLeft;
            
            //Se a casa da torre a esquerda não está ocupada, se a peça já se movou, ou se não é uma torre ele retorna falso
            if (!spots[0][7].isOcuppied() || spots[0][7].getCurrentPiece().getMoved() || spots[0][7].getCurrentPiece() instanceof Rook == false) 
            {
                roqueStatus = RoqueStatus.NoRoque;
            }

            //retorna falso se algum espaço entre o rei e a torre estiver ocupado
            if (spots[1][7].isOcuppied() || (spots[2][7].isOcuppied() && !(spots[2][7].getCurrentPiece() instanceof King && 
                    !spots[2][7].getCurrentPiece().getMoved()) || spots[3][7].isOcuppied()))
            {
                roqueStatus = RoqueStatus.NoRoque;
            }            
            
            //Se a casa da torre a direita não está ocupada, se a peça já se movou, ou se não é uma torre ele retorna falso
            if (spots[7][7].isOcuppied() && !spots[7][7].getCurrentPiece().getMoved() && spots[7][7].getCurrentPiece() instanceof Rook) 
            {
                if(roqueStatus == RoqueStatus.RoqueLeft)
                {
                    roqueStatus = RoqueStatus.RoqueBoth;
                }
                else
                {
                    roqueStatus = RoqueStatus.RoqueRight;
                }
            }
            
            //retorna falso se algum espaço entre o rei e a torre estiver ocupado
            if ((!spots[6][7].isOcuppied() || !spots[5][7].isOcuppied()) && spots[7][7].isOcuppied() && 
                    !spots[7][7].getCurrentPiece().getMoved() && spots[7][7].getCurrentPiece() instanceof Rook)
            {
                if(roqueStatus == RoqueStatus.NoRoque)
                {
                    roqueStatus = RoqueStatus.RoqueRight;
                }
            }
            else
            {
                if(roqueStatus == RoqueStatus.RoqueBoth)
                {
                    roqueStatus = RoqueStatus.RoqueLeft;
                }
                else
                {
                    roqueStatus = RoqueStatus.NoRoque;
                }
            }
        }
        
        return roqueStatus;
    }
    
    
    private Set<Spot> getPiecePath(Spot spot) {
        return Board.this.getPiecePath(spot, true, false);
    }

    private Set<Spot> getPiecePath(Spot spot, boolean considerBoardPieces, boolean isChekingMoves) {

        Set<Spot> selectedSpots = new HashSet<>();

        int direction = spot.getCurrentPiece().getPieceColor() == PieceColor.WHITE ? -1 : 1;

        
        if(!isChekingMoves && spot.getCurrentPiece() instanceof King && spot.getCurrentPiece().getMoved() == false)
        {
            RoqueStatus roqueStatus = canRoque(spot);
            if(roqueStatus == RoqueStatus.RoqueLeft)
            {
                if(direction == -1)
                {
                    selectedSpots.add(spots[2][7]);
                }
                else
                {
                    selectedSpots.add(spots[2][0]);
                }
            }
            else if (roqueStatus == RoqueStatus.RoqueRight)
            {
                if(direction == -1)
                {
                    selectedSpots.add(spots[6][7]);
                }
                else
                {
                    selectedSpots.add(spots[6][0]);
                }
            }
            else if (roqueStatus == RoqueStatus.RoqueBoth)
            {
                if(direction == -1)
                {
                    selectedSpots.add(spots[2][7]);
                    selectedSpots.add(spots[6][7]);
                }
                else
                {
                    selectedSpots.add(spots[2][0]);
                    selectedSpots.add(spots[6][0]);
                }
            }
        }
        
        
        Point moveCoordinate = new Point();
        if (spot.getCurrentPiece().isContinuous()) {
            for (int[] move : spot.getCurrentPiece().getMovements()) {
                moveCoordinate.x = move[0];
                moveCoordinate.y = move[1] * direction;
                addContinuosPath(new Point(spot.getBoardCoordinate()),
                        moveCoordinate, spot.getCurrentPiece(), selectedSpots, considerBoardPieces);
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
                                || !considerBoardPieces
                                || (!isAttackMovement && !movementSpot.isOcuppied())) {
                            selectedSpots.add(movementSpot);
                        }
                    } else if (!movementSpot.isOcuppied() || spot.getCurrentPiece().getPieceColor() != movementSpot.getCurrentPiece().getPieceColor() || !considerBoardPieces) {

                        selectedSpots.add(movementSpot);
                    }
                }
            }
        }

        return selectedSpots;
    }

    public void clearAllSelectedSpots() {
        this.turnPath(false, spots);
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
    
    public Set<Spot> getSpotsWithPossibleMoves(PieceColor pieceColor){
        Set<Spot> pieceSpots = getSpotByPieceColor(pieceColor);
        
        return pieceSpots.stream().filter(p -> this.getPossibleMoves(p).size() > 0).collect(Collectors.toSet());
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
