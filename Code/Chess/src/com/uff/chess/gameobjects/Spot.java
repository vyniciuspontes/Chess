package com.uff.chess.gameobjects;

import com.uff.chess.gameobjects.pieces.Piece;
import com.vpontes.gameframework.math.Rectangle;
import com.vpontes.gameframework.math.Vector2;

/**
 *
 * @author Vynicius Pontes
 */
public class Spot extends GameObject implements Dynamic{

    private final Rectangle rect;
    private final String code;
    private Piece currentPiece;
    
    public Rectangle getRect() {
        return rect;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public Spot(Vector2 position, int widght, int height, String imagePath, String code) {
        super(position, widght, height, imagePath);

        this.code = code;
        rect = new Rectangle(position.getX(), position.getY(), widght, height);
    }
    
    public boolean isOcuppied() {
        return currentPiece != null;
    }
    
    public void ocuppySpot(Piece piece){
        piece.setPosition(this.getCenter(piece.getWidght(), piece.getHeight()));
        this.currentPiece = piece;
    }
    
    public void releaseSpot(){
        this.currentPiece = null;
    }

    public void mouseClicked(){
        if(this.currentPiece != null)
            System.out.println(this.code + ": " + this.currentPiece.toString());
        else
            System.out.println(this.code + ": Empty");
    }
    
    @Override
    public void update(double deltaTime) {
        
    }
}
