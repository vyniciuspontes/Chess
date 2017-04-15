package com.uff.chess.gameobjects;

import com.vpontes.gameframework.math.Rectangle;
import com.vpontes.gameframework.math.Vector2;

/**
 *
 * @author Vynicius Pontes
 */
public class Spot extends GameObject implements Dynamic{

    private final Rectangle rect;
    private final String code;

    public Rectangle getRect() {
        return rect;
    }

    public Spot(Vector2 position, int widght, int height, String imagePath, String code) {
        super(position, widght, height, imagePath);

        this.code = code;
        rect = new Rectangle(position.getX(), position.getY(), widght, height);
    }

    public void mouseClicked(){
        System.out.println(this.code);
    }
    
    @Override
    public void update(double deltaTime) {
        
    }
}
