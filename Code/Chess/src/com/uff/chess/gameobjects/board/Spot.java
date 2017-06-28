package com.uff.chess.gameobjects.board;

import com.uff.chess.gameobjects.Dynamic;
import com.uff.chess.gameobjects.GameObject;
import com.uff.chess.gameobjects.pieces.Pawn;
import com.uff.chess.gameobjects.pieces.Piece;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.math.Rectangle;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Objects;

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

        if (selected) {
            this.currentImage = selectedImage;
        } else {
            this.currentImage = this.image;
        }

        this.selected = selected;
    }
    
    public Spot(String code){
        super(new Vector2(), 0, 0);
        this.boardCoordinate = new Point();
        this.rect = new Rectangle(0, 0, 0, 0);
        selected = false;
        this.code = code;
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
            System.out.println("SELECTED " + this.currentPiece.getPieceColor() + " " + this.currentPiece.toString().toUpperCase() + " - " + this.code);
        } else {
            System.out.println(this.code + ": Empty");
        }
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return this.code;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g, currentImage);
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Spot other = (Spot) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

}
