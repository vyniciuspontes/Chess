package com.uff.chess.gameobjects;

import com.uff.chess.gameobjects.pieces.Pawn;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.math.Rectangle;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Vynicius Pontes
 */
public class Spot extends GameObject implements Dynamic {

    private final Rectangle rect;
    private final String code;
    private Piece currentPiece;
    private final Point boardCoordinate;
    private boolean selected;
    private BufferedImage currentImage;
    private BufferedImage selectedImage;

    public Rectangle getRect() {
        return rect;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public Point getBoardCoordinate() {
        return boardCoordinate;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        
        if(selected)
            this.currentImage = selectedImage;
        else
            this.currentImage = this.image;
        
        this.selected = selected;
    }

    public Spot(Vector2 position, int widght, int height, BufferedImage image, Point boardCoordinate, String code) {
        super(position, widght, height, image);
        selected = false;
        this.code = code;
        this.boardCoordinate = boardCoordinate;
        rect = new Rectangle(position.getX(), position.getY(), widght, height);
        selectedImage = ResourceManager.SELECTED_SPOT;
        currentImage = image;
    }

    public boolean isOcuppied() {
        return currentPiece != null;
    }

    public void ocuppySpot(Piece piece) {
        piece.setPosition(this.getCenter(piece.getWidght(), piece.getHeight()));
        this.currentPiece = piece;
    }

    public void releaseSpot() {
        this.currentPiece = null;
    }

    public void mouseClicked() {
        if (this.currentPiece != null) {
            System.out.println(this.code + ": " + this.currentPiece.toString() + " : " + boardCoordinate.toString());
        } else {
            System.out.println(this.code + ": Empty");
        }
    }
    
    @Override
    public void draw(Graphics g){
        super.draw(g, currentImage);
    }

    @Override
    public void update(double deltaTime) {
    }
}
